package com.chuwa.redbook.service.implementation;


import com.chuwa.redbook.exceptions.ResourcesNotFoundException;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.payload.PostResponse;
import com.chuwa.redbook.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {


    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

//    private PostDTO mapPostEntityToDTO(Post post){
//        PostDTO response = new PostDTO();
//
//        response.setId(post.getId());
//        response.setTitle(post.getTitle());
//        response.setContent(post.getContent());
//        response.setDescription(post.getDescription());
//
//        return response;
//    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
//        Post postToBeSaved = new Post();
//        postToBeSaved.setTitle(postDTO.getTitle());
//        postToBeSaved.setContent(postDTO.getContent());
//        postToBeSaved.setDescription(postDTO.getDescription());
//        Post savedPost = this.postRepository.save(postToBeSaved);
//        return mapPostEntityToDTO(savedPost);
        Post postToBeSaved = modelMapper.map(postDTO, Post.class);
        Post savedPost = this.postRepository.save(postToBeSaved);
        return modelMapper.map(savedPost, PostDTO.class);
    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();

//        return posts.stream().map(this::mapPostEntityToDTO).toList();
        return posts.stream().map(post -> modelMapper.map(post, PostDTO.class)).toList();
    }

    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> pagePosts = postRepository.findAll(pageRequest);

        List<Post> posts = pagePosts.getContent();
        List<PostDTO> postDTOs = posts.stream().map(post -> modelMapper.map(post, PostDTO.class)).toList();

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDTOs);
        postResponse.setPageNo(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalElements(pagePosts.getTotalElements());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setLast(pagePosts.isLast());
        return postResponse;
    }

    @Override
    public PostDTO getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("Post", "id", id));

        return modelMapper.map(post, PostDTO.class);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("Post", "id", id));

        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());

        Post updatedPost = postRepository.save(post);
        return modelMapper.map(updatedPost, PostDTO.class);
    }

    @Override
    public void deletePostById(long id) {
        postRepository.findById(id).orElseThrow( ()-> new ResourcesNotFoundException("Post", "id", id));
        postRepository.deleteById(id);
    }
}

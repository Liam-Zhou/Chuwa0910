package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostJPQLRepository;
import com.chuwa.redbook.exception.ResourcesNotFoundException;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.payload.PostResponse;
import com.chuwa.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    @Autowired
    PostJPQLRepository postJPQLRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Post postToBeSaved = new Post();
        postToBeSaved.setTitle(postDTO.getTitle());
        postToBeSaved.setContent(postDTO.getContent());
        postToBeSaved.setDescription(postDTO.getDescription());
        Post savedPost = this.postRepository.save(postToBeSaved);
/*        PostDTO response = new PostDTO();
        response.setId(savedPost.getId());
        response.setTitle(savedPost.getTitle());
        response.setDescription(savedPost.getDescription());
        response.setContent(savedPost.getContent());*/
        return mapPostEntityToDto(savedPost);
    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDTO> response = posts.stream().map(post->mapPostEntityToDto(post)).collect(Collectors.toList());
        return response;
    }

    @Override
    public PostDTO getPostDTOById(long id) {
        Post post = postRepository.findById(id).orElseThrow(()->new ResourcesNotFoundException("Post","id",id));
        return mapPostEntityToDto(post);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, long id) {

        Post postToUpdate = postRepository.findById(id).orElseThrow(()->new ResourcesNotFoundException("Post","id",id));
        postToUpdate.setTitle(postDTO.getTitle());
        postToUpdate.setDescription(postDTO.getDescription());
        postToUpdate.setContent(postDTO.getContent());
        Post updatePost = postRepository.save(postToUpdate);
        return mapPostEntityToDto(updatePost);
    }

    @Override
    public String deletePostById(long id) {
        Post postToDelete = postRepository.findById(id).orElseThrow(()->new ResourcesNotFoundException("Post","id",id));
        postRepository.delete(postToDelete);
        return "Successfully deleted";
    }

    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> pagePosts = postRepository.findAll(pageRequest);

        List<Post> posts = pagePosts.getContent();
        List<PostDTO> postDtos = posts.stream().map(post -> mapPostEntityToDto(post)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNo(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalElements(pagePosts.getTotalElements());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setLast(pagePosts.isLast());
        return postResponse;
    }

    @Override
    public List<PostDTO> getAllPostWithJPQL() {
        return postJPQLRepository.getAllPostWithJPQL().stream().map(post -> mapPostEntityToDto(post)).collect(Collectors.toList());
    }

    @Override
    public PostDTO getPostByIdJPQLIndexParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithJPQLIndexParameters(id, title);
        return mapPostEntityToDto(post);
    }

    @Override
    public PostDTO getPostByIdJPQLNamedParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithJPQLNamedParameters(id, title);
        return mapPostEntityToDto(post);
    }

    @Override
    public PostDTO getPostByIdSQLIndexParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithSQLIndexParameters(id, title);
        return mapPostEntityToDto(post);
    }

    @Override
    public PostDTO getPostByIdSQLNamedParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithSQLNamedParameters(id, title);
        return mapPostEntityToDto(post);
    }

    private PostDTO mapPostEntityToDto(Post savedPost){
        PostDTO response = new PostDTO();
        response.setId(savedPost.getId());
        response.setTitle(savedPost.getTitle());
        response.setDescription(savedPost.getDescription());
        response.setContent(savedPost.getContent());
        return response;
    }
}

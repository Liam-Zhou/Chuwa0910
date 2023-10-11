package com.chuwa.redbookblog.service.impl;

import com.chuwa.redbookblog.dao.PostRepository;
import com.chuwa.redbookblog.entity.Post;
import com.chuwa.redbookblog.payload.PostDTO;
import com.chuwa.redbookblog.payload.PostResponse;
import com.chuwa.redbookblog.service.PostService;
import com.chuwa.redbookblog.service.ResourcesNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());

        Post savedPost = postRepository.save(post);
//        PostDTO response = new PostDTO();
//
//        response.setId(savedPost.getId());
//        response.setTitle(savedPost.getTitle());
//        response.setContent(savedPost.getContent());
//        response.setDescription(savedPost.getDescription());

        return mapPostEntityToDTO(savedPost);
    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> all = postRepository.findAll();
        return all.stream().map(this::mapPostEntityToDTO).toList();
    }

    @Override
    public PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create pageable instance

        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> pagePosts = postRepository.findAll(pageRequest);

        // get content for page abject
        List<Post> posts = pagePosts.getContent();
        List<PostDTO> postDTOs = posts.stream().map(this::mapPostEntityToDTO).toList();

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
    public String deletePost(long id) {
        postRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("post", "id", id));
        postRepository.deleteById(id);
        return "Successfully deleted";
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, long id) {
        Post postToUpdate = postRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("post", "id", id));

        postToUpdate.setTitle(postDTO.getTitle());
        postToUpdate.setContent(postDTO.getContent());
        postToUpdate.setDescription(postDTO.getDescription());

        return mapPostEntityToDTO(postRepository.save(postToUpdate));
    }

    @Override
    public PostDTO getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("post", "id", id));
        return mapPostEntityToDTO(post);
    }

    private PostDTO mapPostEntityToDTO(Post post) {
        PostDTO response = new PostDTO();

        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setContent(post.getContent());
        response.setDescription(post.getDescription());

        return response;
    }
}

package com.chuwa.redbookblog.service.impl;

import com.chuwa.redbookblog.ResourcesNotFoundException;
import com.chuwa.redbookblog.dao.PostRepository;
import com.chuwa.redbookblog.entity.Post;
import com.chuwa.redbookblog.payload.PostDTO;
import com.chuwa.redbookblog.service.PostService;
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

        // DTO --> Entity
        Post postToBeSaved = new Post();

        // postToBeSaved.setId();
        postToBeSaved.setTitle(postDTO.getTitle());
        postToBeSaved.setContent(postDTO.getContent());
        postToBeSaved.setDescription(postDTO.getDescription());

        Post savedPost = this.postRepository.save(postToBeSaved);
//        PostDTO response = new PostDTO();
//
//        // Entity --> DTO(return)
//        response.setId(savedPost.getId()); // it only "getting" from DB
//        response.setTitle(savedPost.getTitle());
//        response.setContent(savedPost.getContent());
//        response.setDescription(savedPost.getDescription());

        return mapPostEntityToDTO(savedPost);
    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDTO> response = posts.stream().map(post -> mapPostEntityToDTO(post)).collect(Collectors.toList());
        return response;
    }

    @Override
    public PostDTO getPostById(Long id) {
        // TODO need create a new exception
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Post", "id", id));
        return mapPostEntityToDTO(post);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, long id) {
        Post postToBeUpdated = postRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Post", "id", id));

        postToBeUpdated.setTitle(postDTO.getTitle());
        postToBeUpdated.setDescription(postDTO.getDescription());
        postToBeUpdated.setContent(postDTO.getContent());

        Post updatedPost = postRepository.save(postToBeUpdated);

        return mapPostEntityToDTO(updatedPost);
    }

    @Override
    public String deletePostById(long id) {
        Post postToBeDeleted = postRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Post", "id", id));

        postRepository.delete(postToBeDeleted);
        return "Successfully deleted";
    }

    private PostDTO mapPostEntityToDTO(Post post) {
        PostDTO response = new PostDTO();
        response.setId(post.getId()); // it only "getting" from DB
        response.setTitle(post.getTitle());
        response.setContent(post.getContent());
        response.setDescription(post.getDescription());
        return response;
    }
}

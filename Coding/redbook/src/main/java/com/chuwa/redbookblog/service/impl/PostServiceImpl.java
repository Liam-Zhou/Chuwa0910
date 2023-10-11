package com.chuwa.redbookblog.service.impl;

import com.chuwa.redbookblog.dao.PostRepository;
import com.chuwa.redbookblog.entity.Post;
import com.chuwa.redbookblog.exception.ResourcesNotFoundException;
import com.chuwa.redbookblog.payload.PostDTO;
import com.chuwa.redbookblog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO){
        Post postToBeSaved = new Post();

        postToBeSaved.setTitle(postDTO.getTitle());
        postToBeSaved.setContent(postDTO.getContent());
        postToBeSaved.setDescription(postDTO.getDescription());

        Post savedPost = this.postRepository.save(postToBeSaved);

        // Entity -> DTO(return)
        return mapPostEntityToDTO(savedPost);
    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = this.postRepository.findAll();
        return posts.stream().map(this::mapPostEntityToDTO).toList();
    }

    @Override
    public PostDTO getPostById(long id) {
        //todo customize error exception
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Post", "id", id));
        return mapPostEntityToDTO(post);
    }

    @Override
    public PostDTO updatePostById(PostDTO postDTO, long id) {
        Post postToBeUpdate = postRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Post", "id", id));

        //update value
        postToBeUpdate.setTitle(postDTO.getTitle());
        postToBeUpdate.setDescription(postDTO.getDescription());
        postToBeUpdate.setContent(postDTO.getContent());

        //save updated entity
        Post updatedPost = postRepository.save(postToBeUpdate);

        return mapPostEntityToDTO(updatedPost);
    }

    @Override
    public String deletePostById(long id) {
        Post postToBeDeleted = postRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Post", "id", id));
        postRepository.delete(postToBeDeleted);
        return "Deleted Successful";
    }

    private PostDTO mapPostEntityToDTO(Post savedPost){
        PostDTO response = new PostDTO();

        response.setId(savedPost.getId());  //id generate from entity
        response.setTitle(savedPost.getTitle());
        response.setContent(savedPost.getContent());
        response.setDescription(savedPost.getDescription());

        return response;
    }
}

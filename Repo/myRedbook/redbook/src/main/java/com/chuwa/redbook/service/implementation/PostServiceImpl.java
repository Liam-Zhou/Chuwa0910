package com.chuwa.redbook.service.implementation;


import com.chuwa.redbook.ResourcesNotFoundException;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {


    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    private PostDTO mapPostEntityToDTO(Post post){
        PostDTO response = new PostDTO();

        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setContent(post.getContent());
        response.setDescription(post.getDescription());

        return response;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Post postToBeSaved = new Post();
        postToBeSaved.setTitle(postDTO.getTitle());
        postToBeSaved.setContent(postDTO.getContent());
        postToBeSaved.setDescription(postDTO.getDescription());

        Post savedPost = this.postRepository.save(postToBeSaved);

        return mapPostEntityToDTO(savedPost);
    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();

        return posts.stream().map(this::mapPostEntityToDTO).toList();
    }

    @Override
    public PostDTO getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("Post", "id", id));

        return mapPostEntityToDTO(post);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("Post", "id", id));

        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());

        Post updatedPost = postRepository.save(post);
        return mapPostEntityToDTO(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        Post postToBeDelete = postRepository.findById(id).orElseThrow( ()-> new ResourcesNotFoundException("Post", "id", id));
        postRepository.deleteById(id);
    }
}

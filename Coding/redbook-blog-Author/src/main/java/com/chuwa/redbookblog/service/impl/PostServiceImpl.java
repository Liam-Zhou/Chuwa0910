package com.chuwa.redbookblog.service.impl;

import com.chuwa.redbookblog.dao.PostRepository;
import com.chuwa.redbookblog.entity.Post;
import com.chuwa.redbookblog.payload.PostDTO;
import com.chuwa.redbookblog.service.PostService;
import com.chuwa.redbookblog.ResourcesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //v1
    @Override
    public PostDTO createPost(PostDTO postDTO) {

        //DTO --> Entity
        Post postToBeSaved = new Post();
//        postToBeSaved.setId();
        postToBeSaved.setTitle(postDTO.getTitle());
        postToBeSaved.setContent(postDTO.getContent());
        postToBeSaved.setDescription(postDTO.getDescription());

        Post savedPost = this.postRepository.save(postToBeSaved);

//        PostDTO response = new PostDTO();
//
//        //Entity --> DTO(return)
//        response.setId(savedPost.getId()); //it only getting from DB
//        response.setTitle(savedPost.getTitle());
//        response.setContent(savedPost.getContent());
//        response.setDescription(savedPost.getDescription());

        return mapPostEntityToDTO(savedPost);
    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDTO> response = posts.stream().map(post -> mapPostEntityToDTO(post)).collect(Collectors.toList());
//        List<PostDTO> response = new ArrayList<>();
//        for(Post savedPost : posts){
//            PostDTO res = new PostDTO();
//
//            res.setId(savedPost.getId()); //it only getting from DB
//            res.setTitle(savedPost.getTitle());
//            res.setContent(savedPost.getContent());
//            res.setDescription(savedPost.getDescription());
//
//            response.add(res);
//        }

        return response;
    }

    @Override
    public PostDTO getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow( ()-> new ResourcesNotFoundException("Post", "id", id));

        return mapPostEntityToDTO(post);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, long id) {
        Post postToBeUpdate = postRepository.findById(id).orElseThrow( ()-> new ResourcesNotFoundException("Post", "id", id));

        //Update value here
        postToBeUpdate.setTitle(postDTO.getTitle());
        postToBeUpdate.setDescription(postDTO.getDescription());
        postToBeUpdate.setContent(postDTO.getContent());

        //save updated obj/entity
        Post updatedPost = postRepository.save(postToBeUpdate);

        return mapPostEntityToDTO(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        Post postToBeDelete = postRepository.findById(id).orElseThrow( ()-> new ResourcesNotFoundException("Post", "id", id));
//        postRepository.delete(postToBeDelete);
        postRepository.deleteById(id);
    }

    //Transfer
    private PostDTO mapPostEntityToDTO(Post post){
        PostDTO response = new PostDTO();

        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setContent(post.getContent());
        response.setDescription(post.getDescription());

        return response;
    }
}
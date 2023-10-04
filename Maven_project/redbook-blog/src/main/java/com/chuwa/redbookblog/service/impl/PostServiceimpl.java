package com.chuwa.redbookblog.service.impl;

import com.chuwa.redbookblog.dao.PostRepository;
import com.chuwa.redbookblog.entity.Post;
import com.chuwa.redbookblog.payload.PostDTO;
import com.chuwa.redbookblog.resourseNotFoundException;
import com.chuwa.redbookblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceimpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Override
    public PostDTO createPost(PostDTO postDTO){
        Post postToBeSaved = new Post();
        postToBeSaved.setTitle(postDTO.getTitle());
        postToBeSaved.setContent(postDTO.getContent());
        postToBeSaved.setDescription(postDTO.getDescription());

        Post savedPost = this.postRepository.save(postToBeSaved);

//        PostDTO response = new PostDTO();
//        //Entity --> DTO(return)
//        response.setId(savedPost.getId());
//        response.setTitle(savedPost.getTitle());
//        response.setContent(savedPost.getContent());
//        response.setDescription(savedPost.getDescription());
//        return response;
        return mapPostEntityToDTO(savedPost);
    }

    @Override
    public List<PostDTO> getAllPosts(){
        List<Post> posts = postRepository.findAll();
        List<PostDTO> response = posts.stream().map(post -> mapPostEntityToDTO(post)).collect(Collectors.toList());
        return response;
    }

//    @Override
//    public PostDTO getPostById(long id) {
//        return null;
//    }

    @Override
    public PostDTO getPostById(long id){
        Post post = postRepository.findById(id).orElseThrow(()->new resourseNotFoundException());
        return mapPostEntityToDTO(post);
    }


    @Override
    public PostDTO updatePost(PostDTO postDTO, long id){
        Post postToBeUpdate = postRepository.findById(id).orElseThrow(()->new resourseNotFoundException());
        postToBeUpdate.setTitle(postDTO.getTitle());
        postToBeUpdate.setContent(postDTO.getContent());
        postToBeUpdate.setDescription(postDTO.getDescription());
        Post updatedPost = postRepository.save(postToBeUpdate);

        return mapPostEntityToDTO(updatedPost);

    }

    @Override
    public void deletePostById(long id) {
        Post postToBeDelete = postRepository.findById(id).orElseThrow(()->new resourseNotFoundException());
        postRepository.delete(postToBeDelete);
    }

    private PostDTO mapPostEntityToDTO(Post post){
        PostDTO response = new PostDTO();
        //Entity --> DTO(return)
        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setContent(post.getContent());
        response.setDescription(post.getDescription());
        return response;
    }
}

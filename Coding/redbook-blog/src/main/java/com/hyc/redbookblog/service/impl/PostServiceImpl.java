package com.hyc.redbookblog.service.impl;

import com.hyc.redbookblog.exception.ResourceNotFoundException;
import com.hyc.redbookblog.dao.PostRepository;
import com.hyc.redbookblog.entity.Post;
import com.hyc.redbookblog.payload.PostDTO;
import com.hyc.redbookblog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: hyc
 */
@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Post postToBeSaved = new Post();
        postToBeSaved.setTitle(postDTO.getTitle());
        postToBeSaved.setContent(postDTO.getContent());
        postToBeSaved.setDescription(postDTO.getDescription());

        Post savedPost = postRepository.save(postToBeSaved);
        return mapPostEntityToDTO(savedPost);
    }

    @Override
    public List<PostDTO> getALlPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDTO> response = posts.stream().map(post -> mapPostEntityToDTO(post)).collect(Collectors.toList());
        return response;
    }

    @Override
    public PostDTO getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapPostEntityToDTO(post);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, long id) {
        Post postToBeUpdate = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
        postToBeUpdate.setTitle(postDTO.getTitle());
        postToBeUpdate.setDescription(postDTO.getDescription());
        postToBeUpdate.setContent(postDTO.getContent());

        Post updatedPost = postRepository.save(postToBeUpdate);
        return mapPostEntityToDTO(updatedPost);
    }

    @Override
    public String deletePostById(Long id) {
        Post postToBeDelete = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(postToBeDelete);
        return "Successfully Deleted";
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

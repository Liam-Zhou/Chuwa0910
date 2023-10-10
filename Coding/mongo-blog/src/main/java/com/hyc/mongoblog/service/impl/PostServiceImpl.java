package com.hyc.mongoblog.service.impl;

import com.hyc.mongoblog.dao.PostRepository;
import com.hyc.mongoblog.entity.Post;
import com.hyc.mongoblog.payload.PostDTO;
import com.hyc.mongoblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: hyc
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Post postToBeSaved = new Post();
        postToBeSaved.setTitle(postDTO.getTitle());
        postToBeSaved.setContent(postDTO.getContent());
        postToBeSaved.setDescription(postDTO.getDescription());

        Post savedPost = this.postRepository.save(postToBeSaved);
        PostDTO response = new PostDTO();

        response.setId(savedPost.getId());
        response.setTitle(savedPost.getTitle());
        response.setContent(savedPost.getContent());
        response.setDescription(savedPost.getDescription());

        return response;
    }
}

package com.hyc.redbookblog.service;

import com.hyc.redbookblog.payload.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: hyc
 */

public interface PostService {
    PostDTO createPost(PostDTO postDTO);

    List<PostDTO> getALlPosts();

    PostDTO getPostById(long id);

    PostDTO updatePost(PostDTO postDTO, long id);

    String deletePostById(Long id);
}

package com.hyc.mongoblog.service;

import com.hyc.mongoblog.payload.PostDTO;

/**
 * @Description:
 * @Author: hyc
 */
public interface PostService {
    PostDTO createPost(PostDTO postDTO);
}

package com.chuwa.redbookblog.service;

import com.chuwa.redbookblog.payload.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);
    List<PostDTO> getAllPosts();
    PostDTO getPostById(long id);

    PostDTO updatePostById(PostDTO postDTO, long id);
    String deletePostById(long id);
}

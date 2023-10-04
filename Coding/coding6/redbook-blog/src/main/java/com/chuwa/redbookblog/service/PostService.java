package com.chuwa.redbookblog.service;

import com.chuwa.redbookblog.entity.Post;
import com.chuwa.redbookblog.payload.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);
    List<PostDTO> getAllPosts();
    PostDTO getPostById(Long id);
    PostDTO updatePost(PostDTO postDTO, long id);
    String deletePostById(long id);

}

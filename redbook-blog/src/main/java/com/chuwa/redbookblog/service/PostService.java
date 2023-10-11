package com.chuwa.redbookblog.service;

import com.chuwa.redbookblog.payload.PostDTO;
import com.chuwa.redbookblog.payload.PostResponse;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);
    List<PostDTO> getAllPosts();
    PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDTO getPostById(long id);
    PostDTO updatePost(PostDTO postDTO, long id);
    String deletePost(long id);
}

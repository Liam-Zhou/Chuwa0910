package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.PostDTO;

import java.util.List;

public interface PostService {

    PostDTO createPost(PostDTO postDTO);

    List<PostDTO> getAllPosts();

    PostDTO getPostDTOById(long id);

    PostDTO updatePost(PostDTO postDTO,long id);

    String deletePostById(long id);

}

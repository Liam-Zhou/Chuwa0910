package com.chuwa.redbookblog.service;

import com.chuwa.redbookblog.entity.Post;
import com.chuwa.redbookblog.payload.PostDTO;

import java.util.List;

public interface PostService {

    PostDTO createPost(PostDTO postDTO);
    List<PostDTO> getAllPosts();
    PostDTO getPostById(long id);
    PostDTO updatePost(PostDTO postDTO, long id);
    void deletePostById(long id);

    List<PostDTO> getAllPostWithJPQL();
    PostDTO getPostByIdJPQLIndexParameter(Long id, String title);
    PostDTO getPostByIdJPQLNamedParameter(Long id, String title);
    PostDTO getPostByIdSQLIndexParameter(Long id, String title);
    PostDTO getPostByIdSQLNamedParameter(Long id, String title);
}

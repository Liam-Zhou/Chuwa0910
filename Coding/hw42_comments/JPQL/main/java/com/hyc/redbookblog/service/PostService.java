package com.hyc.redbookblog.service;

import com.hyc.redbookblog.payload.PostDto;

import java.util.List;

/**
 * @Description:
 * @Author: hyc
 */

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);

    List<PostDto> getAllPostWithJPQL();
    PostDto getPostByIdJPQLIndexParameter(Long id, String title);
    PostDto getPostByIdJPQLNamedParameter(Long id, String title);
    PostDto getPostByIdSQLIndexParameter(Long id, String title);
    PostDto getPostByIdSQLNamedParameter(Long id, String title);
}

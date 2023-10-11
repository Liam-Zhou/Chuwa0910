package com.chuwa.redbookblog.service;

import com.chuwa.redbookblog.payload.PostDto;
import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPost();

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);

}
package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.payload.PostResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {

    PostDTO createPost(PostDTO postDTO);

    List<PostDTO> getAllPosts();

    PostDTO getPostDTOById(long id);

    PostDTO updatePost(PostDTO postDTO,long id);

    String deletePostById(long id);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    List<PostDTO> getAllPostWithJPQL();
    PostDTO getPostByIdJPQLIndexParameter(Long id, String title);
    PostDTO getPostByIdJPQLNamedParameter(Long id, String title);
    PostDTO getPostByIdSQLIndexParameter(Long id, String title);
    PostDTO getPostByIdSQLNamedParameter(Long id, String title);

}

package kechen.hw10springbootredbook.service;

import kechen.hw10springbootredbook.payload.PostDto;
import kechen.hw10springbootredbook.payload.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    // List<PostDto> getAllPost();

    PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);

    List<PostDto> getAllPostWithJPQL();
    PostDto getPostByIdJPQLIndexParameter(Long id, String title);
    PostDto getPostByIdJPQLNamedParameter(Long id, String title);
    PostDto getPostByIdSQLIndexParameter(Long id, String title);
    PostDto getPostByIdSQLNamedParameter(Long id, String title);
}

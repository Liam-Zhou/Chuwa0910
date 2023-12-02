package kechen.hw9springbootredbook.service;

import kechen.hw9springbootredbook.payload.PostDto;
import kechen.hw9springbootredbook.payload.PostResponse;

public interface PostService {
    PostDto createPost(PostDto postDto);

    // List<PostDto> getAllPost();

    PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
}

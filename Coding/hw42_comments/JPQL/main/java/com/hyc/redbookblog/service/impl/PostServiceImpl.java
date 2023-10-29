package com.hyc.redbookblog.service.impl;

import com.hyc.redbookblog.dao.PostJPQLRepository;
import com.hyc.redbookblog.exception.ResourceNotFoundException;
import com.hyc.redbookblog.dao.PostRepository;
import com.hyc.redbookblog.entity.Post;
import com.hyc.redbookblog.payload.PostDto;
import com.hyc.redbookblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: hyc
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    PostJPQLRepository postJPQLRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);

        Post savedPost = postRepository.save(post);
        PostDto postResponse = mapToDTO(savedPost);

        return postResponse;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        return mapToDTO(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post updatePost = postRepository.save(post);
        return mapToDTO(updatePost);
    }

    @Override
    public void deletePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }

    @Override
    public List<PostDto> getAllPostWithJPQL() {
        return postJPQLRepository.getAllPostWithJPQL().stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostByIdJPQLIndexParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithJPQLIndexParameters(id, title);
        return mapToDTO(post);
    }

    @Override
    public PostDto getPostByIdJPQLNamedParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithJPQLNamedParameters(id, title);
        return mapToDTO(post);
    }

    @Override
    public PostDto getPostByIdSQLIndexParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithSQLIndexParameters(id, title);
        return mapToDTO(post);
    }

    @Override
    public PostDto getPostByIdSQLNamedParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithSQLNamedParameters(id, title);
        return mapToDTO(post);
    }

    private PostDto mapToDTO(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());

        return postDto;
    }

    private Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return post;
    }
}

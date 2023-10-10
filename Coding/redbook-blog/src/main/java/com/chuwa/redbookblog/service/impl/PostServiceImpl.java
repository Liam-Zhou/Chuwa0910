package com.chuwa.redbookblog.service.impl;

import com.chuwa.redbookblog.DAO.PostRepository;
import com.chuwa.redbookblog.Exception.ResourcesNotFoundException;
import com.chuwa.redbookblog.entity.Post;
import com.chuwa.redbookblog.payload.PostDTO;
import com.chuwa.redbookblog.payload.PostResponse;
import com.chuwa.redbookblog.service.PostService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {


    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Post post2BeSaved = new Post();
        post2BeSaved.setTitle(postDTO.getTitle());
        post2BeSaved.setContent(postDTO.getContent());
        post2BeSaved.setDescription(postDTO.getDescription());

        Post savedPost = this.postRepository.save(post2BeSaved);
        return MapPost2DTO(savedPost);
    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::MapPost2DTO).collect(Collectors.toList());
    }

    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        PageRequest pageRequest = PageRequest.of(pageNo,pageSize,sort);
        Page<Post> pagePosts = postRepository.findAll(pageRequest);
        List<PostDTO> postDTOs = pagePosts.getContent().stream().map(this::MapPost2DTO).toList();

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDTOs);
        postResponse.setPageNo(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalElements(pagePosts.getTotalElements());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setLast(pagePosts.isLast());


        return postResponse;
    }

    @Override
    public PostDTO getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("post","id",id));
        return MapPost2DTO(post);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, long id) {
        Post post2Update = postRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("update","id",id));
        post2Update.setTitle(postDTO.getTitle());
        post2Update.setDescription(postDTO.getDescription());
        post2Update.setContent(postDTO.getContent());
        Post updatedPost = postRepository.save(post2Update);

        return MapPost2DTO(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        Post post2Del = postRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Delete","id",id));
        postRepository.delete(post2Del);

    }

    @Override
    public void hw42P10() {
        postRepository.findAllByTitle("hello");
    }

    private PostDTO MapPost2DTO(Post post) {
        PostDTO postDTO  = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setContent(post.getContent());
        postDTO.setDescription(post.getDescription());
        return postDTO;
    }
}

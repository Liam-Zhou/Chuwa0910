package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.ResourcesNotFoundException;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Post postToBeSaved = new Post();
        postToBeSaved.setTitle(postDTO.getTitle());
        postToBeSaved.setContent(postDTO.getContent());
        postToBeSaved.setDescription(postDTO.getDescription());
        Post savedPost = this.postRepository.save(postToBeSaved);
/*        PostDTO response = new PostDTO();
        response.setId(savedPost.getId());
        response.setTitle(savedPost.getTitle());
        response.setDescription(savedPost.getDescription());
        response.setContent(savedPost.getContent());*/
        return mapPostEntityToDto(savedPost);
    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDTO> response = posts.stream().map(post->mapPostEntityToDto(post)).collect(Collectors.toList());
        return response;
    }

    @Override
    public PostDTO getPostDTOById(long id) {
        Post post = postRepository.findById(id).orElseThrow(()->new ResourcesNotFoundException("Post","id",id));
        return mapPostEntityToDto(post);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, long id) {

        Post postToUpdate = postRepository.findById(id).orElseThrow(()->new ResourcesNotFoundException("Post","id",id));
        postToUpdate.setTitle(postDTO.getTitle());
        postToUpdate.setDescription(postDTO.getDescription());
        postToUpdate.setContent(postDTO.getContent());
        Post updatePost = postRepository.save(postToUpdate);
        return mapPostEntityToDto(updatePost);
    }

    @Override
    public String deletePostById(long id) {
        Post postToDelete = postRepository.findById(id).orElseThrow(()->new ResourcesNotFoundException("Post","id",id));
        postRepository.delete(postToDelete);
        return "Successfully deleted";
    }

    private PostDTO mapPostEntityToDto(Post savedPost){
        PostDTO response = new PostDTO();
        response.setId(savedPost.getId());
        response.setTitle(savedPost.getTitle());
        response.setDescription(savedPost.getDescription());
        response.setContent(savedPost.getContent());
        return response;
    }
}

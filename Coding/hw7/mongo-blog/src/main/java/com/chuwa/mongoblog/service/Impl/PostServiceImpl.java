package com.chuwa.mongoblog.service.Impl;

import com.chuwa.mongoblog.model.Post;
import com.chuwa.mongoblog.payload.PostDTO;
import com.chuwa.mongoblog.repository.PostRepository;
import com.chuwa.mongoblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class PostServiceImpl implements PostService {

    @Autowired  // 可以直接调用interface 不需要new instance
    private PostRepository postRepository;
    @Override
    public PostDTO createPost(PostDTO postDTO){
        //DTO->ENTITY
        Post postToBeSaved = new Post();
        postToBeSaved.setTitle(postDTO.getTitle());
        postToBeSaved.setContent(postDTO.getContent());
        postToBeSaved.setDescription(postDTO.getDescription());
        postToBeSaved.setCreateDateTime(LocalDateTime.now());

        Post savedPost = this.postRepository.save(postToBeSaved);
        PostDTO response = new PostDTO();

        //ENTITY -> DTO(RETURN )
        response.setTitle(savedPost.getTitle());
        response.setContent(savedPost.getContent());
        response.setDescription(savedPost.getDescription());
        response.setCreateDateTime(savedPost.getCreateDateTime());
        return response;
    }
}

package com.chuwa.redbookblog.service.impl;

import com.chuwa.redbookblog.dao.PostJPQLRepository;
import com.chuwa.redbookblog.dao.PostRepository;
import com.chuwa.redbookblog.entity.Post;
import com.chuwa.redbookblog.payload.PostDTO;
import com.chuwa.redbookblog.service.PostService;
import com.chuwa.redbookblog.exception.ResourcesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    PostJPQLRepository postJPQLRepository;

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Post post = mapToEntity(postDTO);
        Post savedPost = this.postRepository.save(post);

        return mapToDTO(savedPost);
    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDTO> postDTOS = posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
//        List<PostDTO> response = new ArrayList<>();
//        for(Post savedPost : posts){
//            PostDTO res = new PostDTO();
//
//            res.setId(savedPost.getId()); //it only getting from DB
//            res.setTitle(savedPost.getTitle());
//            res.setContent(savedPost.getContent());
//            res.setDescription(savedPost.getDescription());
//
//            response.add(res);
//        }

        return postDTOS;
    }

    @Override
    public PostDTO getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("Post", "id", id));

        return mapToDTO(post);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, long id) {
        Post postToBeUpdate = postRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("Post", "id", id));

        //Update value here
        postToBeUpdate.setTitle(postDTO.getTitle());
        postToBeUpdate.setDescription(postDTO.getDescription());
        postToBeUpdate.setContent(postDTO.getContent());

        //save updated obj/entity
        Post updatedPost = postRepository.save(postToBeUpdate);

        return mapToDTO(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        Post postToBeDelete = postRepository.findById(id).orElseThrow( ()-> new ResourcesNotFoundException("Post", "id", id));
//        postRepository.delete(postToBeDelete);
        postRepository.deleteById(id);
    }

    @Override
    public List<PostDTO> getAllPostWithJPQL() {
        return postJPQLRepository.getAllPostWithJPQL().stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
    }

    @Override
    public PostDTO getPostByIdJPQLIndexParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithJPQLIndexParameters(id, title);
        return mapToDTO(post);
    }

    @Override
    public PostDTO getPostByIdJPQLNamedParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithJPQLNamedParameters(id, title);
        return mapToDTO(post);
    }

    @Override
    public PostDTO getPostByIdSQLIndexParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithSQLIndexParameters(id, title);
        return mapToDTO(post);
    }

    @Override
    public PostDTO getPostByIdSQLNamedParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithSQLNamedParameters(id, title);
        return mapToDTO(post);
    }

    //Transfer
    private PostDTO mapToDTO(Post post){
        PostDTO postDTO = new PostDTO();

        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setContent(post.getContent());
        postDTO.setDescription(post.getDescription());

        return postDTO;
    }

    private Post mapToEntity(PostDTO postDTO){
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());

        return post;
    }
}
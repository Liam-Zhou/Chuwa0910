package com.chuwa.redbookblog.service.implementation;
import com.chuwa.redbookblog.ResourceNotFoundException;
import com.chuwa.redbookblog.dao.PostRepository;
import com.chuwa.redbookblog.entity.Post;
import com.chuwa.redbookblog.payload.PostDTO;
import com.chuwa.redbookblog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImplementation implements PostService {

    //@Autowired  // 可以直接调用interface 不需要new instance
    private PostRepository postRepository;

    public PostServiceImplementation(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    @Override
    public PostDTO createPost(PostDTO postDTO){
        //DTO->ENTITY
        Post postToBeSaved = new Post();
        //postToBeSaved.setTitle(postDTO.getTitle());
        postToBeSaved.setTitle(postDTO.getTitle());
        postToBeSaved.setContent(postDTO.getContent());
        postToBeSaved.setDescription(postDTO.getDescription());

        Post savedPost = this.postRepository.save(postToBeSaved);
        return mapPostEntityToDTO(savedPost);
        //PostDTO response = new PostDTO();

        //ENTITY -> DTO(RETURN )
        //response.setId(savedPost.getId());
        //response.setTitle(savedPost.getTitle());
        //response.setContent(savedPost.getContent());
        //response.setDescription(savedPost.getDescription());
        //return response;
    }

    @Override
    public List<PostDTO> getAllPosts(){
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::mapPostEntityToDTO).collect(Collectors.toList());
    }

    @Override
    public PostDTO getPostById(long id){
        Post post = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "id", id));
        return mapPostEntityToDTO(post);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, long id) {
        Post postToBeUpdate = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "id", id));
        postToBeUpdate.setTitle(postDTO.getTitle());
        postToBeUpdate.setDescription(postDTO.getDescription());
        postToBeUpdate.setContent(postDTO.getContent());
        Post updatedPost = postRepository.save(postToBeUpdate);
        return mapPostEntityToDTO(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        //Post postToBeDelete = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "id", id));
        //postRepository.delete(postToBeDelete);
        postRepository.deleteById(id);
    }

    //transfer: post -> postDTO
    private PostDTO mapPostEntityToDTO(Post savedPost){
        PostDTO response = new PostDTO();
        response.setId(savedPost.getId());
        response.setTitle(savedPost.getTitle());
        response.setContent(savedPost.getContent());
        response.setDescription(savedPost.getDescription());
        return response;
    }

    //transfer: postDTO -> post
    private Post mapToEntity(PostDTO postDTO){
        Post post = new Post();
        post.setId(postDTO.getId());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());
        post.setTitle(postDTO.getTitle());
        return post;
    }
}

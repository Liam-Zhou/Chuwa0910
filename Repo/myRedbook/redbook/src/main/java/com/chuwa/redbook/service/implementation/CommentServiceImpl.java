package com.chuwa.redbook.service.implementation;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exceptions.BlogAPIException;
import com.chuwa.redbook.exceptions.ResourcesNotFoundException;
import com.chuwa.redbook.payload.CommentDTO;
import com.chuwa.redbook.service.CommentService;
import org.springframework.http.HttpStatus;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDTO createComment(long postId, CommentDTO commentDto) {
        Comment comment = mapToEntity(commentDto);
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourcesNotFoundException("Post", "id", postId));

        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        return mapToDTO(savedComment);
    }

    private Comment mapToEntity(CommentDTO commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());

        return comment;
    }

    private CommentDTO mapToDTO(Comment comment) {
        CommentDTO commentDto = new CommentDTO();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());

        return commentDto;
    }

    @Override
    public List<CommentDTO> getCommentsByPostId(long postId) {
        List<Comment> comments= commentRepository.findByPostId(postId);

        return comments.stream().map(this::mapToDTO).toList();
    }

    @Override
    public CommentDTO getCommentById(Long postId, Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourcesNotFoundException("Commend", "id", commentId));
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourcesNotFoundException("Post", "id", postId));

        if(!comment.getPost().getId().equals(post.getId()))
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to this post");
        return mapToDTO(comment);
    }

    @Override
    public CommentDTO updateComment(Long postId, Long commentId, CommentDTO commentDtoRequest) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourcesNotFoundException("Commend", "id", commentId));
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourcesNotFoundException("Post", "id", postId));

        if(!comment.getPost().getId().equals(post.getId()))
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to this post");

        comment.setBody(commentDtoRequest.getBody());
        comment.setEmail(commentDtoRequest.getEmail());
        comment.setName(commentDtoRequest.getName());

        Comment updatedComment = commentRepository.save(comment);
        return mapToDTO(updatedComment);
    }

    @Override
    public void deleteComment(Long postId, Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourcesNotFoundException("Commend", "id", commentId));
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourcesNotFoundException("Post", "id", postId));

        if(!comment.getPost().getId().equals(post.getId()))
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to this post");

        commentRepository.delete(comment);
    }
}

package com.chuwa.redbookblog.service.impl;

import com.chuwa.redbookblog.DAO.CommentRepository;
import com.chuwa.redbookblog.DAO.PostRepository;
import com.chuwa.redbookblog.Exception.BlogAPIException;
import com.chuwa.redbookblog.Exception.ResourcesNotFoundException;
import com.chuwa.redbookblog.entity.Comment;
import com.chuwa.redbookblog.entity.Post;
import com.chuwa.redbookblog.payload.CommentDTO;
import com.chuwa.redbookblog.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;
    private ModelMapper modelMapper;

    @Override
    public CommentDTO createComment(long postId, CommentDTO commentDTO) {
        Comment comment = modelMapper.map(commentDTO, Comment.class);
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourcesNotFoundException("Post", "id", postId));
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);

        return modelMapper.map(savedComment, CommentDTO.class);
    }

    @Override
    public List<CommentDTO> getCommentsByPostId(long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourcesNotFoundException("Post","id",postId));
        return post.getComments().stream().map(o->modelMapper.map(o,CommentDTO.class)).toList();
    }

    @Override
    public CommentDTO getCommentById(Long postId, Long commentId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourcesNotFoundException("Post", "id", postId));


        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourcesNotFoundException("Comment", "id", commentId));

        if (!comment.getPost().getId().equals(post.getId())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

        return modelMapper.map(comment, CommentDTO.class);
    }

    @Override
    public CommentDTO updateComment(Long postId, Long commentId, CommentDTO commentDTO) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourcesNotFoundException("Post", "id", postId));

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourcesNotFoundException("Comment", "id", commentId));

        if (!comment.getPost().getId().equals(post.getId())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

        comment.setName(commentDTO.getName());
        comment.setEmail(commentDTO.getEmail());
        comment.setBody(commentDTO.getBody());

        Comment updatedComment = commentRepository.save(comment);

        return modelMapper.map(updatedComment, CommentDTO.class);
    }

    @Override
    public void deleteComment(Long postId, Long commentId) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourcesNotFoundException("Post", "id", postId));

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourcesNotFoundException("Comment", "id", commentId));

        if (!comment.getPost().getId().equals(post.getId())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

        commentRepository.delete(comment);
    }
}

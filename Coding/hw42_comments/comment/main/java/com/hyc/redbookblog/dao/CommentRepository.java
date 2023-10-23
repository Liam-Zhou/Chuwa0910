package com.hyc.redbookblog.dao;

import com.hyc.redbookblog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: hyc
 * @Date: 10/22/23
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    /**
     * 不用实现。但要学语法
     * @param postId
     * @return
     */
    List<Comment> findByPostId(long postId);
}

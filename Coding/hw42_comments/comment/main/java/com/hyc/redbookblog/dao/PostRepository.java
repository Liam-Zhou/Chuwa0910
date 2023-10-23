package com.hyc.redbookblog.dao;

import com.hyc.redbookblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: hyc
 * @Date: 10/19/23
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}

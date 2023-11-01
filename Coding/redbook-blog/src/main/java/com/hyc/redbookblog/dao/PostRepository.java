package com.hyc.redbookblog.dao;

import com.hyc.redbookblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description:
 * @Author: hyc
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}

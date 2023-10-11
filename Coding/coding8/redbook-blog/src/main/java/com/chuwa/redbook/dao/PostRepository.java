package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findPostsByContentIsContainingIgnoreCase(String content);
    List<Post> findPostsByCreateDateTimeIsGreaterThanAndDescriptionIsContaining(Date date, String description);
}

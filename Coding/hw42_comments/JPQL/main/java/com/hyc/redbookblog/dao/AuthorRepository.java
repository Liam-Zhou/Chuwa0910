package com.hyc.redbookblog.dao;

import com.hyc.redbookblog.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description:
 * @Author: hyc
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
}

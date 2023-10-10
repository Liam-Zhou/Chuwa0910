package com.chuwa.redbookblog.dao;

import com.chuwa.redbookblog.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // do nothing
}

package com.chuwa.redbookblog.DAO;

import com.chuwa.redbookblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    //no code needed!!!!!

    public List<Post> findAllByTitle(String title);

    public List<Post> findAllByTitleAndCreateDateTimeIn(String title, List<LocalDateTime> createDateTime);
}

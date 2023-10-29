package com.chuwa.redbookblog.DAO;

import com.chuwa.redbookblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepostoryQuery extends JpaRepository<Post,Long> {

    @Query("select p from Post p where p.id = :key or p.title = :title")
    Post getPostByIDorTitle1(@Param("key") Long id,
                            @Param("title") String title);

    @Query(value = "select * from posts p where p.id = ?1 or p.title = ?2",nativeQuery = true)
    Post getPostByIDorTitle2(Long id, String title);
}

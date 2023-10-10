package com.chuwa.redbookblog.dao;

import com.chuwa.redbookblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    @Query("select p from Post p where p.id = ?1 or p.title = ?2") // use Entity name other than database table name.
    Post getPostByIDOrTitleWithJPQLIndexParameters(Long id, String title);

    @Query("select p from Post p where p.id = :key or p.title = :title")
    Post getPostByIDOrTitleWithJPQLNamedParameters(@Param("key") Long id,
                                                   @Param("title") String title);

    @Query(value = "select * from posts p where p.id = ?1 or p.title = ?2", nativeQuery = true) // When you set nativeQuery = true, you are telling JPA to treat the query as a native SQL query.
    Post getPostByIDOrTitleWithSQLIndexParameters(Long id, String title);

    @Query(value = "select * from posts p where p.id = :key or p.title = :title", nativeQuery = true)
    Post getPostByIDOrTitleWithSQLNamedParameters(@Param("key") Long id,
                                                  @Param("title") String title);
}

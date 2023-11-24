package kechen.hw10springbootredbook.dao;

import kechen.hw10springbootredbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // 根据条件从数据库中选择 Post 对象
    // ?1 对应方法参数中的第一个参数 Long id。
    // ?2 对应方法参数中的第二个参数 String title。
    @Query("select p from Post p where p.id = ?1 or p.title = ?2")
    // 通过 id 或者 title 获取对应的 Post 对象。
    Post getPostByIDOrTitleWithJPQLIndexParameters(Long id, String title);

    // :key 和 :title 是命名参数，用于指定查询条件中的参数值。
    // 根据给定的 id 或 title 参数获取对应的 Post 对象。
    @Query("select p from Post p where p.id = :key or p.title = :title")
    Post getPostByIDOrTitleWithJPQLNamedParameters(@Param("key") Long id,
                                                   @Param("title") String title);

    // nativeQuery = true 以使用原生 SQL 查询语句。
    @Query(value = "select * from posts p where p.id = ?1 or p.title = ?2 AND p.update_date_time", nativeQuery = true)
    Post getPostByIDOrTitleWithSQLIndexParameters(Long id, String title);

    /**
     * SQL
     * use database table name.
     * named Parameters
     * @return post
     */
    @Query(value = "select * from posts p where p.id = :key or p.title = :title", nativeQuery = true)
    Post getPostByIDOrTitleWithSQLNamedParameters(@Param("key") Long id,
                                                  @Param("title") String title);

}

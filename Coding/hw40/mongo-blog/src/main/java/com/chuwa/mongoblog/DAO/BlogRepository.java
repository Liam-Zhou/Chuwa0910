package com.chuwa.mongoblog.DAO;

import com.chuwa.mongoblog.Entity.Blog;
import com.chuwa.mongoblog.MongoBlogApplication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends MongoRepository<Blog,String> {


}

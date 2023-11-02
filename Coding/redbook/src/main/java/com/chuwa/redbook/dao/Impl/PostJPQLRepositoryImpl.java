package com.chuwa.redbook.dao.Impl;

import com.chuwa.redbook.dao.PostJPQLRepository;
import com.chuwa.redbook.entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PostJPQLRepositoryImpl implements PostJPQLRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Post> getAllPostWithJPQL() {
        TypedQuery<Post> posts = entityManager.createNamedQuery("Post.getAll", Post.class);
        return posts.getResultList();
    }

    public Post insertPost(Post post) {
        return entityManager.merge(post);
    }

    public Post updatePost(Post post) {
        return entityManager.merge(post);
    }

    public Post getPostById(Long id) {
        return entityManager.find(Post.class, id);
    }

    public void deleteById(Long id) {
        Post post = entityManager.find(Post.class, id);
        entityManager.remove(post);
    }

    public <T> T insertData(T t) {
        return entityManager.merge(t);
    }
}

package com.chuwa.redbookblog.dao.impl;

import com.chuwa.redbookblog.dao.PostJPQLRepository;
import com.chuwa.redbookblog.entity.Post;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class PostJPQLRepositoryImpl implements PostJPQLRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
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

    public Post getPostById(Long id) { return entityManager.find(Post.class, id);}

    public void deletePostById(Long id) {
        Post post = entityManager.find(Post.class, id);
        entityManager.remove(post);
    }

    public <T> T insertData(T t) { return entityManager.merge(t); }
}

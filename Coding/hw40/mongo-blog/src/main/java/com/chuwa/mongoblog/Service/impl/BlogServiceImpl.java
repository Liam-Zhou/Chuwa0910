package com.chuwa.mongoblog.Service.impl;

import com.chuwa.mongoblog.DAO.BlogRepository;
import com.chuwa.mongoblog.Entity.Blog;
import com.chuwa.mongoblog.Payload.BlogDTO;
import com.chuwa.mongoblog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public BlogDTO createPost(BlogDTO blogDTO) {
        Blog blog2Saved = new Blog();
        blog2Saved.setTitle(blogDTO.getTitle());
        blog2Saved.setContent(blogDTO.getContent());
        blog2Saved.setDiscription(blogDTO.getDiscription());

        Blog savedBlog = blogRepository.insert(blog2Saved);
        BlogDTO blog2Send = new BlogDTO();
        blog2Send.setId(savedBlog.getId());
        blog2Send.setTitle(savedBlog.getTitle());
        blog2Send.setDiscription(savedBlog.getDiscription());
        blog2Send.setContent(savedBlog.getContent());

        return blog2Send;
    }
}

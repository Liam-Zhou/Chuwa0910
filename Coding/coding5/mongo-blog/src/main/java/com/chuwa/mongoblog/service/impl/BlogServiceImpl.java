package com.chuwa.mongoblog.service.impl;

import com.chuwa.mongoblog.dao.BlogRepository;
import com.chuwa.mongoblog.entity.Blog;
import com.chuwa.mongoblog.payload.BlogDTO;
import com.chuwa.mongoblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public BlogDTO createBlog(BlogDTO blogDTO) {
        Blog blogToBeSaved = new Blog();

        blogToBeSaved.setId(blogDTO.getId());
        blogToBeSaved.setTitle(blogDTO.getTitle());
        blogToBeSaved.setContent(blogDTO.getContent());
        blogToBeSaved.setDescription(blogDTO.getDescription());

        Blog savedBlog = this.blogRepository.save(blogToBeSaved);
        BlogDTO response = new BlogDTO();

        response.setId(savedBlog.getId());
        response.setContent(savedBlog.getContent());
        response.setDescription(savedBlog.getDescription());
        response.setTitle(savedBlog.getTitle());

        return response;
    }

}

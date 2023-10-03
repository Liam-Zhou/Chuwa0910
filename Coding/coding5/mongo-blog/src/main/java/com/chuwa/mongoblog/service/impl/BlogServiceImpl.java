package com.chuwa.mongoblog.service.impl;

import com.chuwa.mongoblog.dao.BlogRepository;
import com.chuwa.mongoblog.entity.Blog;
import com.chuwa.mongoblog.payload.BlogDTO;
import com.chuwa.mongoblog.service.BlogService;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

    final private BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public BlogDTO createBlog(BlogDTO blogDTO) {
        Blog blogToBeSave = new Blog();

        blogToBeSave.setTitle(blogDTO.getTitle());
        blogToBeSave.setContent(blogDTO.getContent());
        blogToBeSave.setDescription(blogDTO.getDescription());

        Blog savedBlog = blogRepository.save(blogToBeSave);
        return mapBlogEntityToDTO(savedBlog);
    }

    private BlogDTO mapBlogEntityToDTO(Blog blog){
        BlogDTO blogDTO = new BlogDTO();

        blogDTO.setTitle(blog.getTitle());
        blogDTO.setContent(blog.getContent());
        blogDTO.setDescription(blog.getDescription());
        blogDTO.setId(blog.getId());

        return blogDTO;
    }
}

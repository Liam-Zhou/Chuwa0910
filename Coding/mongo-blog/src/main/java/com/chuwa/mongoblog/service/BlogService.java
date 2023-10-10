package com.chuwa.mongoblog.service;

import com.chuwa.mongoblog.dto.BlogDTO;

import java.util.List;

public interface BlogService {
    BlogDTO createBlog(BlogDTO blog);
    List<BlogDTO> getAllBlogs();
}

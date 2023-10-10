package com.chuwa.mongoblog.service;

import com.chuwa.mongoblog.payload.BlogDTO;

public interface BlogService {
    BlogDTO createBlog(BlogDTO blogDTO);
}

package com.chuwa.mongoblog.Service;

import com.chuwa.mongoblog.Payload.BlogDTO;

public interface BlogService {
    BlogDTO createPost(BlogDTO blogDTO);
}

package com.blog.blogupdate.service;

import com.blog.blogupdate.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGenerateService<Blog> {
    Page<Blog> findByCategory(int category, Pageable pageable);
}

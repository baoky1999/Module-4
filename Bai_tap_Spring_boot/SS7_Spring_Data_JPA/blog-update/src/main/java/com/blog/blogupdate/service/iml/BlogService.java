package com.blog.blogupdate.service.iml;

import com.blog.blogupdate.model.Blog;
import com.blog.blogupdate.repository.IBlogRepository;
import com.blog.blogupdate.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById((long) id);
    }


    @Override
    public void remove(int id) {
        blogRepository.deleteById((long) id);
    }

    @Override
    public Page<Blog> findByTitle(String search, Pageable pageable) {
        return blogRepository.findAllByTitleContaining(search, pageable);
    }

    @Override
    public Page<Blog> findByCategory(int category, Pageable pageable) {
        Long categoryId = (long) category;
        return blogRepository.findAllByCategory(categoryId, pageable);
    }
}

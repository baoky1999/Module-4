package com.blog.blogpersonal.service.iml;

import com.blog.blogpersonal.model.Blog;
import com.blog.blogpersonal.repository.IBlogRepository;
import com.blog.blogpersonal.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        blogRepository.remove(id);
    }

    @Override
    public List<Blog> findByName(String search) {
        return blogRepository.findByName(search);
    }
}

package com.blog.blogpersonal.service;

import com.blog.blogpersonal.model.Blog;

import java.util.List;

public interface IGenerateService<T> {

    List<T> findAll();

    void save(T t);

    T findById(int id);

    void remove(int id);

    List<Blog> findByName(String search);
}

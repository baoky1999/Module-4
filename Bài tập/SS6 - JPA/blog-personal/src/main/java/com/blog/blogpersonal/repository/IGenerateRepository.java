package com.blog.blogpersonal.repository;

import com.blog.blogpersonal.model.Blog;

import java.util.List;

public interface IGenerateRepository<T> {

    List<T> findAll();

    T findById(int id);

    void save(T t);

    void remove(int id);

    List<Blog> findByName(String search);
}

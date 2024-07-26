package com.blog.blogupdate.controller;

import com.blog.blogupdate.model.Blog;
import com.blog.blogupdate.model.Category;
import com.blog.blogupdate.service.IBlogService;
import com.blog.blogupdate.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class RestBlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getAllBlogCategory() {
        List<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping("/find-all")
    public ResponseEntity<?> getAllBlog() {
        List<Blog> blogs = blogService.findAllBlog();
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @GetMapping("{categoryId}")
    public ResponseEntity<?> getBlogByCategoryId(@PathVariable int categoryId) {
        List<Blog> blogs = blogService.findAllBlogByCategory(categoryId);
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable int id) {
        Blog blog = blogService.findById(id).get();
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }


}

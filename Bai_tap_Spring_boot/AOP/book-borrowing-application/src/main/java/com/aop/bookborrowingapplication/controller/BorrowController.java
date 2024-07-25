package com.aop.bookborrowingapplication.controller;

import com.aop.bookborrowingapplication.model.Book;
import com.aop.bookborrowingapplication.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/borrow_book")
public class BorrowController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public String showBorrow(Model model) {
        List<Book> borrows = bookService.findAll();
        model.addAttribute("borrows", borrows);
        return "view/list_borrow";

    }
}

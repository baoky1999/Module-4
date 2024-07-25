package com.aop.bookborrowingapplication.controller;

import com.aop.bookborrowingapplication.model.Book;
import com.aop.bookborrowingapplication.model.Borrow;
import com.aop.bookborrowingapplication.service.IBookService;
import com.aop.bookborrowingapplication.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
@RequestMapping("/home_book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private IBorrowService borrowService;

    @GetMapping
    public String showListBook(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "view/home";
    }

    @GetMapping("{id}/borrow")
    public String showBorrowedBook(@PathVariable("id") int id, Model model) {
        Optional<Book> book = bookService.findById(id);
        model.addAttribute("book", book.get());
        return "view/borrow";
    }

    @PostMapping("{id}/borrow")
    public String completeBook(@PathVariable("id") int id, Model model) {
        Optional<Book> book = bookService.findById(id);
        Optional<Borrow> borrows = borrowService.findById(id);
        if (borrows.isEmpty()) {
            int currentQuantity = book.get().getQuantity();
            if (currentQuantity <= 0) {
                return "view/error";
            } else {
                book.get().setQuantity(currentQuantity - 1);
                bookService.save(book.get());

                String randomCode;
                do {
                    randomCode = generateRandomCode();
                } while (borrowService.existsByCode(randomCode));

                Borrow borrow = new Borrow();
                borrow.setId(id);
                borrow.setCode(randomCode);
                borrowService.save(borrow);
                book.get().setBorrow(borrow);
                bookService.save(book.get());
            }
            return "redirect:/borrow_book";
        } else if (book.get().getId() == borrows.get().getId()) {
            return "view/error_book";
        }
        return "redirect:/home_book";
    }

    private String generateRandomCode() {
        Random random = new Random();
        int number = random.nextInt(90000) + 10000;
        return String.valueOf(number);
    }

    @PostMapping("/give_book")
    public String giveBook(@RequestParam("code") String code,
                           RedirectAttributes redirectAttributes) {
        Borrow borrow = borrowService.findByCode(code);
        if (borrow == null) {
            redirectAttributes.addFlashAttribute("message", "Mã không tồn tại");
            return "redirect:/borrow_book";
        }
        int id = borrow.getId();
        Optional<Book> book = bookService.findById(id);
        int currentQuantity = book.get().getQuantity();
        book.get().setQuantity(currentQuantity + 1);
        bookService.save(book.get());
        book.get().setBorrow(null);
        bookService.save(book.get());
        borrowService.delete(borrow);
        return  "redirect:/home_book";
    }

}

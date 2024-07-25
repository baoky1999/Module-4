package com.aop.bookborrowingapplication.aspect;

import com.aop.bookborrowingapplication.model.Book;
import com.aop.bookborrowingapplication.model.Borrow;
import com.aop.bookborrowingapplication.service.IBookService;
import com.aop.bookborrowingapplication.service.IBorrowService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
@Aspect
public class BookAspect {
    private static final String URL_LOG_BOOK = "D:\\Module-4\\Module-4\\Bai_tap_Spring_boot\\AOP\\book-borrowing-application\\src\\main\\java\\com\\aop\\bookborrowingapplication\\log\\change.csv";
    private static final String URL_LOG_VISITORS = "D:\\Module-4\\Module-4\\Bai_tap_Spring_boot\\AOP\\book-borrowing-application\\src\\main\\java\\com\\aop\\bookborrowingapplication\\log\\log_all.csv";
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private IBookService bookService;

    @Autowired
    private IBorrowService borrowService;

    private int quantityBefore;

    @Before("execution(* com.aop.bookborrowingapplication.controller.BookController.completeBook(..))")
    public void logBeforeCompleteBook(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        int bookId = (int) args[0];

        Optional<Book> optionalBook = bookService.findById(bookId);
        if (optionalBook.isPresent()) {
            Book foundBook = optionalBook.get();
            quantityBefore = foundBook.getQuantity();
        }
    }

    @Before("execution(* com.aop.bookborrowingapplication.controller.BookController.giveBook(..))")
    public void logBeforeGiverBook(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String bookCode = (String) args[0];
        Borrow borrow = borrowService.findByCode(bookCode);
        if (borrow != null) {
            int bookId = borrow.getId();
            Optional<Book> optionalBook = bookService.findById(bookId);
            if (optionalBook.isPresent()) {
                Book foundBook = optionalBook.get();
                int quantity = foundBook.getQuantity();
                int newQuantity = quantity + 1;
                    File file = new File(URL_LOG_BOOK);
                    try {
                        FileWriter fileWriter = new FileWriter(file, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        String log = "Người dùng đã trả sách vào lúc " + LocalDateTime.now() + ", số lượng còn lại là " + newQuantity + "\n";
                        bufferedWriter.write(log);
                        bufferedWriter.flush();
                    } catch (Exception e) {
                        logger.error("Lỗi ghi file", e);
                    }

            }
        }
    }

    public int getQuantity() {
        return quantityBefore;
    }


    @AfterReturning(pointcut = "execution(* com.aop.bookborrowingapplication.controller.BookController.completeBook(..))", returning = "result")
    public void logAfterCompleteBook(JoinPoint joinPoint, Object result) {
        Object[] args = joinPoint.getArgs();
        int bookId = (int) args[0];

        Optional<Book> optionalBook = bookService.findById(bookId);
        if (optionalBook.isPresent()) {
            Book foundBook = optionalBook.get();
            int quantity = foundBook.getQuantity();
            if (quantity != quantityBefore) {
                File file = new File(URL_LOG_BOOK);
                try {
                    FileWriter fileWriter = new FileWriter(file, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    String log = "Người dùng đã mượn sách vào lúc " + LocalDateTime.now() + " số lượng còn lại là " + quantity + "\n";
                    bufferedWriter.write(log);
                    bufferedWriter.flush();
                } catch (Exception e) {
                    logger.error("Lỗi ghi file");
                }
            }
        }
    }


    private int visitorCount = 0;

    @AfterReturning("execution(* com.aop.bookborrowingapplication.controller.BookController.*(..))")
    public void logVisitors(JoinPoint joinPoint) {
        visitorCount++;

        File file = new File(URL_LOG_VISITORS);
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String log = "Người dùng thực hiện thao tác vào lúc " + LocalDateTime.now() + ", Số lượng người ghé thăm: " + visitorCount + "\n";
            bufferedWriter.write(log);
            bufferedWriter.flush();
        } catch (Exception e) {
            logger.error("Lỗi ghi file", e);
        }
    }

    @AfterThrowing(value = "execution(* com.aop.bookborrowingapplication.controller.BookController.*(..))", throwing = "ex")
    public void logVisitorsAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        visitorCount++;

        File file = new File(URL_LOG_VISITORS);
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String log = "Người dùng thực hiện thao tác vào lúc " + LocalDateTime.now() + ", Số lượng người ghé thăm: " + visitorCount + "\n";
            bufferedWriter.write(log);
            bufferedWriter.flush();
        } catch (Exception e) {
            logger.error("Lỗi ghi file", e);
        }
    }
}

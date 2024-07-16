package com.mailbox.springmailbox.controller;

import com.mailbox.springmailbox.model.Mail;
import com.mailbox.springmailbox.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mailbox")
public class MailController {

    @Autowired
    private IMailBoxService mailBoxService;

    @GetMapping
    public String index(Model model) {
        Mail mail = mailBoxService.getAll();
        model.addAttribute("mail", mail);
        return "/home";
    }


    @GetMapping("/update")
    public String showUpdateForm(Model model) {
        Mail mail = mailBoxService.getAll();
        String[] languages = new String[] {"English", "Vietnamese", "Japanese", "Chinese"};
        int[] sizes = new int[] {5, 10, 15, 25, 50, 100};
        model.addAttribute("mail", mail);
        model.addAttribute("languages", languages);
        model.addAttribute("sizes", sizes);
        return "update";
    }

    @PostMapping("/update")
    public String updateMailSettings(@ModelAttribute("mail") Mail mail) {
        mailBoxService.save(mail);
        return "redirect:/mailbox";
    }

}

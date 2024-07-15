package com.conversion.sandwichcondiments.controller;


import com.conversion.sandwichcondiments.model.Sandwich;
import com.conversion.sandwichcondiments.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "sandwich")
public class SandwichController {

    @Autowired
    private ISandwichService sandwichService;

    @GetMapping
    public String showMenu(Model model){
        List<Sandwich> items = sandwichService.getAll();
        model.addAttribute("items", items);
        return "/home";
    }

    @PostMapping("/listMenu")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiment, Model model) {
        if (condiment == null) {
            return "redirect: /sandwich";
        }
        for (int i = 0; i < condiment.length; i++) {
            model.addAttribute("item"+i, condiment[i]);
        }
        return "/list";
    }
}

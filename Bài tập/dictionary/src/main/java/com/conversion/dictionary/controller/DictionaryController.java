package com.conversion.dictionary.controller;

import com.conversion.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class DictionaryController {

    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("/dictionary")
    public String showDictionary() {
        return "home";
    }

    @PostMapping("/dictionary")
    public String resultDictionary(@RequestParam("english") String word, Model model) {


        String vietnameseMeaning = dictionaryService.findMeaning(word);

        if (vietnameseMeaning != null) {
            model.addAttribute("word", vietnameseMeaning);
            return "home";
        } else {
            model.addAttribute("message", "Word not found in dictionary.");
            return "home";
        }
    }
}

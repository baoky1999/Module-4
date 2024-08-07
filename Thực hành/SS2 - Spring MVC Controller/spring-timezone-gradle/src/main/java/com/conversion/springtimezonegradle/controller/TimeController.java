package com.conversion.springtimezonegradle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {

    @GetMapping("/world-clock")
    public String getTimeByTimeZone(Model model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {

        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);

        long localTime = date.getTime() + (locale.getRawOffset() - local.getRawOffset());

        date.setTime(localTime);

        model.addAttribute("time", date);
        model.addAttribute("city", city);
        return "index";
    }


}

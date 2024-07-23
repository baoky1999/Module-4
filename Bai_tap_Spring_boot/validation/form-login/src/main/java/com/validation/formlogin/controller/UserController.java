package com.validation.formlogin.controller;

import com.validation.formlogin.dto.UserDTO;
import com.validation.formlogin.model.User;
import com.validation.formlogin.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public String create(Model model) {
        model.addAttribute("userDto", new UserDTO());
        return "view/create";
    }

    @PostMapping
    public String create(@Validated @ModelAttribute("userDto") UserDTO userDto,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "view/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        model.addAttribute("user", "Thêm mới thành công");
        return "view/result";
    }
}

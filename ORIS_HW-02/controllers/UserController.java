package itis.oris_hw02.controllers;

import itis.oris_hw02.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String getUser(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        return "user_page";
    }
}
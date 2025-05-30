package itis.oris_hw02.controllers;

import itis.oris_hw02.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ConfirmController {

    @Autowired
    private UserService userService;

    @GetMapping("/confirm/{code}")
    public String confirmUser(
            @PathVariable("code") String code,
            Model model
    ) {
        boolean success = userService.confirmUser(code);
        if (success) {
            return "confirm_success";
        } else {
            model.addAttribute("message", "Неверный код подтверждения или пользователь уже активирован.");
            return "confirm_fail";
        }
    }
}

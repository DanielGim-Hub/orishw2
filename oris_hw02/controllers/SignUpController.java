package itis.oris_hw02.controllers;

import freemarker.template.TemplateException;
import itis.oris_hw02.dto.UserForm;
import itis.oris_hw02.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

//контроллеры нужно чтобы объяснить спрингу что наше приложение
//это контрроллер которые отвечает за работу апи и иницизалирует ее
//RESTCONTROLLER И CONTROLLER ЧТО ТАКОЕ ИЗУЧИТЬ
@Controller
public class SignUpController {
    //поможет напрамую иниц класс и подробно расписыавть не нужно
    @Autowired//?
    private SignUpService signUpService;//

    @GetMapping("/signUp")//обработка страницы
    public String getSignUpPage() {
        return "sign_up_page";
    }

    @PostMapping("/signUp")//после того как получит данные выполнит редирект и в гет перейдет
    public String signUp(UserForm form) throws TemplateException, IOException {
        System.out.println("************");
        System.out.println(form.getLogin());
        System.out.println(form.getPassword());
        signUpService.addUser(form);
        return "redirect:/signUp";//напрямую вызываю вызов страницы
    }
}

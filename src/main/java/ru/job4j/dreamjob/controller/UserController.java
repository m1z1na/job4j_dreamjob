package ru.job4j.dreamjob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.dreamjob.model.User;
@Controller
@RequestMapping("/users")
public class UserController {
    @GetMapping("/login")
    public String getLoginPage() {
        return "users/login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model) {
//        var userOptional = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
//        if (userOptional.isEmpty()) {
//            model.addAttribute("error", "Почта или пароль введены неверно");
//            return "users/login";
//        }
        return "redirect:/vacancies";
    }
}

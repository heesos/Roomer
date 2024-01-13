package com.roomer.app.api;

import com.roomer.app.domain.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@AllArgsConstructor
@Controller
public class RegisterController {

    @GetMapping(value = "/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("name", "Test");
        return "registerForm";
    }
}

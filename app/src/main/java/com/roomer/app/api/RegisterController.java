package com.roomer.app.api;

import com.roomer.app.domain.Account;
import com.roomer.app.domain.User;
import com.roomer.app.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
public class RegisterController {

    private AccountService accountService;


    //it is crucial to add these empty entities of account and user, thus thymeleaf need some objects to map values to
    //otherwise it is not seeing any properties
    @GetMapping(value = "/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("account", new Account());
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Account> saveAccount(@ModelAttribute Account account, @ModelAttribute User user) {
        account.setUser(user);
        Account newAccount = accountService.saveAccount(account);

        return ResponseEntity.ok(newAccount);
    }

    //TODO:
    // verify if the password are the same
    // check if such account is not already in the db
}

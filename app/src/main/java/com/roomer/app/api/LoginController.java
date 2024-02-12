package com.roomer.app.api;

import com.roomer.app.domain.Account;
import com.roomer.app.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
public class LoginController {

    private AccountService accountService;

    @GetMapping(value = "/login")
    public String showLogin(Model model) {
        //model.addAttribute("Account", new Account());
        return "loginForm";
    }

    @PostMapping(value = "/login")
    public String authAccount(@ModelAttribute Account account) {
        Account authorizedAccount = accountService.getAccountLogin(account.getEmail(), account.getPassword());
        //this redirect is only for the test purpose
        return "redirect:/api/account/" + authorizedAccount.getEmail() + "/" + authorizedAccount.getPassword();
    }

    //TODO:
    // service for register
}

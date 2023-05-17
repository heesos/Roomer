package com.roomer.app.controller;

import com.roomer.app.domain.Account;
import com.roomer.app.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@AllArgsConstructor
@Controller
public class LoginController {

    private AccountService accountService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(Model model) {
        Account account = accountService.getAccountById(2L);
        model.addAttribute("account", account);
        return "loginForm";
    }

    @RequestMapping(value = "/login", params={"testParam"}, method = RequestMethod.GET)
    public String showData(Model model) {
        Account account = new Account();
        account.setPassword("testPass");
        account.setEmail("testPass");
        model.addAttribute("account", account);
        return "redirect:/loginForm";
    }
}

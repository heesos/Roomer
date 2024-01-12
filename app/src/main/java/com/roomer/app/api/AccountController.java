package com.roomer.app.api;

import com.roomer.app.domain.Account;
import com.roomer.app.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountController {
    private AccountService accountService;

    /**
     * Creates a new Account
     * @param account account object with all the information
     * @return HTTP response with new created Account
     */
    @PostMapping("/add")
    public ResponseEntity<Account> addUser(@RequestBody Account account) {
        Account newAccount = accountService.saveAccount(account);
        return ResponseEntity.ok(newAccount);
    }

    /**
     * Fetches a list of Accounts from database
     * @return list of Accounts
     */
    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accountList = accountService.getAllAccounts();
        return ResponseEntity.ok(accountList);
    }

    /**
     * Fetches Account from database by id
     * @param id id of account to be found
     * @return Account object
     */
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable("id") Long id) {
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }

    /**
     * Deletes a Account from database
     * @param id id of an Account to delete
     * @return HTTP Status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteAccount(@PathVariable("id") Long id) {
        accountService.removeAccountById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Updates an existing Account
     * @param account Account with new data
     * @param id id of an Account to update
     * @return Account object with new data which was saved to database
     */
    @PutMapping("/{id}")
    public ResponseEntity<Long> updateAccount(@RequestBody Account account, @PathVariable("id") Long id) {
        accountService.updateAccount(id, account);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{mail}/{password}")
    public ResponseEntity<Account> getAccountEMAIL(@PathVariable("mail") String mail, @PathVariable("password") String password) {
        Account account = accountService.getAccountLogin(mail, password);
        return ResponseEntity.ok(account);
    }
}

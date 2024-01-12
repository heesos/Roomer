package com.roomer.app.service;

import com.roomer.app.domain.Account;
import com.roomer.app.exception.AccountNotFoundException;
import com.roomer.app.exception.UserNotFoundException;
import com.roomer.app.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class responsible for business logic when performing database operations with Account entity
 *
 * @author milosz.marzec
 */

@Service
@AllArgsConstructor
public class AccountService {
    private AccountRepository accountRepository;

    /**
     * Saves a new Account to the database
     *
     * @param account Account entity
     * @return created Account in database
     */
    public Account saveAccount(Account account) {
        accountRepository.save(account);
        return account;
    }

    /**
     * Searches for all Accounts in database
     *
     * @return list of Accounts
     */
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    /**
     * Removes Account from database
     *
     * @param id id of Account to remove
     */

    public void removeAccountById(long id) {
        accountRepository.deleteById(id);
    }

    /**
     * Gets Account from database by id
     *
     * @param id Account id
     * @return Account object
     */
    public Account getAccountById(long id) {
        return accountRepository.findById(id).orElse(null);
    }

    /**
     * Updates an existing Account in the database
     *
     * @param accountId  id used to search Account to update
     * @param newAccount Account with the new data
     * @return id of an updated Account object
     */
    public long updateAccount(long accountId, Account newAccount) {
        Account accountToUpdate = accountRepository.getReferenceById(accountId);
        accountToUpdate.setEmail(newAccount.getEmail());
        accountToUpdate.setPassword(newAccount.getPassword());
        accountToUpdate.setUser(newAccount.getUser());

        accountRepository.save(accountToUpdate);

        return accountId;
    }

    /**
     * Find the account based on user input data
     *
     * @param email    email used for Account
     * @param password Account password
     * @return Account entity
     */
    public Account getAccountLogin(String email, String password) {
        Optional<Account> accountOptional = accountRepository.findAccountByEmailAndPassword(email, password);
        if (accountOptional.isEmpty()) {
            throw new AccountNotFoundException("Account not found");
        }

        return accountOptional.get();
    }
}

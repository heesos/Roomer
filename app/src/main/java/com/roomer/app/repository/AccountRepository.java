package com.roomer.app.repository;

import com.roomer.app.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT a FROM Account a WHERE a.email = ?1 AND a.password = ?2")
    Optional<Account> findAccountByEmailAndPassword(String email, String password);
}

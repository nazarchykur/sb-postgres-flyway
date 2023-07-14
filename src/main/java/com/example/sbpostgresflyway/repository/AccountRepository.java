package com.example.sbpostgresflyway.repository;

import com.example.sbpostgresflyway.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
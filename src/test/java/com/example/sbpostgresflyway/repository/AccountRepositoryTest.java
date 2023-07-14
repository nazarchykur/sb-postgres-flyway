package com.example.sbpostgresflyway.repository;

import com.example.sbpostgresflyway.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("postgres")    // using  resources/application-postgres.yml and testcontainers
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void findById_dataExist() {
        // given
        Account account = new Account();
        account.setFirstName("John");
        account.setLastName("Doe");
        account.setEmail("johndoe@example.com");
        account.setPassword("password");
        account.setCreatedAt(LocalDateTime.now());
        account.setUpdatedAt(LocalDateTime.now());
        accountRepository.save(account);

        // when
        Account accountResult = accountRepository.findById(account.getId()).get();

        // then
        assertThat(accountResult)
                .isNotNull()
                .isEqualTo(account);
    }

}
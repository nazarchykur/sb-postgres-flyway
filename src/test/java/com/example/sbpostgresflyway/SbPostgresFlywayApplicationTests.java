package com.example.sbpostgresflyway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/*
@SpringBootTest loads the complete spring context
Use @ActiveProfiles("postgres") with @SpringBootTest to run tests with the "postgres" profile.
This ensures that the resources/application-postgres.yml configuration is used instead of the default application.yml,
preventing changes in the real DB during testing.
 */
@SpringBootTest
@ActiveProfiles("postgres")
class SbPostgresFlywayApplicationTests {

    @Test
    void contextLoads() {
    }

}

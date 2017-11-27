package org.learn.agenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Teodora Bobirneci
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    CommandLineRunner init(final AccountService accountService) {
//        return arg0 -> accountService.createAccount(new Account("teodora", "Happy123"));
//    }

}
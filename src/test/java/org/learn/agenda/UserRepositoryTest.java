package org.learn.agenda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.learn.agenda.model.Account;
import org.learn.agenda.security.PasswordEncryptionService;
import org.learn.agenda.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * @author Teodora Bobirneci
 */
@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private AccountService accountService;
    @Autowired
    private PasswordEncryptionService passwordEncryptionService;

    @Test
    public void testSaveUser() {
        Account my = new Account("test", "buhu123");
        accountService.createAccount(my);

        assertEquals(my.getEncryptedPassword(), passwordEncryptionService.encodePassword("buhu123", my.getSalt()));
    }

}

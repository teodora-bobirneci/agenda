package org.learn.agenda.service.impl;

import org.learn.agenda.model.Account;
import org.learn.agenda.repository.AccountRepository;
import org.learn.agenda.security.PasswordEncryptionService;
import org.learn.agenda.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

import static com.google.common.collect.Lists.newArrayList;
import static org.learn.agenda.security.PasswordEncryptionService.generateRandomSalt;

/**
 * @author Teodora Bobirneci
 */
@Service
public class DefaultAccountService implements AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncryptionService passwordEncryptionService;

    @Autowired
    public DefaultAccountService(AccountRepository accountRepository, PasswordEncryptionService passwordEncryptionService) {
        this.accountRepository = accountRepository;
        this.passwordEncryptionService = passwordEncryptionService;
    }

    @Override
    public Account createAccount(Account account) {
        Account existing = accountRepository.findByUsername(account.getUsername());
        if (existing != null) {
            throw new ValidationException("Username already taken!");
        }
        account.setSalt(generateRandomSalt());
        account.setEncryptedPassword(passwordEncryptionService.encodePassword(account.getPassword(), account.getSalt()));
        return accountRepository.createUser(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);

        return new User(account.getUsername(), account.getEncryptedPassword(), newArrayList());
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }
}

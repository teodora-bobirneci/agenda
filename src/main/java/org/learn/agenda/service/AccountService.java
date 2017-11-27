package org.learn.agenda.service;

import org.learn.agenda.model.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Teodora Bobirneci
 */
public interface AccountService extends UserDetailsService {

    Account createAccount(Account account);

    Account findByUsername(String username);
}

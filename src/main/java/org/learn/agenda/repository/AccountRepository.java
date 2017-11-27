package org.learn.agenda.repository;

import org.learn.agenda.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Teodora Bobirneci
 */
public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findByUsername(String username);

    @Transactional
    default Account createUser(Account account) {
        return save(account);
    }

    @Transactional
    default void updatePassword(Account user, String newPassword) {
        throw new IllegalStateException("Not yet implemented!");
    }

}

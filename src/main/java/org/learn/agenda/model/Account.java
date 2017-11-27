package org.learn.agenda.model;


import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.FetchType.LAZY;

/**
 * @author Teodora Bobirneci
 */
@Entity
public class Account {

    @Id
    @GeneratedValue
    private long id;
    @Column
    private String username;
    @Transient
    private String password;
    @Column
    private String salt;
    @Column
    private String encryptedPassword;
    @OneToMany(mappedBy = "account", cascade = REFRESH, fetch = LAZY)
    private List<Day> agenda;

    public Account() {}

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public List<Day> getAgenda() {
        return agenda;
    }

    public void setAgenda(List<Day> agenda) {
        this.agenda = agenda;
    }
}
package com.atomic.models;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "accountname")
    private String accountname;

    @Column(name = "password")
    private String password;

    @OneToOne(mappedBy = "account")
    private User user;

    public Account() {

    }

    public Account(String accountname) {
        this.accountname = accountname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountname='" + accountname + '\'' +
                ", password='" + password + '\'' +
                ", user=" + user +
                '}';
    }
}

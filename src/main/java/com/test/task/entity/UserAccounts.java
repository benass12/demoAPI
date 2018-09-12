package com.test.task.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by benas on 18.7.23.
 */
@Entity(name = "user_accounts")
public class UserAccounts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @NotEmpty(message = "IBAN is required")
    @Size(min = 15, max = 34)
    private String iban;
    @NotEmpty(message = "Account name is required")
    @Size(min = 5, max = 15)
    private String accountName;

    @ManyToOne
    private User user;
    @ManyToOne
    private Customer customer;

    public UserAccounts(@NotEmpty(message = "IBAN is required") String iban, @NotEmpty(message = "Account name is required") String accountName) {
        this.iban = iban;
        this.accountName = accountName;
    }

    public UserAccounts() {
    }

    // Getter's and Setter's
    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

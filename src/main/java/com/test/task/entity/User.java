package com.test.task.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by benas on 18.7.23.
 */
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @NotEmpty(message = "Username is required")
    @Size(min = 5, max = 25)
    private String username;
    @NotEmpty(message = "Country is required")
    @Size(min = 4, max = 30)
    private String country;
    @NotEmpty(message = "Default Language is required")
    @Size(min = 3, max = 30)
    private String defaultLanguage;

    @OneToMany
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<UserRights> userRightss = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Customer> customers = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<UserAccounts> userAccountss = new ArrayList<>();

    public User(@NotEmpty(message = "Username is required") String username, @NotEmpty(message = "Country is required") String country, @NotEmpty(message = "Default Language is required") String defaultLanguage) {
        this.username = username;
        this.country = country;
        this.defaultLanguage = defaultLanguage;
    }

    // Getter's and Setter's
    public Integer getId() {
        return Id;
    }

    public void setId(Integer userId) {
        this.Id = Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public List<UserRights> getUserRightss(){
        return userRightss;
    }
    public List<UserAccounts> getUserAccountss(){
        return userAccountss;
    }
    public List<Customer> getCustomers(){
        return customers;
    }

    public User() {
    }
}

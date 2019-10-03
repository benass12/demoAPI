package com.test.task.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by benas on 18.7.23.
 */
@Entity(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @NotEmpty(message = "Country is required")
    @Size(min = 4, max = 30)
    private String country;
    @NotNull(message = "Customer CRM ID is required")
    private Integer crmCustomerId;

    @ManyToOne
    private User user;


    @OneToMany
    @JoinColumn(name = "customer_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<UserAccounts> userAccountss = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "customer_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<UserRights> userRightss = new ArrayList<>();


    public Customer(@NotEmpty(message = "Country is required") String country, @NotNull(message = "Customer CRM ID is required") Integer crmCustomerId) {
        this.country = country;
        this.crmCustomerId = crmCustomerId;
    }

    public Customer() {
    }

    // Getter's and Setter's
    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getCrmCustomerId() {
        return crmCustomerId;
    }

    public void setCrmCustomerId(Integer crmCustomerId) {
        this.crmCustomerId = crmCustomerId;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

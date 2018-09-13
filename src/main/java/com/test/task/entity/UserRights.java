package com.test.task.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by benas on 18.7.23.
 */
@Entity(name = "user_rights")
public class UserRights {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @NotEmpty(message = "Right type is required")
    @Size(min = 5, max = 20)
    private String rightType;

    @ManyToOne
    private User user;
    @ManyToOne
    private Customer customer;

    public UserRights(@NotEmpty(message = "Right type is required") String rightType) {
        this.rightType = rightType;
    }

    public UserRights() {
    }

    // Getter's and Setter's
    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getRightType() {
        return rightType;
    }

    public void setRightType(String rightType) {
        this.rightType = rightType;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

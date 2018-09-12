package com.test.task.controller;

import com.test.task.entity.Customer;
import com.test.task.entity.User;
import com.test.task.entity.UserAccounts;
import com.test.task.repository.CustomerRepository;
import com.test.task.repository.UserAccountsRepository;
import com.test.task.repository.UserRepository;
import com.test.task.service.UserAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by benas on 18.7.24.
 */
@CrossOrigin(value = "*")
@RestController
public class UserAccountsController {
    @Autowired
    private UserAccountsService userAccountsService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value = "/user_accounts/add/", method = RequestMethod.POST)
    public void addUserAccount(@Valid @RequestBody UserAccounts userAccounts){
        userAccountsService.addUserAccount(userAccounts);
    }
    @RequestMapping(value = "/user_accounts/get/", method = RequestMethod.GET)
    public Iterable<UserAccounts> getUserAccounts(){
       return userAccountsService.getAllUserAccounts();
    }
    @RequestMapping(value = "/user/user_accounts/add/", method = RequestMethod.POST)
    public void createUserAccountForUserAndCustomer(@Valid @RequestBody UserAccounts userAccounts, @RequestParam int userId, int customerId){
        if(userRepository.findById(userId).isPresent() && customerRepository.findById(customerId).isPresent()) {
            User user = userRepository.findById(userId).get();
            Customer customer = customerRepository.findById(customerId).get();
            userAccounts.setUser(user);
            userAccounts.setCustomer(customer);
            userAccountsService.addUserAccount(userAccounts);
        }

    }
}

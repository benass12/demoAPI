package com.test.task.controller;

import com.test.task.entity.Customer;
import com.test.task.entity.User;
import com.test.task.entity.UserRights;
import com.test.task.repository.CustomerRepository;
import com.test.task.repository.UserRepository;
import com.test.task.service.UserRightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by benas on 18.7.23.
 */
@CrossOrigin(value = "*")
@RestController
public class UserRightsController {
    @Autowired
    private UserRightsService userRightsService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value = "/user_rights/add/", method = RequestMethod.POST)
    public void addUserRight(@Valid @RequestBody UserRights userRights){
        userRightsService.addUserRights(userRights);
    }

    @RequestMapping(value = "/user_rights/get/", method = RequestMethod.GET)
    public Iterable<UserRights> getAllUserRights(){
        return userRightsService.getAllUserRights();
    }

    @RequestMapping(value = "/user/user_rights/add/", method = RequestMethod.POST)
    public void addUserRightsToUserAndCustomer(@Valid @RequestBody UserRights userRights, @RequestParam int userId, int customerId){
        if(userRepository.findById(userId).isPresent() && customerRepository.findById(customerId).isPresent()) {
            User user = userRepository.findById(userId).get();
            Customer customer = customerRepository.findById(customerId).get();
            userRights.setUser(user);
            userRights.setCustomer(customer);
            userRightsService.addUserRights(userRights);
        }

    }

}

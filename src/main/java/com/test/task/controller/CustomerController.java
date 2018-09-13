package com.test.task.controller;

import com.test.task.entity.Customer;
import com.test.task.entity.User;
import com.test.task.repository.UserRepository;
import com.test.task.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by benas on 18.7.23.
 */
@CrossOrigin(value = "*")
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/customer/add/", method = RequestMethod.POST)
    public void addNewCustomer(@Valid @RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @RequestMapping(value = "/customer/get/", method = RequestMethod.GET)
    public Iterable<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @RequestMapping(value = "/customer/user/add/", method = RequestMethod.POST)
    public void addCustomerForUser(@Valid @RequestBody Customer customer, @RequestParam int userId) {
        if (userRepository.findById(userId).isPresent()) {
            User user = userRepository.findById(userId).get();
            customer.setUser(user);
            customerService.addCustomer(customer);
        }
    }
}

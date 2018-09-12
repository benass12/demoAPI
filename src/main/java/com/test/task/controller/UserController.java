package com.test.task.controller;

import com.test.task.entity.User;
import com.test.task.repository.UserRepository;
import com.test.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by benas on 18.7.23.
 */
@CrossOrigin(value = "*")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //This request creates one user which is hardcoded manually in code
    @RequestMapping(value = "/user/create/", method = RequestMethod.POST)
    public void createUserManually(){
        userService.addUserManually();
    }
    //This request getting all added users
    @RequestMapping(value = "/user/get/", method = RequestMethod.GET)
    public Iterable<User> getUsers(){
        return userService.getAllUsers();
    }
    //This request creates one user require JSON body
    @RequestMapping(value = "/user/add/", method = RequestMethod.POST)
    public void addUser(@Valid @RequestBody User user){
        userService.addUser(user);
    }

}

package com.test.task.service;

import com.test.task.entity.User;
import com.test.task.entity.UserRights;
import com.test.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Optional;


/**
 * Created by benas on 18.7.23.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getAllUsers(){
      return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public void addUserManually(){
        User newUser = new User();
        newUser.setUsername("vienas123");
        newUser.setCountry("Lithuania");
        newUser.setDefaultLanguage("Lithuanian");
        userRepository.save(newUser);
    }

}

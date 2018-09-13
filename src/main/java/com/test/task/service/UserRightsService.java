package com.test.task.service;

import com.test.task.entity.UserRights;
import com.test.task.repository.UserRightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by benas on 18.7.23.
 */
@Service
public class UserRightsService {
    @Autowired
    private UserRightsRepository userRightsRepository;

    public Iterable<UserRights> getAllUserRights() {
        return userRightsRepository.findAll();
    }

    public Optional<UserRights> findById(Integer Id) {
        return userRightsRepository.findById(Id);
    }

    public void addUserRights(UserRights userRights) {
        userRightsRepository.save(userRights);
    }

}

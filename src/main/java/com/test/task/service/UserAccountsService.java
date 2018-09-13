package com.test.task.service;

import com.test.task.entity.UserAccounts;
import com.test.task.repository.UserAccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by benas on 18.7.24.
 */
@Service
public class UserAccountsService {
    @Autowired
    private UserAccountsRepository userAccountsRepository;

    public Iterable<UserAccounts> getAllUserAccounts() {
        return userAccountsRepository.findAll();
    }

    public void addUserAccount(UserAccounts userAccounts) {
        userAccountsRepository.save(userAccounts);
    }
}

package com.test.task.repository;

import com.test.task.entity.UserAccounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by benas on 18.7.24.
 */
@Repository
public interface UserAccountsRepository extends CrudRepository<UserAccounts, Integer> {

}

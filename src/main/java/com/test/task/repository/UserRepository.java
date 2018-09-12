package com.test.task.repository;

import com.test.task.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Created by benas on 18.7.23.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findById(Integer id);

}

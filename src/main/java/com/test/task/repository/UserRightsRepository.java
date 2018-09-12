package com.test.task.repository;

import com.test.task.entity.UserRights;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by benas on 18.7.23.
 */
@Repository
public interface UserRightsRepository extends CrudRepository<UserRights, Integer> {
}

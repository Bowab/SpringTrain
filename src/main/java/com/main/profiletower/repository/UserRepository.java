package com.main.profiletower.repository;

import com.main.profiletower.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.logging.LoggingPermission;


public interface UserRepository extends CrudRepository<User,Long> {
    User findByEmail(String email);
    User findFirstByUsername(String username);
    User findDistinctById(Long id);

}

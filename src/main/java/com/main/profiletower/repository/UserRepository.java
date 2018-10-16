package com.main.profiletower.repository;

import com.main.profiletower.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends CrudRepository<User,Long> {
    User findByEmail(String email);
    User findByUsername(String username);

}

package com.main.profiletower.services;


import com.main.profiletower.models.User;

public interface UserService {
    public User findUserByEmail(String email);
    public User findUserByUsername(String username);
    public User findUserById(Long id);
    public void saveUser(User user);
    public  Iterable<User> findAll();
}

package com.main.profiletower.services;


import com.main.profiletower.models.User;

public interface UserService {
    public User findUserByEmail(String email);
    public User findUserByUsername(String username);
    public void saveUser(User user);
}

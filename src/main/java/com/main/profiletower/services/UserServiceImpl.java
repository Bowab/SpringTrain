package com.main.profiletower.services;


import com.main.profiletower.models.Inbox;
import com.main.profiletower.models.Role;
import com.main.profiletower.models.User;
import com.main.profiletower.repository.InboxRepository;
import com.main.profiletower.repository.RoleRepository;
import com.main.profiletower.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


@Service("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private InboxRepository inboxRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    //Use to check if email is taken.
    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    //Use to check if username is taken.
    @Override
    public User findUserByUsername(String username) {

        return userRepository.findFirstByUsername(username);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findDistinctById(id);
    }


    @Override
    public void saveUser(User user) {

        //TODO: Check if username is taken.
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByRole("REGULAR");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);

        //Create a inbox for the newly added user.
        Inbox inbox = new Inbox();
        inbox.setUser(user);
        inboxRepository.save(inbox);


    }
}

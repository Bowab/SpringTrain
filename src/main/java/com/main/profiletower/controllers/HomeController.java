package com.main.profiletower.controllers;

import com.main.profiletower.models.User;
import com.main.profiletower.repository.UserRepository;
import com.main.profiletower.services.MessageService;
import com.main.profiletower.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



import java.security.Principal;

@Controller
@RequestMapping("/home")
public class HomeController {


    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/viewInbox", method = RequestMethod.GET)
    public ModelAndView viewInbox(){

        ModelAndView mw = new ModelAndView("home/viewInbox");
        //TODO: Find a real id and not a hardcoded one.
        mw.addObject("messageList", messageService.findUsersMessages(2));
        return mw;
    }

    @RequestMapping(value = "/userIdDisplay", method = RequestMethod.GET)
    public ModelAndView userIdDisplay(){


        //TODO: Working, is there a better way?

        //Get logged in username.
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        //Find logged in user in database by username.
        User user = new User();
        user = userService.findUserByUsername(username);

        //Get that user id.
        Long userId = user.getId();

        ModelAndView mw = new ModelAndView("home/userIdDisplay");
        mw.addObject("userId", userId);
        return mw;

    }


    @RequestMapping(value = "/userIdDisplayAgain", method = RequestMethod.GET)
    public ModelAndView userIdDisplayAgain(){

        //TODO: Experiment here with getting logged in user id.
        ModelAndView mw = new ModelAndView("home/userIdDisplayAgain");
        mw.addObject("userId", "ads");
        return mw;

    }



}

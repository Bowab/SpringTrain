package com.main.profiletower.controllers;

import com.main.profiletower.models.User;
import com.main.profiletower.repository.UserRepository;
import com.main.profiletower.services.MessageService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/viewInbox", method = RequestMethod.GET)
    public ModelAndView viewInbox(){

        ModelAndView mw = new ModelAndView("home/viewInbox");
        //TODO: Find a real id and not a hardcoded one.
        mw.addObject("messageList", messageService.findUsersMessages(2));
        return mw;
    }

    @RequestMapping(value = "/userIdDisplay", method = RequestMethod.GET)
    public ModelAndView userIdDisplay(){

        //TODO: Get user id from spring security.

        /*
        SecurityContext securityContext = SecurityContextHolder.getContext();
        String x = securityContext.getAuthentication().getName();

        User user = new User();

        long userId = user.getId();
        */

        //SecurityContext securityContext = SecurityContextHolder.getContext();
        //Authentication authentication = securityContext.getAuthentication();

        /*
        User user = (User) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        String name = user.getUsername();
        */


        ModelAndView mw = new ModelAndView("home/userIdDisplay");
        mw.addObject("userId", 100);
        return mw;

    }


    //TODO: This is working, remove when you solved how to get id.
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }



}

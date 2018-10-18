package com.main.profiletower.controllers;

import com.main.profiletower.models.User;
import com.main.profiletower.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView Registration(){

        ModelAndView mw = new ModelAndView("account/registration");
        return mw;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView Registration(User user){

        //TODO: If user exists already, don't save a user.
        userService.saveUser(user);
        ModelAndView mw = new ModelAndView("account/registration");
        return mw;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView Login(){

        ModelAndView mw = new ModelAndView("account/login");
        return mw;
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView AccessDenied(){
        ModelAndView mw = new ModelAndView("account/accessDenied");
        return mw;
    }


}

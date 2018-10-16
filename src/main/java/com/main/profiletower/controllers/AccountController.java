package com.main.profiletower.controllers;

import com.main.profiletower.models.User;
import com.main.profiletower.services.MessageService;
import com.main.profiletower.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewMethodReturnValueHandler;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView Registration(){

        ModelAndView mw = new ModelAndView("registration");
        return mw;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView Registration(User user){

        userService.saveUser(user);
        ModelAndView mw = new ModelAndView("registration");
        return mw;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView Login(){

        ModelAndView mw = new ModelAndView("login");
        return mw;
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView AccessDenied(){
        ModelAndView mw = new ModelAndView("accessDenied");
        return mw;
    }


}

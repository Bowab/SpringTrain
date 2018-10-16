package com.main.profiletower.controllers;

import com.main.profiletower.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/account")
public class AccountController {


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView Registration(){

        ModelAndView mw = new ModelAndView("registration");
        return mw;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView Registration(User user){

        ModelAndView mw = new ModelAndView("registration");
        return mw;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView Login(){

        ModelAndView mw = new ModelAndView("login");
        return mw;
    }


}

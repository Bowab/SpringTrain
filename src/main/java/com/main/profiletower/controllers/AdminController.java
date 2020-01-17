package com.main.profiletower.controllers;


import com.main.profiletower.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping("/layout")
    public  String layout(){
        return "layout";
    }

    @RequestMapping(value = "/adminIndex", method = RequestMethod.GET)
    public ModelAndView index(){

        ModelAndView mw = new ModelAndView("admin/adminIndex");

        return mw;
    }

    @RequestMapping(value = "/allusers", method = RequestMethod.GET)
    public ModelAndView AllUsers(){
        ModelAndView mw = new ModelAndView("admin/allUsers");
        mw.addObject("userList", userService.findAll());
        return mw;
    }

}

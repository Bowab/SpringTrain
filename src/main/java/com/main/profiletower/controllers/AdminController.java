package com.main.profiletower.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value = "/adminIndex", method = RequestMethod.GET)
    public ModelAndView index(){

        ModelAndView mw = new ModelAndView("adminIndex");

        return mw;
    }

}

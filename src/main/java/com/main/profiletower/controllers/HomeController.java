package com.main.profiletower.controllers;

import com.main.profiletower.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {


    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/viewInbox", method = RequestMethod.GET)
    public ModelAndView viewInbox(){

        ModelAndView mw = new ModelAndView("home/viewInbox");
        mw.addObject("messageList", messageService.findUsersMessages()); //Fix later to use a service
        return mw;
    }



}

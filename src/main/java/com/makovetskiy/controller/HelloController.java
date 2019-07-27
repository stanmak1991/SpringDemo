package com.makovetskiy.controller;

import com.makovetskiy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        throw new RuntimeException();
        //return "home";
    }

    @RequestMapping(value = "/params", method = RequestMethod.GET)
    public ModelAndView params(@RequestParam(required = false) String name, @RequestParam String age, ModelAndView mv) {
        mv.addObject("name", name);
        mv.addObject("age", age);
        mv.setViewName("params");
        return mv;
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.GET)
    public ModelAndView addUser(ModelAndView mv) {
        mv.setViewName("add-user");
        return mv;
    }

    public ModelAndView addUser(@ModelAttribute User user) {
        System.out.println();
        return null;
    }
}

package com.makovetskiy.controller;

import com.makovetskiy.controller.external.model.UserRegistrationPayLoad;
import com.makovetskiy.model.User;
import com.makovetskiy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all-users", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView mw) {
        List<User> users = userService.getAll().orElseGet(Collections::emptyList);
        mw.addObject("users", users);
        mw.setViewName("all-users");
        return mw;
    }



    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(ModelAndView mv) {
        mv.addObject("userRegistrationPayLoad", new UserRegistrationPayLoad());
        mv.setViewName("register");
        return mv;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@Valid @ModelAttribute UserRegistrationPayLoad urp, BindingResult br, ModelAndView mv) {
        if (br.hasErrors()) {
            mv.addAllObjects(br.getModel());
            mv.setViewName("register");
            return mv;
        }
        userService.add(User.of(urp));
        mv.addObject("user", new User());
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView mv) {
        mv.addObject("user", new User());
        mv.setViewName("login");
        return mv;
    }

    /*@RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(ModelAndView mv, @ModelAttribute User user) {
        mv.addObject("user", new User());
        mv.setViewName("login");
        return mv;
    }*/
}

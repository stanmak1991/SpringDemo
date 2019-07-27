package com.makovetskiy.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Throwable.class)
    public ModelAndView handleAll() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        return mv;
    }
}

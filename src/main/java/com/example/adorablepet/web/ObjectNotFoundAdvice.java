package com.example.adorablepet.web;

import com.example.adorablepet.models.entities.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ObjectNotFoundAdvice {

//    @ExceptionHandler({Exception.class})
//    public String handleError() {
//        return "redirect:error";
//    }


    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public ModelAndView onProductNotFound(ObjectNotFoundException onfe) {
        ModelAndView modelAndView = new ModelAndView("object-not-found");

        modelAndView.addObject("objectId", onfe.getObjectId());
        modelAndView.addObject("objectType", onfe.getObjectType());

        return modelAndView;
    }
}

package com.example.brettaapirest.controller.error;

import com.example.brettaapirest.handler.FoodNotFoundException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;

@ControllerAdvice
public class ExceptionController {

    // For UI Pages
    @ExceptionHandler(FoodNotFoundException.class)
    public ModelAndView handleFoodNotFoundException(FoodNotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorCode", HttpStatus.NOT_FOUND.value());
        modelAndView.addObject("errorMessage",  ex.getMessage());
        modelAndView.addObject("errorImage", "https://http.cat/404.jpg"); // URL de la imagen de gato para el error 404
        return modelAndView;
    }


    // For REST APIs
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> illegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
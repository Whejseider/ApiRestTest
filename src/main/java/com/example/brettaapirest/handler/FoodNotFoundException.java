package com.example.brettaapirest.handler;

import org.springframework.http.HttpStatus;

public class FoodNotFoundException extends IllegalArgumentException {
    public FoodNotFoundException(String name){
        super(String.format("Food with name %s not found", name));
    }
}

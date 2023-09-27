package com.example.brettaapirest.controller;

import com.example.brettaapirest.model.Beer;
import com.example.brettaapirest.service.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api")
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/cervezas")
    public Iterable<Beer> getBeers(){
        return this.beerService.getBeers();
    }
}

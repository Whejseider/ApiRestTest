package com.example.brettaapirest.service;

import com.example.brettaapirest.model.Beer;
import org.springframework.stereotype.Service;

public interface BeerService {
    Iterable<Beer> getBeers();
}

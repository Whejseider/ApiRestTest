package com.example.brettaapirest.service;

import com.example.brettaapirest.model.Beer;
import com.example.brettaapirest.repository.BeerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BeerServiceImpl implements BeerService{

    private final BeerRepository beerRepository;

    @Override
    public Iterable<Beer> getBeers() {
        return this.beerRepository.findAll();
    }
}

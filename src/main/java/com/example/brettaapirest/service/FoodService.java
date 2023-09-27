package com.example.brettaapirest.service;

import com.example.brettaapirest.model.Food;
import org.springframework.http.ResponseEntity;

public interface FoodService {

    Iterable<Food> getFoods();

    Food getFoodByName(String name);

    ResponseEntity<Food> addFood(Food food);

    ResponseEntity<Food> updateFoodById(Long id, Food updateFood);

    ResponseEntity<Food> deleteFoodByName(String name);

    Iterable<Food> getFoodsByCategory(String category);
}

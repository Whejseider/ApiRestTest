package com.example.brettaapirest.controller;

import com.example.brettaapirest.model.Food;
import com.example.brettaapirest.service.FoodService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api")
public class FoodController {

    private final FoodService foodService;

    @GetMapping("/comidas")
    @CrossOrigin
    public Iterable<Food> getFoods() {
        return this.foodService.getFoods();
    }

    @GetMapping("/comidas/{name}")
    public Food getFoodByName(@PathVariable @NonNull String name) {
        return this.foodService.getFoodByName(name);
    }

    @PostMapping("/comidas/agregar")
    public ResponseEntity<Food> addFood(@RequestBody @NonNull Food newFood) {
        return this.foodService.addFood(newFood);
    }

    @PutMapping("/comidas/actualizar/{id}")
    public ResponseEntity<Food> updateFoodById(@PathVariable @NonNull Long id, @RequestBody @NonNull Food updateFood){
        return this.foodService.updateFoodById(id, updateFood);
    }

    @DeleteMapping("/comidas/eliminar/{name}")
    public ResponseEntity<Food> deleteFoodByName(@PathVariable @NonNull String name){
        return this.foodService.deleteFoodByName(name);
    }

    @GetMapping("/comidas/categoria/{category}")
    public Iterable<Food> getFoodsByCategories(@PathVariable String category) {
        return this.foodService.getFoodsByCategory(category);
    }

}

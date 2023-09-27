package com.example.brettaapirest.service;

import com.example.brettaapirest.handler.FoodNotFoundException;
import com.example.brettaapirest.model.Category;
import com.example.brettaapirest.model.Food;
import com.example.brettaapirest.repository.CategoryRepository;
import com.example.brettaapirest.repository.FoodRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;
    private final CategoryRepository categoryRepository;
    private HttpServletResponse httpServletResponse;

    /**
     * Get all foods
     *
     * @return a list of all foods
     */
    @Override
    public Iterable<Food> getFoods() {
        return this.foodRepository.findAll();
    }

    /**
     * @param name of the food
     * @return food by name
     */
    @Override
    public Food getFoodByName(String name) {
        return this.foodRepository.findFoodByName(name).orElseThrow(() -> new FoodNotFoundException(name));
    }

    /**
     * Add food and save it to the database
     *
     * @param food The food that wants to add with all the parameters
     * @return
     */
    @Override
    public ResponseEntity<Food> addFood(Food food) {
        if (this.foodRepository.findFoodByName(food.getName()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.FOUND);
        }

        Long categoryId;

        for (Category category : food.getCategories()) {
            categoryId = this.categoryRepository.findCategoryByName(category.getName()).getId();
            category.setId(categoryId);
        }

        this.foodRepository.save(food);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }


    /**
     * Update food by id
     *
     * @param id         of the food
     * @param updateFood existing food with updated values
     * @return
     */
    @Override
    public ResponseEntity<Food> updateFoodById(Long id, Food updateFood) {
        if (!this.foodRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Food existFood = this.foodRepository.findById(id).orElseThrow(null);

        existFood.setDescription(updateFood.getDescription());
        existFood.setName(updateFood.getName());
        existFood.setCategories(updateFood.getCategories());
        existFood.setPrice(updateFood.getPrice());
        existFood.setImage(updateFood.getImage());

        this.foodRepository.save(existFood);

        return new ResponseEntity<>(existFood, HttpStatus.OK);

    }

    /**
     * Deletes food by name
     * TODO It's better to flag as DELETED rather than physically remove from the database!!!
     * @param name of the food that want to delete
     * @return
     */
    @Override
    public ResponseEntity<Food> deleteFoodByName(String name) {
        Optional<Food> foodToDelete = this.foodRepository.findFoodByName(name);

        if (foodToDelete.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.foodRepository.delete(foodToDelete.get());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public Iterable<Food> getFoodsByCategory(String category) {
        Category existCategory = this.categoryRepository.findCategoryByName(category);
        if (existCategory != null) {
            return this.foodRepository.findFoodsByCategoriesContains(existCategory);
        }
        return null;
    }
}

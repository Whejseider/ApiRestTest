package com.example.brettaapirest.repository;

import com.example.brettaapirest.model.Category;
import com.example.brettaapirest.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    Optional<Food> findFoodByName(String name);
    Iterable<Food> findFoodsByCategoriesContains(Category category);
}

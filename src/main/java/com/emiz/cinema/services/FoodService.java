package com.emiz.cinema.services;

import com.emiz.cinema.models.Food;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FoodService {
    List<Food> getAllFood();
    Food storeFood(Food food, MultipartFile imageFile) throws IOException;
    Food getFoodById(Long id);
    Food updateFood(Food food, MultipartFile imageFile) throws IOException;
    void deleteFood(Long id);
}

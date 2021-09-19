package com.emiz.cinema.services;

import com.emiz.cinema.models.Food;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FoodService {
    List<Food> getAllFood();
    Food storeFood(Food food, MultipartFile imageFile) throws IOException;
    Food updateFood(Food food);
    void deleteFood(Long id);
}

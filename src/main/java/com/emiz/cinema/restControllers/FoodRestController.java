package com.emiz.cinema.restControllers;

import com.emiz.cinema.models.Food;
import com.emiz.cinema.services.FoodService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class FoodRestController {

    private FoodService foodService;

    public FoodRestController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/foods")
    public List<Food> getAllFoods(){
        return foodService.getAllFood();
    }
}

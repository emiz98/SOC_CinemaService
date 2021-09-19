package com.emiz.cinema.controllers;

import com.emiz.cinema.models.Food;
import com.emiz.cinema.services.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FoodController {

    private FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/foods")
    public String getFoods(Model model){
        model.addAttribute("foods",foodService.getAllFood());
        return "views/foods/foods";
    }

    @GetMapping("/foods/new")
    public String createFood(Model model){
        Food food = new Food();
        model.addAttribute("food",food);
        return "views/foods/create";
    }

    @PostMapping("/foods")
    public String storeFood(@ModelAttribute("food") Food food, @RequestParam("imageFile")MultipartFile imageFile){
        try {
            foodService.storeFood(food, imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/foods";
    }

    @GetMapping("/foods/edit/{id}")
    public String editFood(@PathVariable("id") Long id, Model model){
        model.addAttribute("food",foodService.getFoodById(id));
        return "views/foods/edit";
    }

    @GetMapping("/foods/{id}")
    public String deleteFood(@PathVariable Long id){
        foodService.deleteFood(id);
        return "redirect:/foods";
    }

    @PostMapping("/foods/{id}")
    public String updateFood(@PathVariable Long id, @ModelAttribute("food") Food food, @RequestParam("imageFile") MultipartFile imageFile,Model model){
        Food existingFood = foodService.getFoodById(id);
        existingFood.setTitle(food.getTitle());
        existingFood.setDescription(food.getDescription());
        existingFood.setPrice(food.getPrice());

        try {
            foodService.updateFood(existingFood,imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/foods";
    }
}

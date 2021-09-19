package com.emiz.cinema.services.impl;

import com.emiz.cinema.models.Food;
import com.emiz.cinema.repos.FoodRepo;
import com.emiz.cinema.services.FoodService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class FoodServiceImpl implements FoodService {

    private FoodRepo foodRepo;

    public FoodServiceImpl(FoodRepo foodRepo) {
        this.foodRepo = foodRepo;
    }

    @Override
    public List<Food> getAllFood() {
        return foodRepo.findAll();
    }

    @Override
    public Food storeFood(Food food, MultipartFile imageFile) throws IOException {
        String folder = "src/main/resources/static/assets/foods/";
        String filename = UUID.randomUUID().toString();
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + filename + ".jpg");
        Files.write(path, bytes);
        food.setFood_image(filename + ".jpg");
        return foodRepo.save(food);
    }

    @Override
    public Food getFoodById(Long id) {
        return foodRepo.findById(id).get();
    }

    @Override
    public Food updateFood(Food food, MultipartFile imageFile) throws IOException {
        if (!imageFile.isEmpty()) {
            String folder = "src/main/resources/static/assets/foods/";
            String filename = UUID.randomUUID().toString();
            byte[] bytes = imageFile.getBytes();
            Path path = Paths.get(folder + filename + ".jpg");
            Path deletePath = Paths.get(folder + food.getFood_image());
            Files.delete(deletePath);
            Files.write(path, bytes);
            food.setFood_image(filename + ".jpg");
        }
        return foodRepo.save(food);
    }

    @Override
    public void deleteFood(Long id) {
        Food food = foodRepo.findById(id).get();
        String imageName = food.getFood_image();
        File fileToDelete = new File("src/main/resources/static/assets/foods/" + imageName);
        fileToDelete.delete();
        foodRepo.deleteById(id);
    }
}

package com.emiz.cinema.repos;

import com.emiz.cinema.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository<Food,Long> {
}

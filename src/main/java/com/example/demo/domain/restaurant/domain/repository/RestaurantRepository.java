package com.example.demo.domain.restaurant.domain.repository;

import com.example.demo.domain.restaurant.domain.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}

package com.example.demo.domain.restaurant.dto.response;

import com.example.demo.domain.restaurant.domain.entity.Restaurant;
import com.example.demo.domain.restaurant.domain.entity.Type;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RestaurantResponseDto {
    private String name;
    private Type type;
    private LocalDateTime creatAt;

    public RestaurantResponseDto(Restaurant restaurant) {
        this.name = restaurant.getName();
        this.type = restaurant.getType();
        this.creatAt = restaurant.getCreatedAt();
    }
}

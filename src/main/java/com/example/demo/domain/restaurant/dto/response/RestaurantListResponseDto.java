package com.example.demo.domain.restaurant.dto.response;

import com.example.demo.domain.restaurant.domain.entity.Restaurant;
import com.example.demo.domain.restaurant.domain.entity.Type;
import lombok.Getter;

@Getter
public class RestaurantListResponseDto {
    private Long id;
    private String name;
    private Type type;

    public RestaurantListResponseDto(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.type = restaurant.getType();
    }
}

package com.example.demo.domain.restaurant.dto;

import com.example.demo.domain.restaurant.domain.entity.Restaurant;
import com.example.demo.domain.restaurant.domain.entity.Type;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RestaurantCreateRequestDto {
    private String name;
    private Type type;

    @Builder
    public RestaurantCreateRequestDto(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public Restaurant toEntity() {
        return Restaurant.builder()
                .name(name)
                .type(type)
                .build();
    }
}

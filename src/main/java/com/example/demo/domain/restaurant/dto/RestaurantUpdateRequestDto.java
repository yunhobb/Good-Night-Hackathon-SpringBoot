package com.example.demo.domain.restaurant.dto;

import com.example.demo.domain.restaurant.domain.entity.Type;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RestaurantUpdateRequestDto {
    private Type type;

    @Builder
    public RestaurantUpdateRequestDto(Type type) {
        this.type = type;
    }
}

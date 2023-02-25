package com.example.demo.domain.restaurant.dto;

import com.example.demo.domain.restaurant.domain.entity.Type;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RestaurantTypeUpdateRequestDto {
    private Type type;

    @Builder
    public RestaurantTypeUpdateRequestDto(Type type) {
        this.type = type;
    }
}

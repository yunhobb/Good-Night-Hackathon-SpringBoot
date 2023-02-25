package com.example.demo.domain.restaurant.controller;

import com.example.demo.domain.restaurant.dto.RestaurantCreateRequestDto;
import com.example.demo.domain.restaurant.service.RestaurantService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/restaurants")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping
    public Long create(@RequestBody RestaurantCreateRequestDto requestDto) {
        return restaurantService.create(requestDto);
    }
}

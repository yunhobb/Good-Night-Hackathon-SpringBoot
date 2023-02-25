package com.example.demo.domain.restaurant.controller;

import com.example.demo.domain.restaurant.domain.entity.Type;
import com.example.demo.domain.restaurant.dto.RestaurantCreateRequestDto;
import com.example.demo.domain.restaurant.dto.RestaurantTypeUpdateRequestDto;
import com.example.demo.domain.restaurant.dto.response.RestaurantListResponseDto;
import com.example.demo.domain.restaurant.dto.response.RestaurantResponseDto;
import com.example.demo.domain.restaurant.service.RestaurantService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/restaurants")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping
    public Long create(@RequestBody RestaurantCreateRequestDto requestDto) {
        return restaurantService.create(requestDto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody RestaurantTypeUpdateRequestDto requestDto) {
        return restaurantService.update(id, requestDto);
    }

    @GetMapping("/{id}")
    public RestaurantResponseDto searchById(@PathVariable Long id) {
        return restaurantService.searchById(id);
    }

    @GetMapping
    public List<RestaurantListResponseDto> searchAll() {
        return restaurantService.searchAll();
    }

    @GetMapping("/categories")
    public List<RestaurantListResponseDto> searchByType(@RequestParam("type") Type type) {
        return restaurantService.searchByType(type);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
//        restaurantService.delete(id);
        restaurantService.delete(id);
    }
}

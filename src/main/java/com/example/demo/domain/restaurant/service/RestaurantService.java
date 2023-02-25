package com.example.demo.domain.restaurant.service;

import com.example.demo.domain.restaurant.domain.entity.Restaurant;
import com.example.demo.domain.restaurant.domain.repository.RestaurantRepository;
import com.example.demo.domain.restaurant.dto.RestaurantCreateRequestDto;
import com.example.demo.domain.restaurant.dto.RestaurantUpdateRequestDto;
import com.example.demo.domain.restaurant.dto.response.RestaurantResponseDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public Long create(RestaurantCreateRequestDto requestDto) {
        return restaurantRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, RestaurantUpdateRequestDto requestDto) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 레스토랑이 존재하지 않습니다."));

        restaurant.update(requestDto.getType());

        return id;
    }

    @Transactional(readOnly = true)
    public RestaurantResponseDto searchById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 레스토랑이 존재하지 않습니다."));

        return new RestaurantResponseDto(restaurant);
    }
}

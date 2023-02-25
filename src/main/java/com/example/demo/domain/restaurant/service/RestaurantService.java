package com.example.demo.domain.restaurant.service;

import com.example.demo.domain.restaurant.domain.repository.RestaurantRepository;
import com.example.demo.domain.restaurant.dto.RestaurantCreateRequestDto;
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
}

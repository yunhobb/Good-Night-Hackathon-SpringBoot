package com.example.demo.domain.restaurant.service;

import com.example.demo.domain.restaurant.domain.entity.Restaurant;
import com.example.demo.domain.restaurant.domain.entity.Type;
import com.example.demo.domain.restaurant.domain.repository.RestaurantRepository;
import com.example.demo.domain.restaurant.dto.RestaurantCreateRequestDto;
import com.example.demo.domain.restaurant.dto.RestaurantTypeUpdateRequestDto;
import com.example.demo.domain.restaurant.dto.response.RestaurantListResponseDto;
import com.example.demo.domain.restaurant.dto.response.RestaurantResponseDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Transactional
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public Long create(RestaurantCreateRequestDto requestDto) {
        return restaurantRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, RestaurantTypeUpdateRequestDto requestDto) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 레스토랑이 존재하지 않습니다."));

        restaurant.update(requestDto.getType());

        return id;
    }

    @Transactional(readOnly = true)
    public RestaurantResponseDto searchById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 레스토랑이 존재하지 않습니다."));

        return new RestaurantResponseDto(restaurant);
    }

    @Transactional(readOnly = true)
    public List<RestaurantListResponseDto> searchAll() {
        return restaurantRepository.findAll().stream()
                .map(RestaurantListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<RestaurantListResponseDto> searchByType(Type type) {
        return restaurantRepository.findByType(type).stream()
                .map(RestaurantListResponseDto::new)
                .collect(Collectors.toList());
    }

//    @Transactional
//    public void delete(Long id) {
//        Restaurant restaurant = restaurantRepository.findById(id)
//                .orElseThrow(()->new IllegalArgumentException("해당 레스토랑이 존재하지 않습니다."));
//
//        restaurantRepository.delete(restaurant);
//    }

    public void delete(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 레스토랑이 존재하지 않습니다."));

        restaurant.deleteEntity();
    }
}

package com.example.demo.domain.review.service;

import com.example.demo.domain.restaurant.domain.entity.Restaurant;
import com.example.demo.domain.restaurant.domain.repository.RestaurantRepository;
import com.example.demo.domain.review.domain.entity.Review;
import com.example.demo.domain.review.domain.repository.ReviewRepository;
import com.example.demo.domain.review.dto.ReviewCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    public ReviewCreateRequestDto create(Long id, ReviewCreateRequestDto requestDto) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 레스토랑이 존재하지 않습니다."));
        Review review = Review.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .restaurant(restaurant)
                .build();

        reviewRepository.save(review);
        return requestDto;
    }

    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
}
package com.example.demo.domain.review.controller;

import com.example.demo.domain.review.dto.ReviewCreateRequestDto;
import com.example.demo.domain.review.service.ReviewService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/reviews")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewController {
    private ReviewService reviewService;

    @PostMapping("/{id}")
    public ReviewCreateRequestDto create(@PathVariable Long id, @RequestBody ReviewCreateRequestDto requestDto) {
        return reviewService.create(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteById(id);
    }

}

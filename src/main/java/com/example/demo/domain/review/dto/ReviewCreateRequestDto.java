package com.example.demo.domain.review.dto;

import com.example.demo.domain.review.domain.entity.Review;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewCreateRequestDto {

    private String title;
    private String content;

    public Review toEntity() {
        return Review.builder()
                .title(title)
                .content(content)
                .build();
    }
}

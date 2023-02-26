package com.example.demo.domain.review.domain.entity;

import com.example.demo.domain.restaurant.domain.entity.Restaurant;
import com.example.demo.global.domain.BasetimeEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review  extends BasetimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Builder
    public Review(String title, String content, Restaurant restaurant) {
        this.title = title;
        this.content = content;
        this.restaurant = restaurant;
    }
}

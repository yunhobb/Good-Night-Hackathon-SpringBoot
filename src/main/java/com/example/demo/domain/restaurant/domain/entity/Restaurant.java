package com.example.demo.domain.restaurant.domain.entity;

import com.example.demo.domain.review.domain.entity.Review;
import com.example.demo.global.domain.BasetimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@SQLDelete(sql = "UPDATE restaurant SET deleted = true WHERE id = ?")
//@Where(clause = "isDeleted = false")
public class Restaurant extends BasetimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "restaurant_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private Type type;

    @OneToMany(mappedBy = "restaurant")
    private List<Review> reviews = new ArrayList<>();

    private Boolean isDeleted = Boolean.FALSE;

    @Builder
    public Restaurant(String name, Type type) {
        this.name = name;
        this.type = type;
        this.isDeleted = false;
    }

    public void update(Type type) {
        this.type = type;
    }
}

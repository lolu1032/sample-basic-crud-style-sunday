package com.example.demo.board.domain;

import com.example.demo.common.jpa.support.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Board extends BaseTimeEntity { // id createdAt updatedAt

    private String title;
    private String content;
    @Enumerated(EnumType.STRING)
    private BoardStatus status; // ordinal
}

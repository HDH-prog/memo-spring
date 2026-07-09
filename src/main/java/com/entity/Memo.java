package com.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;

    // 생성자
    public Memo(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // update 메서드
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

package com.dto;

import lombok.Getter;

@Getter
public class CreateMemoResponse {
    private final Long id;
    private final String title;
    private final String content;

    public CreateMemoResponse(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}

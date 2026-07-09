package com.dto;

import lombok.Getter;

@Getter
public class UpdateMemoResponse {
    private final Long id;
    private final String title;
    private final String content;

    public UpdateMemoResponse(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}

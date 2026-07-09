package com.dto;

import lombok.Getter;

@Getter
public class GetMemoResponse {
    private final Long id;
    private final String title;
    private final String content;

    public GetMemoResponse(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}

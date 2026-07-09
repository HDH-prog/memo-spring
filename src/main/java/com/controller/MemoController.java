package com.controller;

import com.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;
}

package com.service;

import com.repository.MemoRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;
}

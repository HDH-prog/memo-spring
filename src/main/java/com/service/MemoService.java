package com.service;

import com.dto.CreateMemoRequest;
import com.dto.CreateMemoResponse;
import com.entity.Memo;
import com.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public CreateMemoResponse save(CreateMemoRequest request) {
        Memo memo = new Memo(
                request.getTitle(),
                request.getContent()
        );
        Memo savedMemo = memoRepository.save(memo);
        return new CreateMemoResponse(
                savedMemo.getId(),
                savedMemo.getTitle(),
                savedMemo.getContent());
    }
}
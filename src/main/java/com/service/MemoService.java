package com.service;

import com.dto.*;
import com.entity.Memo;
import com.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Transactional(readOnly = true)
    public List<GetMemoResponse> getAll() {
        List<Memo> memoList = memoRepository.findAll();
        List<GetMemoResponse> responseList = new ArrayList<>();

        for (Memo memo : memoList) {
            GetMemoResponse response = new GetMemoResponse(
                    memo.getId(),
                    memo.getTitle(),
                    memo.getContent()
            );
            responseList.add(response);
        }
        return responseList;
    }

    @Transactional(readOnly = true)
    public GetMemoResponse getOne(Long memoId) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 메모입니다.")
        );
        return new GetMemoResponse(
                memo.getId(),
                memo.getTitle(),
                memo.getContent()
        );
    }

    @Transactional
    public UpdateMemoResponse update(Long memoId, UpdateMemoRequest request) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new IllegalStateException("해당 메모가 없습니다"));
        memo.update(request.getTitle(), request.getContent()
        );
        return new UpdateMemoResponse(memo.getId(), memo.getTitle(), memo.getContent());
    }

    @Transactional
    public void delete(Long memoId) {
        boolean existence = memoRepository.existsById(memoId);
        if (!existence) {
            throw new IllegalStateException("존재하지 않는 메모입니다.");
        }

        memoRepository.deleteById(memoId);
    }
}
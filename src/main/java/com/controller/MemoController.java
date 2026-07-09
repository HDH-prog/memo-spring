package com.controller;

import com.dto.*;
import com.entity.Memo;
import com.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    // 저장
    @PostMapping("/memos")
    public ResponseEntity<CreateMemoResponse> create(@RequestBody CreateMemoRequest request) {
        CreateMemoResponse result = memoService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // 전체 조회
    @GetMapping("/memos")
    public ResponseEntity<List<GetMemoResponse>> getAll() {
        List<GetMemoResponse> result = memoService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 단 건 조회
    @GetMapping("/memos/{memoId}")
    public ResponseEntity<GetMemoResponse> getOne(@PathVariable Long memoId) {
        GetMemoResponse result = memoService.getOne(memoId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 업데이트
    @PutMapping("/memos/{memoId}")
    public ResponseEntity<UpdateMemoResponse> update(
            @PathVariable Long memoId,
            @RequestBody UpdateMemoRequest request
    ) {
        UpdateMemoResponse result = memoService.update(memoId, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 삭제
    @DeleteMapping("/memos/{memoId}")
    public ResponseEntity<Void> delete(@PathVariable Long memoId) {
        memoService.delete(memoId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

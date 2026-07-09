# memo-spring

## 개요
Spring boot로 프로젝트 생성 및 CRUD 구현 실습을 위한 메모 기능 구현

## 기술 스택
- Java 21
- Spring boot
- Spring Data JPA
- MySQL
- Lombok
- Spring Web

## API 명세
- 저장: POST, /memos
- 전체조회: GET, /memos
- 단건조회: GET, /memos/{memoId}
- 수정: PUT, /memos/{memoId}
- 삭제: DELETE, /memos/{memoId}

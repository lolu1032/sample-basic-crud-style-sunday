package com.example.demo.board.service;

import com.example.demo.board.domain.Board;
import com.example.demo.board.repository.BoardRepository;
import org.springframework.stereotype.Service;

@Service
public class BoardCommandService implements BoardCreateUseCase { // implements Create , Update , Delete 만들 예정
    // CTRL + I 오버라이딩 편하게할 수 있음
    private final BoardRepository boardRepository;

    // 이 생성자 대신 사용가능한게 : @RequiredArgsConstructor above 클래스 (final,non-null 필드)
    public BoardCommandService(BoardRepository boardRepository /* 빈 오는 자리 */) {
        this.boardRepository = boardRepository; // 파라미터로 받은 빈을 -> 필드에 옮겨 담기
    }
    @Override
    public Board create(Board board) {
        // [1] 레퍼지터리에게 넘기기
        // board: ID가 없는 엔티티
        // savedEntity: ID가 생성된 엔티티 (저장도 완료된 엔티티)
        var savedEntity = boardRepository.save(board);

        // 결과 반환
        return savedEntity;
    }
}

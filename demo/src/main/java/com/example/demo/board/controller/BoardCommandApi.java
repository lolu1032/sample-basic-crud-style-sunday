package com.example.demo.board.controller;

import com.example.demo.board.controller.dto.BoardCommandDtos;
import com.example.demo.board.controller.dto.BoardCommandDtos.BoardCreateResponse;
import com.example.demo.board.domain.Board;
import com.example.demo.board.domain.BoardStatus;
import com.example.demo.board.service.BoardCreateUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("boards")
public class BoardCommandApi {

    private final BoardCreateUseCase boardCreateUseCase;

    /** Restful
     *  GET: 조회
     *  POST: 삽입
     *  PUT: 업데이트 (업데이트,삽입 둘 다지만... 업데이트로만.)
     *  (PATCH): 특정 부분만 골라서 거기만 업데이트(비밀번호 변경 등)
     *  DELETE: 삭제
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201 CREATED
    public BoardCreateResponse create(
            // @Vaild -> 유효성 애너테이션이 여기 바로 있진 않더라도
            // 이 클래스 안쪽에 들어가면 있으니까
            // 안쪽까지 가서 봐라 하는 지시
        @RequestBody @Valid BoardCommandDtos.BoardCreateRequest dto
    ) {
        // DTO -> Entity
        Board entity = Board.builder()
                .title(dto.title())
                .content(dto.content())
                .status(BoardStatus.ACTIVE)
                .build();
        // Save Entity
        // var: 컴파일타임 타입 추론
        var savedEntity = boardCreateUseCase.create(entity);

        // return
        return BoardCreateResponse.builder()
                .board(savedEntity)
                .build();
    }
}

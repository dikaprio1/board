package com.example.board.board.dto;

import com.example.board.board.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {
    private final Long id;
    private final String title;
    private final String contents;

    public BoardResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

    public static BoardResponseDto todto(Board board){
        return new BoardResponseDto(board.getId(),board.getTitle(),board.getContents());
    }
}

package com.example.board.member.dto;

import lombok.Getter;

@Getter
public class MemberResponseDto {
    private String username;
    private Integer age;

    public MemberResponseDto(String username, Integer age) {
        this.username = username;
        this.age = age;
    }
}

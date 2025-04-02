package com.example.board.member.controller;

import com.example.board.member.service.MemberService;
import com.example.board.signup.dto.SignUpRequestDto;
import com.example.board.signup.dto.SignUpResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto){
        SignUpResponseDto signUpResponseDto = memberService.signUp(requestDto.getUsername(),requestDto.getPassword(),requestDto.getAge());

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }
}

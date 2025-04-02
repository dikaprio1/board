package com.example.board.board.service;

import com.example.board.board.dto.BoardResponseDto;
import com.example.board.board.entity.Board;
import com.example.board.board.repository.BoardRepository;
import com.example.board.member.Repository.MemberRepository;
import com.example.board.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public BoardResponseDto save(String username, String contents,String title){
        Member findMember = memberRepository.findMemberByUsernameOrElseThrow(username);

        Board board = new Board(title, contents);
        board.setMember(findMember);

        boardRepository.save(board);

        return new BoardResponseDto(board.getId(),board.getTitle(),board.getContents());

    }
}

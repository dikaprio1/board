package com.example.board.board.service;

import com.example.board.board.dto.BoardResponseDto;
import com.example.board.board.dto.BoardWithAgeResponseDto;
import com.example.board.board.entity.Board;
import com.example.board.board.repository.BoardRepository;
import com.example.board.member.Repository.MemberRepository;
import com.example.board.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<BoardResponseDto> findAll(){
        return boardRepository.findAll().stream().map(BoardResponseDto :: todto).toList();
    }

    public BoardWithAgeResponseDto findById(Long id){
        Board findBoard = boardRepository.findByIdOrElseThrow(id);
        Member writer = findBoard.getMember();

        return new BoardWithAgeResponseDto(findBoard.getTitle(),findBoard.getContents(),writer.getAge());
    }

    public void delete(Long id){
        Board findBoard = boardRepository.findByIdOrElseThrow(id);
        boardRepository.delete(findBoard);
    }
}

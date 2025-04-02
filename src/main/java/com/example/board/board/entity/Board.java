package com.example.board.board.entity;

import com.example.board.baseentity.BaseEntity;
import com.example.board.member.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "board")
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    @Setter
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    public Board() {
    }

    public Board(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

}

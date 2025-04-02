package com.example.board.board.entity;

import com.example.board.baseentity.BaseEntity;
import com.example.board.member.entity.Member;
import jakarta.persistence.*;

@Entity
@Table(name = "board")
public class board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;
}

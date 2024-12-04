package com.example.blog.reply;

import com.example.blog.board.Board;
import com.example.blog.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Timestamp;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "reply_tb")
@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @CreationTimestamp
    private Timestamp createdAt;

    @Builder
    public Reply(Integer id, String comment, User user, Board board, Timestamp createdAt) {
        this.id = id;
        this.comment = comment;
        this.user = user;
        this.board = board;
        this.createdAt = createdAt;
    }
}

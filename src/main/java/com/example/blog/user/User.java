package com.example.blog.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Table(name = "user_tb")
@Getter
@Entity // 영속성 컨텍스트에 넣기 위해 필요
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 빌더 외의 방법으로 new 못하게
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // private인 이유: 객체 지향 -> 캡슐화 -> 상태 변경은 행위로만 해야한다.
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;

    @CreationTimestamp
    private Timestamp createdAt;

    // @Builder 쓰는 법. 풀 생성자를 컬렉션 필드만 빼고 만든다.
    @Builder
    public User(Integer id, String username, String password, String email, Timestamp createdAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
    }
}
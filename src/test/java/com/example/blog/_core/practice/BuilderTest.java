package com.example.blog._core.practice;

import org.junit.jupiter.api.Test;

class Member {
    private Integer id;
    private String name;
    private String addr;

    private Member() {
    }

    public static Member builder() {
        return new Member();
    }

    public Member id(Integer id) {
        this.id = id;
        // new 되서 메모리에 올라가면 그 객체가 this가 된다.
        return this;
    }

    public Member name(String name) {
        this.name = name;
        return this;
    }

    public Member addr(String addr) {
        this.addr = addr;
        return this;
    }
}

public class BuilderTest {

    @Test
    public void new_test() {
        // 빌더 패턴
        Member m = Member.builder() // 필드 숫자가 많을 때 원하는 필드만 넣기 좋음, 순서도 바꿀 수 있다.
                .id(1) // 필드 별로 개행
                .name("이름")
                .addr("주소");
    }
}

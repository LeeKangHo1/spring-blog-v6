package com.example.blog.reply;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(ReplyRepository.class)
@DataJpaTest // DB 관련된 자원들을 메모리(IoC)에 올린다.
public class ReplyRepositoryTest {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void findAll_test() {
        List<Reply> replyList = replyRepository.findAll();

        Assertions.assertThat(replyList).isNotNull();

        Assertions.assertThat(replyList).first().isNotNull();
        Assertions.assertThat(replyList).element(9).isNotNull();

        System.out.println("==============테스트 완료===================");
    }
}

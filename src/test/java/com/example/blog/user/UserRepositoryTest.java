package com.example.blog.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(UserRepository.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUsername_test() {
        // given
//        String username = "ssar"; // 성공
        String username = "cos";
//        String username = "hello"; // fail까지 확인해야 테스트 끝

        // when
        User user = userRepository.findByUsername(username);

        // then
        Assertions.assertThat(user).isNotNull();
    }

    @Test
    public void userSave_test() {
        // given
        User userSave = User.builder()
                .username("test")
                .password("1234")
                .email("test@test.com")
                .build();

        // when
        userRepository.userSave(userSave);

        // then
        User user = userRepository.findByUsername("test");
        Assertions.assertThat(user).isNotNull();
    }
}

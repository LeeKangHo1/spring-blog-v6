package com.example.blog.user;

import lombok.Data;

public class UserRequest {
    @Data
    public static class LoginDTO {
        private String username;
        private String password;
    }

    @Data
    public static class JoinDTO {
        private String username;
        private String password;
        private String email;

        public User toEntity() {
            User user = User.builder()
                    .username(username)
                    .password(password)
                    .email(email)
                    .build();
            return user;
        }
    }

}

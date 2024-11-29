package com.example.blog.user;

import com.example.blog._core.error.ex.Exception400;
import com.example.blog._core.error.ex.Exception401;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final EntityManager em;

    // db에서 username이 존재하는 지 조회
    public User findByUsername(String username) {
        Query q = em.createQuery("select u from User u where u.username = :username", User.class);
        q.setParameter("username", username);

        try {
            return (User) q.getSingleResult();
        } catch (RuntimeException e) {
            throw new Exception401("아이디가 일치하지 않습니다.");
        }
    }

    public void userSave(User user) {
        em.persist(user);
    }
}

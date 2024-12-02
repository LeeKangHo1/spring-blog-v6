package com.example.blog.reply;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ReplyRepository {

    private final EntityManager em;

    public List<Reply> findAll() {
        return em.createQuery("select r from Reply r order by r.createdAt", Reply.class)
                .getResultList();
    }
}

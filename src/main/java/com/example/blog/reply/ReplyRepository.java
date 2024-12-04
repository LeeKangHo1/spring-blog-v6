package com.example.blog.reply;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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

    public void deleteAll(int boardId){
        Query q = em.createQuery("delete from Reply r where r.board.id=:boardId");
        q.setParameter("boardId", boardId);
        q.executeUpdate();
    }
    public void updateNull(int boardId){
        Query q = em.createQuery("update Reply r set r.board.id=null where r.board.id=:boardId");
        q.setParameter("boardId", boardId);
        q.executeUpdate();
    }
}

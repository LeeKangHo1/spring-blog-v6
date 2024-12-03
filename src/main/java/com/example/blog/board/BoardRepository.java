package com.example.blog.board;

import com.example.blog._core.error.ex.Exception400;
import com.example.blog._core.error.ex.Exception404;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class BoardRepository {

    private final EntityManager em;

    public List<Board> findAll() {
        return em.createQuery("select b from Board b order by b.id desc", Board.class)
                .getResultList();
    }

    public Optional<Board> findById(int id) {
        return Optional.ofNullable(em.find(Board.class, id));
    }

    // 유저까지 조회해서 1번에 보드, 유저 검색하기
    public Optional<Board> findByIdJoinUser(int id) {
        // jpql은 객체 지향 쿼리 언어
        String sql = """
                select b from Board b join fetch b.user where b.id = :id
                """;
        Query q = em.createQuery(sql, Board.class);
        q.setParameter("id", id);

        try {
            Board board = (Board) q.getSingleResult();
            return Optional.ofNullable(board);
        } catch (RuntimeException e) {
            return Optional.ofNullable(null);
        }
    }

    // 유저까지 조회해서 1번에 보드, 유저 검색하기
    public Optional<Board> findByIdJoinUserAndReply(int id) {
        // jpql은 객체 지향 쿼리 언어                      left 걸면 오른쪽은 left 다 붙여야 한다.
        String sql = """
                select b from Board b join fetch b.user left join fetch b.replies r left join fetch r.user where b.id = :id
                """;
        Query q = em.createQuery(sql, Board.class);
        q.setParameter("id", id);

        try {
            Board board = (Board) q.getSingleResult();
            return Optional.ofNullable(board);
        } catch (RuntimeException e) {
            return Optional.ofNullable(null);
        }
    }

    public void delete(int id) {
        em.createQuery("delete from Board b where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public void save(Board board) {
        // board는 비영속 상태
        em.persist(board);
        // 동기화 완료 (영속화됨)
    }


}









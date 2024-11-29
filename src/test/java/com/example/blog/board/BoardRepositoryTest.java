package com.example.blog.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(BoardRepository.class)
@DataJpaTest // DB 관련된 자원들을 메모리(IoC)에 올린다.
public class BoardRepositoryTest {

//    @Autowired
//    private BoardRepository boardRepository;
//
//    @Test
//    public void delete_test(){
//        // given
//        int id = 1;
//
//        // when
//        boardRepository.delete(id);
//
//        // eye
//        List<Board> boardList = boardRepository.findAll();
//        System.out.println("size : "+boardList.size());
//    }
//
//    @Test
//    public void save_test(){
//        // given
//        String title = "제목6";
//        String content = "내용6";
//
//        // when
//        boardRepository.save(title, content);
//
//        // eye
//        Board board = boardRepository.findById(6);
//        System.out.println(board.getId());
//        System.out.println(board.getTitle());
//        System.out.println(board.getContent());
//
//    } // rollback (@Transactional)
//
//    @Test
//    public void findAll_test(){
//        // given
//
//        // when
//        List<Board> boardList = boardRepository.findAll();
//        System.out.println();
//
//        // eye
//        for(Board board : boardList){
//            System.out.println(board.getId());
//            System.out.println(board.getTitle());
//            System.out.println(board.getContent());
//            System.out.println(board.getCreatedAt());
//            System.out.println("============");
//        }
//    }
}

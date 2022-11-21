package spring.boot.crud.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.crud.entity.BoardEntity;
import spring.boot.crud.repository.BoardRepository;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BoardServiceImplTest {


    @Autowired
    private BoardRepository boardRepository;

    @DisplayName("board entity가 작동하는지 테스트")
    @Test
    void createBoardTest(){
        BoardEntity boardEntity = new BoardEntity();
        System.out.println("boardEntity"+boardEntity.getCreateDate());

    }


    @Test
    void createBoard() {
        BoardEntity entity = new BoardEntity();
        entity.setContent("testcontent");
        entity.setTitle("testtitle");

        BoardEntity boardEntity = this.boardRepository.save(entity);

        assertEquals(boardEntity.getTitle(),"testtitle");
        assertEquals(boardEntity.getContent(),"testcontent");
        assertEquals(boardEntity.getId(),1L);
    }

    @Test
    void readBoard() {
    }

    @Test
    void readBoardAll() {
    }


    @DisplayName("insert시, createDate와 updateDate는 동일, update시에는 달라짐")
    @Test
    void updateBoard() {
        BoardEntity entity = new BoardEntity();
        entity.setContent("testcontent");
        entity.setTitle("testtitle");

        BoardEntity boardEntity = this.boardRepository.save(entity);

//        System.out.println("insertBoardEntity : "+boardEntity);


        boardEntity.setTitle("testcontetupdate");
        boardEntity.setContent("testtitleupdate");

        BoardEntity updateBoardEntity = this.boardRepository.save(boardEntity);
//        System.out.println("updateBoardEntity : "+updateBoardEntity);

        assertEquals(boardEntity.getCreateDate(),updateBoardEntity.getCreateDate());
        assertEquals(boardEntity.getCreateDate(),boardEntity.getUpdateDate());
        assertNotEquals(boardEntity.getUpdateDate(),updateBoardEntity.getUpdateDate());


    }


}
package spring.boot.crud.service;

import spring.boot.crud.entity.BoardEntity;
import spring.boot.crud.vo.CRUDVO;
import spring.boot.crud.vo.UpdateVO;

import java.util.List;

public interface CRUDservice {

    BoardEntity createBoard(CRUDVO params);

    BoardEntity readBoard(Long board_no);

    List<BoardEntity> readBoardAll();

    BoardEntity updateBoard(UpdateVO params);

    void deleteBoard(Long board_no);

}

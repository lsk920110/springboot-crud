package spring.boot.crud.service;

import spring.boot.crud.entity.BoardEntity;
import spring.boot.crud.repository.BoardListReadAll;
import spring.boot.crud.vo.Board.BoardVO;
import spring.boot.crud.vo.Board.UpdateVO;

import java.util.List;

public interface BoardService {

    BoardEntity createBoard(BoardVO params);

    BoardEntity readBoard(Long board_no);

    List<BoardEntity> readBoardAll();

    BoardEntity updateBoard(UpdateVO params);

    void deleteBoard(Long board_no);

    List<BoardListReadAll> readBoardAll2();

}

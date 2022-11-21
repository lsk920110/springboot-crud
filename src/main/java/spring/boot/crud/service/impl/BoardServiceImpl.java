package spring.boot.crud.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import spring.boot.crud.entity.BoardEntity;
import spring.boot.crud.repository.BoardListReadAll;
import spring.boot.crud.repository.BoardRepository;
import spring.boot.crud.service.BoardService;
import spring.boot.crud.vo.Board.BoardVO;
import spring.boot.crud.vo.Board.UpdateVO;

import java.util.List;
import java.util.Optional;


@Service("CRUDserviceImpl")
@Slf4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;


    @Override
    public BoardEntity createBoard(BoardVO params) {
        log.info("{}",this.getClass());
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setTitle(params.getTitle());
        boardEntity.setContent(params.getContent());
        BoardEntity entity = this.boardRepository.save(boardEntity);

        return entity;
    }


    @Override
    public BoardEntity readBoard(Long board_no) {


        Optional<BoardEntity> boardEntity = this.boardRepository.findById(board_no);
        BoardEntity boardEntity1 = boardEntity.orElseThrow(() -> new DataAccessResourceFailureException("DB접근실패"));

        return boardEntity1;
    }


    @Override
    public List<BoardEntity> readBoardAll() {

        List<BoardEntity> all = this.boardRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
        return all;
    }

    @Override
    public List<BoardListReadAll> readBoardAll2(){
        List<BoardListReadAll> allBy = this.boardRepository.findAllBy();
        return allBy;
    }


    @Override
    public BoardEntity updateBoard(UpdateVO params) {
        BoardEntity entity = new BoardEntity();
        entity.setTitle(params.getTitle());
        entity.setContent(params.getContent());

//        BoardEntity updateDoardEntity = this.cruDrepository.save(entity);
        Optional<BoardEntity> byId = this.boardRepository.findById(params.getId());
        return byId.get();
    }

    @Override
    public void deleteBoard(Long board_no) {
        this.boardRepository.deleteById(board_no);
    }
}

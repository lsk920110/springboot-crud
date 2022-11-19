package spring.boot.crud.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import spring.boot.crud.entity.BoardEntity;
import spring.boot.crud.repository.CRUDrepository;
import spring.boot.crud.service.CRUDservice;
import spring.boot.crud.vo.CRUDVO;
import spring.boot.crud.vo.UpdateVO;

import java.util.List;
import java.util.Optional;


@Service("CRUDserviceImpl")
@Slf4j
@AllArgsConstructor
public class CRUDserviceImpl implements CRUDservice {

    private final CRUDrepository cruDrepository;


    @Override
    public BoardEntity createBoard(CRUDVO params) {
        log.info("{}",this.getClass());
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setTitle(params.getTitle());
        boardEntity.setContent(params.getContent());
        BoardEntity entity = this.cruDrepository.save(boardEntity);

        return entity;
    }


    @Override
    public BoardEntity readBoard(Long board_no) {


        Optional<BoardEntity> boardEntity = this.cruDrepository.findById(board_no);
        BoardEntity boardEntity1 = boardEntity.orElseThrow(() -> new DataAccessResourceFailureException("DB접근실패"));

        return boardEntity1;
    }


    @Override
    public List<BoardEntity> readBoardAll() {

        List<BoardEntity> all = this.cruDrepository.findAll(Sort.by(Sort.Direction.DESC,"id"));

        return all;
    }


    @Override
    public BoardEntity updateBoard(UpdateVO params) {
        BoardEntity entity = new BoardEntity();
        entity.setTitle(params.getTitle());
        entity.setContent(params.getContent());

//        BoardEntity updateDoardEntity = this.cruDrepository.save(entity);
        Optional<BoardEntity> byId = this.cruDrepository.findById(params.getId());
        return byId.get();
    }

    @Override
    public void deleteBoard(Long board_no) {
        this.cruDrepository.deleteById(board_no);
    }
}

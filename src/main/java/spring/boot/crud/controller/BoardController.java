package spring.boot.crud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.boot.crud.entity.BoardEntity;
import spring.boot.crud.service.BoardService;
import spring.boot.crud.vo.Board.BoardVO;
import spring.boot.crud.vo.Board.UpdateVO;

@RestController
@Slf4j
public class BoardController {


    @Autowired
    private BoardService boardService;

    //Create
    @PostMapping("/create")
    public Object create(@RequestBody BoardVO params){

        log.info("params : {}",params);
        return boardService.createBoard(params);

//        return "success";
    }



    //Read
//    @GetMapping("/read/{id}")
//    public Object read(@PathVariable Long id){
//
//        return cruDservice.readBoard(id);
//    }

//    @GetMapping("/read")
//    public Object read(){
//
//
//        return cruDservice.readBoardAll();
//    }



    //Update
    @PutMapping("/update/{id}")
    public Object update(@PathVariable Long id , @RequestBody UpdateVO params){

        params.setId(id);
        BoardEntity updateBoardEntity = boardService.updateBoard(params);

        return updateBoardEntity;
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public Object delete(@PathVariable Long id){
        boardService.deleteBoard(id);
        return "delete success";
    }


}

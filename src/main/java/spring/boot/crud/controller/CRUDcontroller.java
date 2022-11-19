package spring.boot.crud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.boot.crud.entity.BoardEntity;
import spring.boot.crud.service.CRUDservice;
import spring.boot.crud.vo.CRUDVO;
import spring.boot.crud.vo.UpdateVO;

@RestController
@Slf4j
public class CRUDcontroller {


    @Autowired
    private CRUDservice cruDservice;

    //Create
    @PostMapping("/create")
    public Object create(@RequestBody CRUDVO params){

        log.info("params : {}",params);
        return cruDservice.createBoard(params);

//        return "success";
    }



    //Read
    @GetMapping("/read/{id}")
    public Object read(@PathVariable Long id){

        return cruDservice.readBoard(id);
    }

    @GetMapping("/read")
    public Object read(){


        return cruDservice.readBoardAll();
    }



    //Update
    @PutMapping("/update/{id}")
    public Object update(@PathVariable Long id , @RequestBody UpdateVO params){

        params.setId(id);
        BoardEntity updateBoardEntity = cruDservice.updateBoard(params);

        return updateBoardEntity;
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public Object delete(@PathVariable Long id){
        cruDservice.deleteBoard(id);
        return "delete success";
    }


}

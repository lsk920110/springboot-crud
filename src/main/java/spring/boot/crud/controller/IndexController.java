package spring.boot.crud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import spring.boot.crud.entity.BoardEntity;
import spring.boot.crud.service.BoardService;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("boardList", boardService.readBoardAll2());
        return "main";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Long id){
        BoardEntity boardEntity = boardService.readBoard(id);
        ModelAndView mav = new ModelAndView("detail");
        log.info("detail : ", boardEntity.getTitle());
        mav.addObject("boardDetail",boardEntity);
        return mav;
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id){

        return "update";
    }




}

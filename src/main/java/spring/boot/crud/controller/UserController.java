package spring.boot.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.boot.crud.service.UserService;
import spring.boot.crud.vo.ResultVO;
import spring.boot.crud.vo.user.UserVO;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/join")
    public String goToJoinPage(){
        return "join";
    }

    @PostMapping(value = "/join")
    @ResponseBody
    public ResultVO<?> join(UserVO params){
        userService.registUser(params);



        return null;
    }



}

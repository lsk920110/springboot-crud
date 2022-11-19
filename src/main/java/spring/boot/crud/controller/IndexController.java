package spring.boot.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {


    @GetMapping("/")
    public String main(){

        return "main";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id){

        return "detail";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id){

        return "update";
    }




}

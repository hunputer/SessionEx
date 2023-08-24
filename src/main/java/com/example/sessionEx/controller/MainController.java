package com.example.sessionEx.controller;

import com.example.sessionEx.service.MainService;
import com.example.sessionEx.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping("/")
    public String main(){

        List<UserVO> userList = mainService.getUser();

        System.out.println("");

        return "mainForm";
    }

}

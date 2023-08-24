package com.example.sessionEx.controller;

import com.example.sessionEx.service.MainService;
import com.example.sessionEx.util.SessionUtil;
import com.example.sessionEx.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;
    private final SessionUtil sessionUtil;

    @GetMapping("/")
    public String main(){

        List<UserVO> userList = mainService.getUser();

        System.out.println("");

        return "mainForm";
    }

    @GetMapping("/login")
    public void login(HttpServletRequest httpServletRequest, @RequestBody UserVO userVO){
        List<UserVO> userList = mainService.getUser();
        UserVO user = userList.get(0);

        SessionUtil.login(httpServletRequest, user);
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest httpServletRequest){
        SessionUtil.logout(httpServletRequest);
    }

    @GetMapping("/getUser")
    public void getUser(HttpServletRequest httpServletRequest){
        SessionUtil.logout(httpServletRequest);
    }
}

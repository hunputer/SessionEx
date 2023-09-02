package com.example.sessionEx.controller;

import com.example.sessionEx.entity.LoginEntity;
import com.example.sessionEx.service.MainService;
import com.example.sessionEx.util.SessionUtil;
import com.example.sessionEx.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.Session;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping("/")
    public String main(HttpServletRequest request){

        if(!SessionUtil.isLogin(request)){
            return "redirect:./loginReg";
        }

        UserVO userVO = SessionUtil.getUser(request);
        request.setAttribute("user", userVO);

        return "main";
    }

    @GetMapping("/loginReg")
    public String loginRegForm(HttpServletRequest request){

        if(SessionUtil.isLogin(request)){
            return "redirect:/";
        }

        return "loginRegForm";
    }

    @PostMapping("/login")
    public ResponseEntity<LoginEntity> login(HttpServletRequest request, @RequestBody UserVO userVO){
        LoginEntity loginEntity = new LoginEntity();
        UserVO user = mainService.getUser(userVO);

        if(user != null && user.getId() != "") {
            SessionUtil.login(request, user);
            loginEntity.setCode(200);
            return new ResponseEntity<>(loginEntity, HttpStatus.OK);
        }else{
            loginEntity.setCode(401);
            return new ResponseEntity<>(loginEntity, HttpStatus.OK);
        }
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request){
        SessionUtil.logout(request);
    }

    @GetMapping("/error")
    public String errorPage(HttpServletRequest request){
        return "error";
    }
}

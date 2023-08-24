package com.example.sessionEx.util;

import com.example.sessionEx.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SessionUtil {

    public static void login(HttpServletRequest v1, UserVO userVo){
        HttpSession session = v1.getSession(true);
        synchronized (session){
            session.setAttribute("user", userVo);
        }
    }

    public static boolean isLogin(HttpServletRequest v1){
        HttpSession session = v1.getSession(true);
        return session.getAttribute("user") != null ? true : false;
    }

    public static UserVO getUser(HttpServletRequest v1){
        HttpSession session = v1.getSession(true);
        return (UserVO)session.getAttribute("user");
    }

    public static void logout(HttpServletRequest v1){
        HttpSession session = v1.getSession(true);
        session.invalidate();
    }
}

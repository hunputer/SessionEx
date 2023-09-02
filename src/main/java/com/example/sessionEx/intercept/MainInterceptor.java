package com.example.sessionEx.intercept;

import com.example.sessionEx.service.MainService;
import com.example.sessionEx.util.SessionUtil;
import com.example.sessionEx.vo.IpBanVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.net.InetAddress;
import java.util.List;

@RequiredArgsConstructor
public class MainInterceptor implements HandlerInterceptor {

    private final MainService mainService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        InetAddress ia = InetAddress.getLocalHost();

        boolean a = mainService.getIpBanList()
                .stream()
                .anyMatch(ip -> ip.getIp().equals(ia.getHostAddress()));

        if(a == true){
            response.sendRedirect(request.getContextPath()+"/error");
            return false;
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

}

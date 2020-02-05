package com.valensmarcos.filters;

import com.valensmarcos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

public class LoggerInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HttpSession session = request.getSession();
        Duration duration;
        String validate = (String) request.getSession().getAttribute("validate");
        LocalDateTime lastActivity = (LocalDateTime) session.getAttribute("lastActivity");
        LocalDateTime now = LocalDateTime.now();
        if (lastActivity != null) {
            duration = Duration.between(now, lastActivity);
            long diff = Math.abs(duration.toMinutes());
            if (diff>5){
                session.invalidate();
                try {
                    response.sendRedirect("login");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else session.setAttribute("lastActivity", lastActivity);
        } else {
            try {
                response.sendRedirect("login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return validate != null && validate.equals("YES");
    K
}

package com.valensmarcos.controller;

import com.valensmarcos.model.User;
import com.valensmarcos.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@Transactional
public class LoginController {

    @Autowired
    UserQueryService userService;

    @GetMapping("/login")
    public String login(Model model) {

        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession, Model model) {

        httpSession.invalidate();
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "login";
    }

    @PostMapping("/login")
    public RedirectView login(HttpSession httpSession,
                              @RequestParam("userName") String userName,
                              @RequestParam("password") String password) {

        User user = userService.validation(userName, password);
        if (user != null) {
            httpSession.setAttribute("validate", "YES");
            httpSession.setAttribute("userName", user.getUserName());
            httpSession.setAttribute("userId", user.getId());
            httpSession.setAttribute("lastActivity", LocalDateTime.now());
            return new RedirectView("./planets");
        } else {
            return new RedirectView("./login");
        }
    }
}

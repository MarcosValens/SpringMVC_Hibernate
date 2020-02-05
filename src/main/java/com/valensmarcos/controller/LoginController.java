
package com.valensmarcos.controller;

import com.valensmarcos.model.User;
import com.valensmarcos.service.UserService;
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
    UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession, Model model){
        httpSession.invalidate();
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "login";
    }

    @PostMapping("/login")
    public RedirectView login(HttpSession httpSession, ModelMap model,
                              @RequestParam("userName") String userName,
                              @RequestParam("password") String password
    ) {
        User user = userService.validation(userName,password);
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



/*
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.valensmarcos.model.Login;
import com.valensmarcos.model.User;
import com.valensmarcos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
public class LoginController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new Login());
        return mav;
    }
    @PostMapping(value = "/login")
    public ModelAndView loginProcess(@RequestParam("userName") String userName,
                                     @RequestParam("password") String password, Model model) {
        ModelAndView modelAndView;
        Login login= new Login();
        login.setUsername(userName);
        login.setPassword(password);
        User user = userService.validation(login);
        if (null != user) {
            modelAndView = new ModelAndView("welcome");
            modelAndView.addObject("firstname", user.getUserName());
        } else {
            modelAndView = new ModelAndView("login");
            modelAndView.addObject("message", "Username or Password is wrong!!");
        }
        return modelAndView;
    }
}
*/

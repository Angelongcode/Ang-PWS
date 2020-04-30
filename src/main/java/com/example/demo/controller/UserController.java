package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import org.apache.tomcat.util.net.AprEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@RestController
@Controller
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/user")
    @ResponseBody
    public List<User> getAllUser(){
        List<User> users = userService.getAllUser();
        return userService.getAllUser();
    }

    @PostMapping("/getpassword")
//    @ResponseBody
    public String getPByU(@RequestParam(value = "username" ,required = false ,defaultValue = "null") String username,@RequestParam(value = "password",required = false,defaultValue = "null") String password){
        String upassword = userService.getPByU(username, password);
        if (upassword != null && upassword.equals(password)){
            return "redirect:login/good.html";
        }else{
            return "redirect:login/login.html";
        }
    }

    @PostMapping("/signUp")
    public void addUser(@RequestParam(value = "username",required = false,defaultValue = "null") String username,
                        @RequestParam(value = "password",required = false,defaultValue = "null") String password,
                        @RequestParam(value = "name",required = false,defaultValue = "null") String name, HttpServletResponse response) throws IOException {
        userService.addUser(username,password,name);
        response.sendRedirect("login/login.html");
    }
}

package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }

    public String getPByU(String username,String password){
        return userMapper.getPByU(username,password);
    }

    public void addUser(String username,String password,String name){
        userMapper.addUser(username,password,name);
    }
}

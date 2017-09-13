package com.project.first.controller;

import com.project.first.entity.User;
import com.project.first.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户管理类
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "I want AliceMaHan";
    }
    @RequestMapping("/getOne")
    @ResponseBody
    public User getOne(){
        User user = userMapper.getOne("1");
        return user;
    }
    @RequestMapping("delete")
    @ResponseBody
    public void delete(){
        userMapper.delete("1");
    }
    @RequestMapping("/insert")
    @ResponseBody
    public void insert(){
        User user = new User();
        user.setId("2");
        user.setName("王猛");
        user.setPassword("111");
        userMapper.insert(user);
    }
    @RequestMapping("/update")
    @ResponseBody
    public void update(){
        User user = new User();
        user.setId("2");
        user.setName("王萌");
        user.setPassword("333");
        userMapper.update(user);
    }
    @RequestMapping("/getAll")
    @ResponseBody
    public List getAll(){
        List list = userMapper.getAll();
        return list;
    }
}

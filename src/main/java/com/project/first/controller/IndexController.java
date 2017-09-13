package com.project.first.controller;

import com.project.first.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 心愿展示首页
 */
@Controller
@RequestMapping("index")
public class IndexController {
    @Autowired
    IndexService indexService;
    //心愿列表
    @RequestMapping("/main")
    public String main(Model model){
        List wishList = indexService.getWishList();
        model.addAttribute("wishList",wishList);
        return "index/main";
    }

    //添加心愿
    @RequestMapping("/addWish")
    public String addWish(){
        return "index/addWish";
    }

    //保存心愿
    @RequestMapping("/saveWish")
    public String saveWish(HttpServletRequest request){
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        indexService.saveWish(title,content);
        return "index/main";
    }
}

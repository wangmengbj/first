package com.project.first.controller;

import com.project.first.entity.Wish;
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
    public String main(Model model,HttpServletRequest request){
        String turnType = request.getParameter("turnType");
        String pageNum = request.getParameter("pageNum");
        if(pageNum==null){
            pageNum = "1";
        }
        int pageNumInt = Integer.parseInt(pageNum);
        int pageTotle = indexService.getPageTotle();
        if("previous".equals(turnType)){
            pageNumInt = pageNumInt-1;
            if(pageNumInt<1){
                pageNumInt = pageNumInt+1;
            }
        }else if("next".equals(turnType)){
            pageNumInt = pageNumInt+1;
            if(pageNumInt>pageTotle){
                pageNumInt = pageNumInt-1;
            }
        }
        List wishList = indexService.getWishList(pageNumInt);
        int wishCount = indexService.getCountWishList();

        model.addAttribute("pageNumInt",pageNumInt);
        model.addAttribute("pageTotle",pageTotle);
        model.addAttribute("wishList",wishList);
        model.addAttribute("wishCount",wishCount);
        return "index/main";
    }

    //添加心愿
    @RequestMapping("/addWish")
    public String addWish(HttpServletRequest request,Model model){
        String pageNumInt = request.getParameter("pageNumInt");
        String wishCount = request.getParameter("wishCount");
        model.addAttribute("pageNumInt",pageNumInt);
        model.addAttribute("wishCount",wishCount);
        return "index/addWish";
    }

    //保存心愿
    @RequestMapping("/saveWish")
    public String saveWish(HttpServletRequest request,Model model){
        String pageNum = request.getParameter("pageNumInt");
        String wishCount = request.getParameter("wishCount");
        if(pageNum==null){
            pageNum="1";
        }
        int pageNumInt = Integer.parseInt(pageNum);
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        indexService.saveWish(title,content);
        List wishList = indexService.getWishList(pageNumInt);
        model.addAttribute("wishList",wishList);
        model.addAttribute("pageNumInt",pageNumInt);
        model.addAttribute("wishCount",wishCount);
        return "index/main";
    }

    //心愿详情
    @RequestMapping("/wishInfo")
    public String wishInfo(HttpServletRequest request,Model model){
        String id = request.getParameter("id");
        Wish wish = indexService.getWish(id);
        model.addAttribute("wish",wish);
        return "index/editWish";
    }
}

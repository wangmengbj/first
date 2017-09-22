package com.project.first.service;

import com.project.first.entity.Wish;
import com.project.first.mapper.WishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class IndexService {
    @Autowired
    WishMapper wishMapper;

    public List getWishList(int pageNumInt){
        //int wishCount = wishMapper.countWishList();
        int count = (pageNumInt-1) * 8;
        List list = wishMapper.getAll(count);
        return list;
    }

    public int getCountWishList(){
        int wishCount = wishMapper.countWishList();
        return wishCount;
    }

    public int getPageTotle(){
        int wishCount = wishMapper.countWishList();
        int pageTotle = wishCount%8==0?wishCount/8:wishCount/8+1;
        return pageTotle;
    }

    public void saveWish(String title,String content){
        Wish wish = new Wish();
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        Date createTime = new Date();
        wish.setId(id);
        wish.setTitle(title);
        wish.setContent(content);
        wish.setCreateTime(createTime);
        wishMapper.insert(wish);
    }

    public Wish getWish(String id){
        Wish wish = wishMapper.getOne(id);
        return wish;
    }
}

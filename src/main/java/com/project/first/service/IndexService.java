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

    public List getWishList(){
        List list = wishMapper.getAll();
        return list;
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
}

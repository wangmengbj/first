package com.project.first.mapper;

import com.project.first.entity.Wish;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WishMapper {
    @Select("SELECT * from wish")
    List<Wish> getAll();
    @Select("")
    Wish getOne(String id);
    @Insert("insert into wish (id,title,content,sponsorId,sponsorName,createTime) values(#{id},#{title},#{content},#{sponsorId},#{sponsorName},#{createTime})")
    void insert(Wish wish);
    @Update("")
    void update();
    @Delete("")
    void delete();
}

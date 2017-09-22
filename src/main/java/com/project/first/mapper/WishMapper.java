package com.project.first.mapper;

import com.project.first.entity.Wish;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WishMapper {
    @Select("select * from wish ORDER BY createTime limit #{count},8;")
    List<Wish> getAll(int count);
    @Select("SELECT count(1) from wish")
    int countWishList();
    @Select("select * from wish where id = #{id}")
    Wish getOne(String id);
    @Insert("insert into wish (id,title,content,sponsorId,sponsorName,createTime) values(#{id},#{title},#{content},#{sponsorId},#{sponsorName},#{createTime})")
    void insert(Wish wish);
    @Update("")
    void update();
    @Delete("")
    void delete();
}

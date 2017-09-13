package com.project.first.mapper;

import com.project.first.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> getAll();
    @Select("select * from user where id=#{id}")
    User getOne(String id);
    @Insert("insert into user (id,name,password) VALUES(#{id},#{name},#{password})")
    void insert(User user);
    @Update("update user set name=#{name},password=#{password} where id=#{id}")
    void update(User user);
    @Delete("delete from user where id=#{id}")
    void delete(String id);
}

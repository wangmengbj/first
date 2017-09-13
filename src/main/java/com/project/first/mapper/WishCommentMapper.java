package com.project.first.mapper;

import com.project.first.entity.WishComment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WishCommentMapper {
    @Select("")
    List<WishComment> getAll();
    @Select("")
    WishComment getOne();
    @Insert("")
    void insert();
    @Update("")
    void update();
    @Delete("")
    void delete();
}

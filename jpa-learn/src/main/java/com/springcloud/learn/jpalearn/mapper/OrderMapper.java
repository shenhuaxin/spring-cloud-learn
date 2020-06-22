package com.springcloud.learn.jpalearn.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {




    @Insert("INSERT INTO table_name(date) VALUES(#{date})")
    void insert(UserEntity user);

    @Select("select * from table_name ")
    List<UserEntity> select();

}
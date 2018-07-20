package com.example.springboot2docker.mapper;

import com.example.springboot2docker.entity.AppUserMessageEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 18:09 2018/7/19
 */
public interface AppUserMessageMapper {

//    @Select(value = "select * from appuser_message where id = #{id}")
    AppUserMessageEntity selectByPrimaryKey(String id);

}

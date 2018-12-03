package com.example.springboot2docker.mapper;

import com.example.springboot2docker.entity.AppUserMessageEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 18:09 2018/7/19
 */
public interface AppUserMessageMapper {

    @Select(value = "select * from appuser_message where id = #{id}")
    @Results(
            @Result(column = "message_123", property = "message")
    )
    Map<String, Object> selectByPrimaryKey(String id);

}

package com.example.springboot2docker.dao;

import com.example.springboot2docker.entity.AppUserMessageEntity;

import java.util.List;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 18:09 2018/7/19
 */
public interface AppUserMessageDao {

    List<AppUserMessageEntity> selectByPrimaryKey(String id);


}

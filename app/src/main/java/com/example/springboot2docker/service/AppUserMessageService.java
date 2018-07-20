package com.example.springboot2docker.service;

import com.example.springboot2docker.entity.AppUserMessageEntity;

import java.util.List;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 18:07 2018/7/19
 */
public interface AppUserMessageService {

    List<AppUserMessageEntity> selectByPrimaryKey(String id);

}

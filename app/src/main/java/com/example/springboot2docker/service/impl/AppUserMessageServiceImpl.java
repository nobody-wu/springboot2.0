package com.example.springboot2docker.service.impl;

import com.example.springboot2docker.dao.AppUserMessageDao;
import com.example.springboot2docker.entity.AppUserMessageEntity;
import com.example.springboot2docker.mapper.AppUserMessageMapper;
import com.example.springboot2docker.service.AppUserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 18:08 2018/7/19
 */
@Service
public class AppUserMessageServiceImpl implements AppUserMessageService {

    @Resource
    private AppUserMessageDao appUserMessageDao;

    @Override
    public List<AppUserMessageEntity> selectByPrimaryKey(String id) {
        return appUserMessageDao.selectByPrimaryKey(id);
    }
}

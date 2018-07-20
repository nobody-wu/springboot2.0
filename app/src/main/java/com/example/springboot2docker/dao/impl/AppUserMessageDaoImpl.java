package com.example.springboot2docker.dao.impl;

import com.example.springboot2docker.dao.AppUserMessageDao;
import com.example.springboot2docker.dao.BaseMapper;
import com.example.springboot2docker.entity.AppUserMessageEntity;
import com.example.springboot2docker.mapper.AppUserMessageMapper;
import com.google.common.collect.Maps;
import datasource.DataSource;
import datasource.DynamicSqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 18:11 2018/7/19
 */
@Repository
public class AppUserMessageDaoImpl extends DynamicSqlSessionDaoSupport implements AppUserMessageDao {

    @DataSource
    @Override
    public List<AppUserMessageEntity> selectByPrimaryKey(String id) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("id", id);
        return getSqlSession().selectList(getStatement("selectByPrimaryKey"),params);
    }

    private String getStatement(String sqlId){
        String name = this.getClass().getName();
        StringBuilder sb = new StringBuilder();
        if (sqlId.indexOf(".") != -1) {
            sb.append(name).append(sqlId);
            return sb.toString();
        } else {
            sb.append(name).append(".").append(sqlId);
            return sb.toString();
        }
    }
}

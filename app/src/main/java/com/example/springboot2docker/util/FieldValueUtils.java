package com.example.springboot2docker.util;

import com.alibaba.fastjson.JSONObject;
import com.example.springboot2docker.annotation.RiskKey;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 19:08 2018/9/28
 */
public class FieldValueUtils {

    /**
     * 根据属性名获取属性值
     */
    private static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            return value;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list
     */
    public static List<Column> getColumnInfoByObject(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        List<Column> columnList = new ArrayList<>();
        for (int i = 0; i < fields.length; i++) {
            RiskKey annotation = fields[i].getAnnotation(RiskKey.class);
            if (annotation == null) {
                continue;
            }

            List<String> riskKeys = new ArrayList<>();
            String key = annotation.key();
            String[] keys = annotation.keys();
            if (StringUtils.isNotEmpty(key)) {
                riskKeys.add(key);
            } else {
                riskKeys = Arrays.asList(keys);
            }

            final Object value = getFieldValueByName(fields[i].getName(), o);
            boolean toInteger = annotation.isInteger();
            boolean toString = annotation.isString();

            riskKeys.forEach(riskKey -> {

                if (toInteger) {
                    Integer newValue = 0;
                    if (value != null) {
                        newValue = ((Boolean) value) ? 1 : 0;
                    }
                    columnList.add(new Column(riskKey, newValue));
                } else if (toString) {
                    String newValue = "";
                    if (value != null) {
                        newValue = JSONObject.toJSONString(value);
                    }
                    columnList.add(new Column(riskKey, newValue));
                } else {
                    columnList.add(new Column(riskKey, value));
                }
            });
        }

        return columnList;
    }

    /**
     * 从两层对象获得下面所有的一层对象的column对象o
     *
     * @param o
     * @return
     */
    public static List<Column> getColumnInfoByTwoLevelObject(Object o) {
        List<Column> columnList = new ArrayList<>();
        Field[] fields = o.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String filedType = fields[i].getType().toString();
            Object value = getFieldValueByName(fields[i].getName(), o);
            if (filedType.contains("com.example.springboot2docker.vo")) {
                List<Column> columnInfoByTwoLevelObject = getColumnInfoByObject(value);
                columnList.addAll(columnInfoByTwoLevelObject);
            }
        }

        return columnList;
    }

}

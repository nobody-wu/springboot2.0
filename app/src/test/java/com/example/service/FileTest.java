package com.example.service;

import com.example.service.vo.TestObject;
import com.example.springboot2docker.util.FieldValueUtils;
import com.example.springboot2docker.vo.VariableContact;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 19:12 2018/9/28
 */
@SpringBootTest
public class FileTest {

    @Test
    public void test(){
        VariableContact variableContact = new VariableContact();
        variableContact.setIsApprove(1);
        TestObject testObject = new TestObject();
        testObject.setVariableContact(variableContact);
        FieldValueUtils.getColumnInfoByTwoLevelObject(testObject);
    }
}

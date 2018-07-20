package com.example.service;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 17:05 2018/7/16
 */
@SpringBootTest
public class StringTest {

    @Test
    public void test(){
        System.out.println(new Stu(1L));
        System.out.println(new Teacher(2L));
    }

}

class Teacher{
    private Long id;

    public Teacher(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

class Stu{
    private Long id;

    public Stu(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "id=" + id +
                '}';
    }
}

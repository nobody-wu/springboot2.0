package com.example.jdk8;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 18:11 2018/8/30
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> integerList = Lists.newArrayList();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        System.out.println(integerList.stream().parallel().reduce(0, (a, b) -> a + b));


    }

}

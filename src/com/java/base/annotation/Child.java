package com.java.base.annotation;

/**
 * @ClassName Child
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/8/19 15:38
 * @Version 1.0
 **/
// @Description("This is class annotation")
public class Child extends Person {
    // @Description("This is method annotation")
    // @Description
    @Override
    public String name() {
        return null;
    }

    @Override
    public void swimming() {
        System.out.println("Child must't swimming in river!");
    }

    @Override
    public int age() {
        return 0;
    }
}

package com.java.base.annotation;

/**
 * @ClassName Person
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/8/19 15:37
 * @Version 1.0
 **/
@Description("I am interface")
public class Person {
    @Description("I am interface method")
    String name(){
        return null;
    }
    @Deprecated
    void swimming(){

    }
    int age(){
        return 18;
    }
}

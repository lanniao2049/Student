package com.java.base.net;

/**
 * @ClassName ProxyDemo
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/7/11 20:14
 * @Version 1.0
 **/
public class ProxyDemo {
    public static void main(String[] args) {
        SubObject object = new ProxyObject();
        object.request();
    }
}

/**
 * @Author liJialiang
 * @Description //TODO abstract
 * @Date 2019/7/11 20:22 
 * @Param
 * @return
 **/
abstract class SubObject {
    abstract void request();
}

class RealObject extends SubObject{

    @Override
    void request() {
        System.out.println("This is static proxy method");
    }
}

class ProxyObject extends SubObject {
    private RealObject realObject;
    @Override
    void request() {
        before();
        if (null == realObject) {
            realObject = new RealObject();
        }
        realObject.request();
        after();
    }
    public void before() {
        System.out.println("Before ……");
    }

    public void after() {
        System.out.println("……will end!");
    }
}
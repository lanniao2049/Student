package com.java.base.net;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName ProxyDynamicDemon
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/7/11 20:30
 * @Version 1.0
 **/
public class ProxyDynamicDemon {

    public static void main(String[] args) {
        // create realObject
        RealSubject rs = new RealSubject();
        DynamicObject ds = new DynamicObject(rs);
        Class cl = rs.getClass();
        Subject so = (Subject) Proxy.newProxyInstance(cl.getClassLoader(),cl.getInterfaces(),ds);
        so.request();
        so.toSing();
    }

}

interface Subject {
    void request();
    void toSing();
}

class RealSubject implements Subject{
    public void request(){
        System.out.println("This is RealSubject class");
    }

    @Override
    public void toSing() {
        System.out.println("Start toSinging!!!!!!!");
    }
}



class DynamicObject implements InvocationHandler {
    public Object object;

    public DynamicObject() {
    }

    public DynamicObject(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("call method before!");
        method.invoke(object,args);
        System.out.println("call method after!");
        return null;
    }
}

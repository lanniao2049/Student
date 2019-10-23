package com.java.base.net;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectDemo
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/7/11 19:13
 * @Version 1.0
 **/
public class ReflectDemo {

    public void add(Integer a,Integer b) {
        System.out.println(a.intValue()+b.intValue());
    }

    public void addStr(String str) {
        System.out.println("out "+str);
    }



    public static void main(String[] args) {
        // Class c1 = null;
        // Object object;
        // try {
        //     c1 = Class.forName("com.java.base.net.AirPlane");
        //     System.out.println(c1);
        //     object = c1.newInstance();
        //     System.out.println(object.toString());
        // } catch (ClassNotFoundException e) {
        //     e.printStackTrace();
        // } catch (IllegalAccessException e) {
        //     e.printStackTrace();
        // } catch (InstantiationException e) {
        //     e.printStackTrace();
        // }

        try {
            Method mt1 = ReflectDemo.class.getMethod("add", Integer.class, Integer.class);
            mt1.invoke(ReflectDemo.class.newInstance(),new Integer(2),new Integer(5));
            Method mt2 = ReflectDemo.class.getMethod("addStr", String.class);
            mt2.invoke(ReflectDemo.class.newInstance(),"well come");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}

class AirPlane {
    @Override
    public String toString() {
        return "This is AirPlane.";
    }
}



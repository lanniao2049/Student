package com.java.base.reflect;

import java.lang.reflect.Method;

/**
 * @ClassName DemoT2
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/8/14 10:52
 * @Version 1.0
 **/
public class DemoT2 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class c1 = null;
        try {
            c1 = Class.forName("com.java.base.reflect.Bus");
            System.out.println(c1.getName());
            Method[] methods = c1.getMethods();
            c1.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("methodName:"+method.getName());
                System.out.print(method.getReturnType().getName()+"(");
                Class[] params = method.getParameterTypes();
                for (Class param : params) {
                    System.out.println(param.getName()+",");
                }
                System.out.println(")");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
       Car car = (Car) c1.newInstance();
        car.run();
    }

}
interface Car{
    void run();
}
class Bus implements Car{
    @Override
    public void run() {
        System.out.println("Bus is running");
    }
}
class Bike implements Car{
    @Override
    public void run() {
        System.out.println("Bike is running");
    }
}
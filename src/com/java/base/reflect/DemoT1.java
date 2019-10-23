package com.java.base.reflect;

/**
 * @ClassName DemoT1
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/8/14 10:31
 * @Version 1.0
 **/
public class DemoT1 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        F f1 = new F();
        Class c1 = F.class;
        Class c2 = f1.getClass();
        Class c3 = null;
        try {
            c3 = Class.forName("com.java.base.reflect.F");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c3.getName());
        System.out.println(c3.getSimpleName());
        System.out.println(c3.getTypeName());
        F temp = (F) c3.newInstance();
        System.out.println(temp.f);
        temp.save();
    }
}
class F{
    public String f = "This is test.";
    public void save(){
        System.out.println("Save……");
    }
}

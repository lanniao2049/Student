package com.java.base.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName DemoT3
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/8/14 11:20
 * @Version 1.0
 **/
public class DemoT3 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        // Class c1 = int.class;
        // Class c2 = String.class;
        // Class c3 = double.class;
        // Class c4 = Double.class;
        // Class c5 = void.class;
        // System.out.println(c2.getName());
        // System.out.println(c4.getSimpleName());
        // System.out.println(c5.getName());
        String t = "hello";
        int age = 32;
        // printClassMessage(t);
        // printFiledMessage(age);
        // printConstructorMessage(new Integer(12));
        Center center = new Center();
        printMethodMessage(center);
    }

    public static void printClassMessage(Object object){
        Class c = object.getClass();
        System.out.println("类的名称："+c.getName());
        // 获取的是全部public方法，包括父类的方法
        Method[] methods = c.getMethods();
        // 获取的是所有自定义的方法
        // c.getDeclaredMethods();
        for (int i = 0; i < methods.length ; i++) {
            Class returnType = methods[i].getReturnType();
            System.out.print(returnType.getName()+" ");
            // 得到方法名称
            System.out.print(methods[i].getName()+"(");
            // 获取参数类型
            Class[] parameterS= methods[i].getParameterTypes();
            for (Class parameter : parameterS) {
                System.out.print(parameter.getName()+",");
            }
            System.out.println(")");
        }
    }

    public static void  printFiledMessage(Object object){
        Class c = object.getClass();
        // 获取所有的public的成员变量信息
        c.getFields();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            // get field Type class
            Class filedClassName = field.getType();
            String typeName = filedClassName.getName();
            System.out.println(typeName+","+field.getName());
        }
    }

    public static void printConstructorMessage(Object object){
        Class c = object.getClass();
        Constructor[] constructors =c.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.print(constructor.getName()+"(");
            Class[] parameters = constructor.getParameterTypes();
            for (Class parameter : parameters) {
                System.out.print(parameter.getName()+",");
            }
            System.out.println(")");
        }
    }

    public static void printMethodMessage(Object object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class c = object.getClass();
        // 无参数不需要填写
        Method swimming = c.getMethod("swimming");
        System.out.println(swimming.invoke(object));
        Method income = c.getMethod("getIncome",int.class,int.class);
        System.out.println(income.invoke(object,15000,6500));
        Method love = c.getMethod("loveMessage",new Class[]{String.class,int.class});
        System.out.println(love.invoke(object,new Object[]{"I realy love you feifei ",100}));
    }


}

class Center{
    public void swimming(){
        System.out.println("Everyone should swimming!");
    }

    public int getIncome(int salary,int increase){
        int income = salary + increase;
        System.out.println("Your's salary: "+income);
        return income;
    }

    public String loveMessage(String message,int year){
        final String information = message+year+" years,love you forever!";
        return information;
    }
}

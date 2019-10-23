package com.java.base.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @ClassName DemoT4
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/8/16 16:10
 * @Version 1.0
 **/
public class DemoT4 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList list = new ArrayList();
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("hello");
        // add int fail
        // list1.add(20);
        Class c1 = list.getClass();
        Class c2 = list1.getClass();
        System.out.println("判断是否相等？"+(c1==c2));
        // 泛型，只是编译阶段为了规范，在运行阶段已经擦除了
        Method method = c2.getMethod("add",new Class[]{Object.class});
        method.invoke(list1,20);
        System.out.println(list1.size());
        System.out.println(list1);

    }
}

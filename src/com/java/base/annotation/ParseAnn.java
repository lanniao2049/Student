package com.java.base.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @ClassName ParseAnn
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/8/19 18:55
 * @Version 1.0
 **/
public class ParseAnn {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("com.java.base.annotation.Child");
            boolean isExist = c.isAnnotationPresent(Description.class);
            if (isExist){
               Description description = (Description) c.getAnnotation(Description.class);
                System.out.println(description.value());
            }
            // get method annotation
            Method[] methods = c.getMethods();
            for (Method method : methods) {
                boolean isMethodExist = method.isAnnotationPresent(Description.class);
                if (isMethodExist){
                    Description description = method.getAnnotation(Description.class);
                    System.out.println(description.value());
                }
            }
            // another get method annotation
            for (Method method : methods) {
                Annotation[] annotations = method.getAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation instanceof Description){
                        Description description = (Description) annotation;
                        System.out.println(description.value());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

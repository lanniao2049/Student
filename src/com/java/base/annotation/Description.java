package com.java.base.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
    // String desc();
    // String author();
    // int age() default 18;
    // 只有一个参数注解是只能使用value()
    String value();
}

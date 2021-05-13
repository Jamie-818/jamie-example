package com.spring.example.aop.anno;

import java.lang.annotation.*;

/**
 * 自定义注解
 * @author jamie
 */
// 声明注解的保留期限
@Retention(RetentionPolicy.RUNTIME)
// 声明可以使用该注解的目标类型
@Target(ElementType.METHOD)
@Documented
public @interface AnnotationTest {

    /**
     * 声明注解成员
     * @return boolean
     */
    boolean value() default false;

}

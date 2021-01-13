package com.sunny.spring.boot.collection.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/** 一级
 * <Description> <br>
 *
 * @author Sunny<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2019/08/11 22:02 <br>
 * @see com.sunny.spring.boot.collection.annotation <br>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@FirstLevelRepository
public @interface SecondLevelRepository {
    String value() default "";
}

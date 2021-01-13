package com.sunny.spring.boot.collection.repository;

import com.sunny.spring.boot.collection.annotation.FirstLevelRepository;
import com.sunny.spring.boot.collection.annotation.SecondLevelRepository;

/**
 * <Description> <br>
 *
 * @author Sunny<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2019/08/11 22:06 <br>
 * @see com.sunny.spring.boot.collection.repository <br>
 */
//@Component(value = "myFirstLevelRepository")
@SecondLevelRepository(value = "mySecondLevelRepository")
public class MySecondLevelRepository {
}

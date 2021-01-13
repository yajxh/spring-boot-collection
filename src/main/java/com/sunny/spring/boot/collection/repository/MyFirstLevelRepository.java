package com.sunny.spring.boot.collection.repository;

import com.sunny.spring.boot.collection.annotation.FirstLevelRepository;
import org.springframework.stereotype.Component;

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
@FirstLevelRepository(value = "myFirstLevelRepository")
public class MyFirstLevelRepository {
}

package com.sunny.spring.boot.collection.bootstrap;

import com.sunny.spring.boot.collection.repository.MyFirstLevelRepository;
import com.sunny.spring.boot.collection.repository.MySecondLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * <Description> <br>
 *
 * @author Sunny<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2019/08/11 22:07 <br>
 * @see com.sunny.spring.boot.collection.bootstrap <br>
 */
@ComponentScan(basePackages = "com.sunny.spring.boot.collection.repository")
public class RepositoryBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        MyFirstLevelRepository myFirstLevelRepository = context.getBean("myFirstLevelRepository", MyFirstLevelRepository.class);
        System.out.println("myFirstLevelRepository is " + myFirstLevelRepository);

        MySecondLevelRepository mySecondLevelRepository = context.getBean("mySecondLevelRepository", MySecondLevelRepository.class);
        System.out.println("mySecondLevelRepository is " + mySecondLevelRepository);
        context.close();
    }
}

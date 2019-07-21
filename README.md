# spring-boot-collection

## Spring boot三大特性
* 组件自动装配：Web MVC、Web Flux、JDBC等
* 嵌入式Web容器：Tomcat、Jetty以及Undertow
* 生产准备特性：指标、健康检查、外部化配置等

### WEB应用
#### 传统Servlet应用
**依赖**
```
<dependency>
  <groupId>org.springframework.boot</groupId>   
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
**Servlet组件**
* Servlet 
   * 实现
        * @WebServlet
        * HttpServlet
        * 注册
   * URL映射
        * @WebServlet(urlPatterns = "/my/servlet")
   * 注册
        * @ServletComponentScan(basePackages = "com.sunny.spring.boot.collection.web.servlet")
* Filter
* Listener

**Servlet注册**

***Servlet注解***
* @ServletComponentScan
    * @WebServlet
    * @WebFilter
    * @WebListener
    
***SpringBean***
* @Bean
    * Servlet
    * Filter
    * Listener
    
***RegistrationBean***
* ServletRegistrationBean
* FilterRegistrationBean
* ServletListenerRegistrationBean

**异步非阻塞**
***异步Servlet***
    * javax.servlet.ServletRequest#startAsync
    * javax.servlet.AsyncContext

***非阻塞Servlet***
    * javax.servlet.ServletInputStream#setReadListener
        * javax.servlet.ReadListener
    * javax.servlet.ServletOutputStream#setWriteListener
            * javax.servlet.WriteListener
            
            
       
###Sping Web MVC应用
    * Web MVC视图：模板引擎、内容协商、异常处理等
    * Web MVC Rest：资源服务、资源跨域、服务发现等
    * Web MVC 核心：核心架构、处理流程、核心组件
#### Web MVC视图
    * ViewResolver
    * View
##### 模板引擎
    * Thymeleaf
    * Freemarker
    * JSP
##### 内容协商
    * ContentNegotiationConfigurer
    * ContentNegotiationStrategy
    * ContentNegotiatingViewResolver
    
##### 异常处理
    * @ExceptionHandler
    * HandlerExceptionResolver
        * ExceptionHandlerExceptionResolver
    * BasicErrorController(Spring Boot)
    
#### Web MVC Rest
##### 资源服务
* @RequestMapping
    * GetMapping
* @ResponseBody
* @RequestBody

##### 资源跨域
* CrossOrigin
* WebMvcConfigure#addCorsMappings
* 解决方案
    * IFrame
    * JSONP
    
##### 服务发现
* HATEOS

#### Web MVC核心
##### 核心架构


##### 处理流程


##### 核心组件
* DispatcherServlet
* HandlerMapping
* HandlerAdapter
* ViewResolver


###Sping Web Flux 应用
####Reactor基础
* Java Lambda
* Mono
* Flux

####Web Flux核心
#####Web MVC注解兼容
* @Controller
* @RequestMapping
* @ResponseBody
* @RequestBody
* ...

#####函数式声明
* RouterFunction

#####异步非阻塞
* Servlet3.1+
* Netty Reactor

#####使用场景
页面渲染

REST应用

性能测试
https://blog.ippon.tech/spring-5-webflux-performance-tests/

###Web Server应用
####切换Web Server
#####切换其他Servlet容器
* Tomcat -> Jetty
```$xslt
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <!--Use Jetty instead-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web-jetty</artifactId>
        </dependency>
```
#####替换Servlet容器
*WebFlux
```$xslt
<!--<dependency>-->
            <!--<groupId>org.springframework.boot</groupId>-->
            <!--<artifactId>spring-boot-starter-web</artifactId>-->
            <!--<exclusions>-->
                <!--<exclusion>-->
                    <!--<groupId>org.springframework.boot</groupId>-->
                    <!--<artifactId>spring-boot-starter-tomcat</artifactId>-->
                <!--</exclusion>-->
            <!--</exclusions>-->
        <!--</dependency>-->
        <!--<dependency>-->
            <!--<groupId>org.springframework.boot</groupId>-->
            <!--<artifactId>spring-boot-starter-web-jetty</artifactId>-->
        <!--</dependency>-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webflux</artifactId>
        </dependency>
```

#####自定义Servlet Web Server
* WebServerFactoryCustomizer

#####自定义Reactive Web Server
* ReactiveWebServerFactoryCustomizer

###数据相关
####关系型数据
#####JDBC
***依赖***
```$xslt
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
```
***数据源***
* javax.sql.DataSource
***JdbcTemplate***
***自动装配***
* DataSourceAutoConfiguration

#####JPA
***依赖***
```$xslt
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
```
***实体映射关系***
* @javax.persistence.OneToOne
* @javax.persistence.OneToMany
* @javax.persistence.ManyToOne
* @javax.persistence.ManyToMany

***实体操作***
* @javax.persistence.EntityManager

***自动装配***
* HibernateJpaAutoConfiguration

#####事物(Transaction)
***依赖***
```$xslt
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
        </dependency>
```
***Spring事物抽象***
* PlatformTransactionManager

***JDBC事物处理***
* DataSourceTransactionManager

***自动装配***
* TransactionAutoConfiguration

###功能扩展
####Spring Boot应用
#####SpringApplication
######失败分析
* FailureAnalysisReporter
######应用特性
* SpringApplication  Fluent API
#####Spring Boot配置
* 外部化配置
    * ConfigurationProperty
* @Profile
* 配置属性
    * PropertySources
    
#####Spring Boot Starter


###运维管理
####Spring Boot Actuator
#####依赖
```$xslt
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
```
#####端点(Endpoints)
######Web Endpoints

######JMX Endpoints

#####健康检查(Health Checks)
######Health

######HealthIndicator

#####指标(Metrics)
######内建Metrics
* Web Endpoint:/actuator/metrics
######自定义Metrics
######HealthIndicator

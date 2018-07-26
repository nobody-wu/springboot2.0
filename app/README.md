# springboot2.0

1. springboot2.0-docker
2. springboot2.0-spring.data.redis:实现消息队列-发布／订阅模式
    
    ```
        为了更方便的使用,demo简化了jedis连接池的配置、缓存管理和生成key的配置
    ```
3. 添加几种常用的原生http post请求方式:HttpClientHelper

    ```
        1. HttpURLConnection
        2. URLConnection
        3. HttpURLConnection
        4. HttpClient
        5. socket
    ```
      
4. 自定义注解(@FeizhuSubmit)传递参数

5. 添加Docker-Tool API

6. 使用yml配置文件，添加log4j日志配置

    ```
        使用yml要非常小心，排序空格一定要对齐
    ```

7. 添加vesta发号器（嵌入发布模式）
    - 如果你有多台机器，递增机器ID，同一服务中机器ID不能重复。 
    -  这里，生成方式genMethod为0表示使用嵌入发布模式 
    - type为0, 表示最大峰值型，如果想要使用最小粒度型，则设置为1

8. spring aop

    - 使用aop:aspect(大多用于日志，缓存)

    ```
        <aop:config>
            <aop:pointcut expression="execution(* *.sleep(..))" id="sleepPointcut"/>
            <aop:aspect ref="sleepHelperAspect">
                <!--前置通知-->
                <aop:before method="beforeSleep" pointcut-ref="sleepPointcut"/>
                <!--后置通知-->
                <aop:after method="afterSleep" pointcut-ref="sleepPointcut"/>
            </aop:aspect>
        </aop:config>
    ```

    - 使用aop:advisor(大多用于事务管理)

    ```
        <aop:config>
            <aop:pointcut expression="execution(* *.sleep(..))" id="sleepPointcut"/>
            <aop:advisor advice-ref="sleepHelper" pointcut-ref="sleepPointcut"/>
        </aop:config>
    ```

    - @Aspect注解


--- 

## 版本记录

### v1.0.1

2018-07-20:

- springboot集成mybatis

- 添加动态数据源解决方案[dynamic.datasource](https://github.com/sunnyWu1104/dynamic-dataresource)（对外提供的版本）

2018-07-23:

- springboot下@Value属性注入简单使用(PropertiesTest)

    ```
    1. 使用PlaceHolder方式，格式:${}
    2. 使用SqEL(spring expression language)表达式，格式:#{}
    ```
- [spring schema自定义扩展](https://veryjj.github.io/2018/04/22/Dubbo%E6%BA%90%E7%A0%81%E8%A7%A3%E6%9E%90-Spring-Bean%E6%B3%A8%E5%86%8C/)
    
    ```
    Spring 2.5在2.0的基于Schema的Bean配置的基础之上，再增加了扩展XML配置的机制。通过该机制，我们可以编写自己的Schema，并根据自定义的Schema用自定的标签配置Bean。要使用的Spring的扩展XML配置机制，也比较简单，有以下4个步骤：
    
    1. 编写自定义Schema文件；
    2. 编写自定义NamespaceHandler；
    3. 编写解析BeanDefinition的parser
    4. 在Spring中注册上述组建
    
    参考：http://www.w3school.com.cn/schema/schema_elements_ref.asp 
    ```
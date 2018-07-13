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

- 使用aop:aspect

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

- 使用aop:advisor

```
    <aop:config>
        <aop:pointcut expression="execution(* *.sleep(..))" id="sleepPointcut"/>
        <aop:advisor advice-ref="sleepHelper" pointcut-ref="sleepPointcut"/>
    </aop:config>
```

- @Aspect注解

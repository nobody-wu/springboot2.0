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

6. 使用[yml配置文件](https://blog.csdn.net/u010598111/article/details/80556437)，添加log4j日志配置

```
使用yml要非常小心，排序空格一定要对齐
```

7. 添加vesta发号器[（嵌入发布模式）](https://github.com/cloudatee/vesta-id-generator/blob/master/vesta-doc/%E7%BB%9F%E4%B8%80%E5%8F%91%E5%8F%B7%E5%99%A8(Vesta)%20-%20%E4%BD%BF%E7%94%A8%E5%90%91%E5%AF%BC%20-%20%E5%B5%8C%E5%85%A5%E5%8F%91%E5%B8%83%E6%A8%A1%E5%BC%8F.md)[简书地址](https://www.jianshu.com/p/44fd44b4cd05)
- 如果你有多台机器，递增机器ID，同一服务中机器ID不能重复。 
-  这里，生成方式genMethod为0表示使用嵌入发布模式 
- type为0, 表示最大峰值型，如果想要使用最小粒度型，则设置为1

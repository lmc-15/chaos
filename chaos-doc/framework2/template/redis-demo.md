# Redis使用说明

> [源码](http://gitlab.cecdat.com/framework/backend/rock/tree/develop/examples/redis-demo)



## 快速开始

1、 导入maven依赖

``` xml
    <dependency>
      <groupId>com.cecdat</groupId>
      <artifactId>redis</artifactId>
    </dependency>

```

2、 配置yml文件

配置demo，其中prefix为框架自定义变量，其余为spring标准提供（单机、哨兵、集群三种工作模式互斥，即只能配置一种）。

- prefix： 当前redis环境为公共资源，因而强制每个项目配置前缀，划分到不同域进行项目间隔离

<!-- tabs:start -->

#### ** 单机（Standalone） **

``` properties
spring:
  redis:
# 单机
    host: 192.168.1.70
    port: 6379
    database: 5
    timeout: 5000
    password:
    # 框架额外封装的字段，用于指定工作前缀域,隔离各个项目
    prefix: template
    lettuce:
      pool:
        max-active: 2000
        max-idle: 100
        max-wait: -1
        min-idle: 5
```

#### ** 哨兵（Sentinel） **

``` properties
spring:
  redis:
    timeout: 5000
    password:
    # 框架额外封装的字段，用于指定工作前缀域,隔离各个项目
    prefix: template
    lettuce:
      pool:
        max-active: 2000
        max-idle: 100
        max-wait: -1
        min-idle: 5
# 哨兵
    sentinel:
      master: nodemase
      nodes: redis01.cecdat:7005,redis01.cecdat:7004

```

#### ** 集群（Cluster） **

``` properties
spring:
  redis:
    timeout: 5000
    password:
    # 框架额外封装的字段，用于指定工作前缀域,隔离各个项目
    prefix: template
    lettuce:
      pool:
        max-active: 2000
        max-idle: 100
        max-wait: -1
        min-idle: 5
      cluster:
        refresh:
          # 是否开启自适应拓扑刷新
          adaptive: true
          #  开启定时刷新，单位：毫秒
          period: 30000
# 集群
    cluster:
      nodes: redis01.cecdat:7005,redis01.cecdat:7004,redis02.cecdat:7003,redis02.cecdat:7002,redis03.cecdat:7001,redis03.cecdat:7000
  
```

<!-- tabs:end -->


3、代码使用

```java
    @Autowired
    RedisUtils redisUtils;
```

设置对象

``` java
redisUtils.set(key, val)
```

读取对象

```java
redisUtils.get(key)
```

删除对象

``` java
redisUtils.remove(key)
redisUtils.unlink(key)
```

remove和unlink都能删除对象，但在大对象删除是remove同步删除会阻塞，而unlink是标记后异步清理不会阻塞，大对象删除推荐使用unlink。



**本页编辑**      **[@dengrijin](http://192.168.1.23/dengrijin)**  [@gongshiwen](http://192.168.1.23/gongshiwen) <img src="http://192.168.1.23/uploads/-/system/user/avatar/10/avatar.png?width=100" style="zoom:10%;" />
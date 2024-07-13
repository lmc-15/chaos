# Gateway使用说明

## 快速开始

1、 导入maven依赖

```xml
        <dependency>
            <groupId>com.cecdat</groupId>
            <artifactId>gateway</artifactId>
        </dependency>
```

2、 配置yml文件

```yaml
server:
  port: 10013
spring:
  application:
    name: api-gateway-demo
  profiles:
    active: ${PLATFORM_TYPE:local}
  cloud:
    nacos:
      server-addr: ${CONFIG_URL:172.16.57.31:28848}
      #部署时使用启动参数注入
      username: nacos
      password: nacos
      config:
        namespace: ${spring.profiles.active}
        group: DEFAULT_GROUP
      discovery:
        namespace: ${spring.profiles.active}
        group: DEFAULT_GROUP


```



3、配置路由application.yml

```yaml
spring:
  cloud:
    gateway:
      routes:
        #普通路由设置，id唯一
        - id: normal
          uri: lb://cloud-demo-provider
          predicates:
            - Path=/theText/**
```



## IP黑白名单拦截

``` yaml
spring:
  cloud:
    gateway:
      routes:
        #黑名单设置
        - id: black
          uri: lb://cloud-demo-provider
          predicates:
            - BlackRemoteAddr=127.0.0.1
            - Path=/username/**
        #单独配置黑名单时，删除以下白名单内容
        #同时配置黑名单和白名单，白名单生效
        - id: white
          uri: lb://cloud-demo-provider
          predicates:
            - WhiteRemoteAddr=127.0.0.1
            - Path=/username/**
```

## 动态路由功能

>  该功能允许通过nacos的配置，在不重启网关的前提下进行路由的配置。默认未开启

1. 配置开启开关

   ``` yaml
    动态路由相关配置
   rock:
     gateway:
       dynamic-route:
         enable: true # 是否开启开关，默认为false。
         config-id: rock-route.json # 路由的配置文件，默认为rock-route.json
   ```

2. nacos上创建id为rock-route.json配置文件

```json
[
    {
        "id": "normal",
        "order": 0,
        "predicates": [
            {
                "args": {
                    "pattern": "/theText/**"
                },
                "name": "Path"
            }
        ],
        "uri": "lb://cloud-demo-provider"
    },
    {
        "id": "white",
        "order": 0,
        "predicates": [
            {
                "args": {
                    "pattern": "/username/**"
                },
                "name": "Path"
            },
             {
                "args": {
                    "pattern": "127.0.0.1"
                },
                "name": "BlackRemoteAddr"
            }
        ],
        "uri": "lb://cloud-demo-provider"
    }
]
```

3. 需要变更路由时，仅修改nacos上的配置，保存后立刻生效。
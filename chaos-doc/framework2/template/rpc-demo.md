# RPC使用说明

> [源码](http://gitlab.cecdat.com/framework/backend/rock/tree/develop/examples/rpc)



## 1 、dubbo方案（使用nacos作为注册中心）

## 1.1 生产者
1、 maven 导入

``` xml
       <dependency>
            <groupId>org.apache.dubbo</groupId>
            <artifactId>dubbo-spring-boot-starter</artifactId>
            <version>${dubbo.version}</version>
        </dependency>

        <!-- Dubbo -->
        <dependency>
            <groupId>org.apache.dubbo</groupId>
            <artifactId>dubbo</artifactId>
            <version>${dubbo.version}</version>
        </dependency>

        <!-- Dubbo Registry Nacos -->
        <dependency>
            <groupId>org.apache.dubbo</groupId>
            <artifactId>dubbo-registry-nacos</artifactId>
            <version>${dubbo.version}</version>
        </dependency>

        <dependency>
            <groupId>com.alibaba.nacos</groupId>
            <artifactId>nacos-client</artifactId>
        </dependency>
```

2、配置文件

``` properties
spring.application.name=nacos-dubbo-provider
server.port=8811
dubbo.scan.base-packages=com.cecdat.service # 扫描注解的包名
dubbo.protocol.name=dubbo
dubbo.protocol.port=-1
dubbo.registry.address=nacos://192.168.1.51:8848 #服务注册中心地址
```

3、代码使用

使用注解@DubboService标记需要注册的服务

``` java
@DubboService
public class HelloServiceImpl implements HelloService{
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
```

## 1.2 消费者

1、 maven 导入

``` xml
       <dependency>
            <groupId>org.apache.dubbo</groupId>
            <artifactId>dubbo-spring-boot-starter</artifactId>
            <version>${dubbo.version}</version>
        </dependency>

        <!-- Dubbo -->
        <dependency>
            <groupId>org.apache.dubbo</groupId>
            <artifactId>dubbo</artifactId>
            <version>${dubbo.version}</version>
        </dependency>

        <!-- Dubbo Registry Nacos -->
        <dependency>
            <groupId>org.apache.dubbo</groupId>
            <artifactId>dubbo-registry-nacos</artifactId>
            <version>${dubbo.version}</version>
        </dependency>

        <dependency>
            <groupId>com.alibaba.nacos</groupId>
            <artifactId>nacos-client</artifactId>
        </dependency>
```

2、配置文件

``` properties
spring.application.name=nacos-dubbo-consumer
dubbo.registry.address=nacos://192.168.1.51:8848 # 注册中心地址
```

3、代码使用

使用注解@DubboReference使用服务

``` java
@Component
public class HelloDemo {

    @DubboReference
    private HelloService helloService;

    public String hello(String name) {
        return helloService.sayHello(name));
    }
}
```

# 2 、spring cloud fegin方案（使用nacos）

## 1.1 生产者

1、 maven 导入

``` xml
      <dependencies>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
    </dependencies>
```

2、配置文件

``` properties
spring.cloud.nacos.discovery.server-addr=192.168.1.51:8848 # 服务注册中心
```

3、代码使用

与普通的服务无差异

## 1.2 消费者

1、 maven 导入

``` xml
       <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
```

2、配置文件

``` properties
spring.cloud.nacos.discovery.server-addr=192.168.1.51:8848 #服务注册中心
```

3、代码使用

（1） 在主类（即SpingBootApplication注解类）加上以下两个注解

```
@EnableDiscoveryClient
@EnableFeignClients
```

（2）创建一个服务接口，配置FeignClient客户端

``` java
//生产者名称
@FeignClient("provide")
public interface IHelloService {

    //openfeign 访问客户端的请求方式（provide 需要提供"/hello"的GET请求）
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String sayHello(@RequestParam String name);
}
```



**本页编辑**      **[@dengrijin](http://192.168.1.23/demgrijin)**
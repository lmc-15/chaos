# Kafka使用说明

> [源码](http://gitlab.cecdat.com/framework/backend/rock/tree/develop/examples/kafka-demo)



## 快速开始

1、 导入maven依赖

``` xml
    <dependency>
      <groupId>com.cecdat</groupId>
      <artifactId>kafka</artifactId>
    </dependency>

```

2、 配置yml文件

配置demo

``` properties
spring:
  kafka:
  # 启动地址
    bootstrap-servers: node1:6667,node2:6667,node3:6667
    # 消费者配置
    consumer:
      bootstrap-servers: node1:6667,node2:6667,node3:6667
      enable-auto-commit: true
      group-id: applog
      auto-offset-reset: latest
    #生产者配置  
    producer:
      retries: 0
      bootstrap-servers: node1:6667,node2:6667,node3:6667
      batch-size: 4096
      buffer-memory: 100000
```

3、代码使用

（1）生产者

```java
@Autowired
KafkaProducer kafkaProducer;
```

发送消息

``` java
// topic 主题 body 消息体
Boolean res = kafkaProducer.sendMsg(topic, body);
```



（2）消费者

使用注解@KafkaListener订阅

```java
@KafkaListener(topics = "hello")
void getMsg(String msg) {
    log.info("收到消息：{}", msg);
}
```

**本页编辑**      **[@dengrijin](http://192.168.1.23/demgrijin)**
# 分布式锁使用说明

> [源码](http://gitlab.cecdat.com/framework/backend/rock/tree/develop/examples/zk-client-demo)



## 快速开始

1、 导入maven依赖

<!-- tabs:start -->

#### ** 基于redis **

``` yml
   <dependencies>
        <dependency>
            <groupId>com.cecdat</groupId>
            <artifactId>redis</artifactId>
            <version>2.3.5.PRE</version>
        </dependency>
    </dependencies>

```

 

<!-- tabs:end -->







2、 配置yml文件



<!-- tabs:start -->

#### ** 基于redis **

``` yml
   参见redis的使用

```

 

<!-- tabs:end -->



3、代码使用

```java
@Autowired   
DistributedLockService distributeLock;// 同时使用zk和redis时，默认注入zk的实现

// 显示指定锁的实现方式 zk
@Resource(name = LockImplementationType.ZOOKEEPER)
DistributedLockService zkDistributedLockService;
// 显示指定锁的实现方式 redis
@Resource(name = LockImplementationType.REDIS)
DistributedLockService redisDistributedLockService;
```

``` java
    /**
     * 获取锁
     * 允许设置等待获取锁的超时时间
     *
     * @param lockName               锁名称
     * @param acquireTimeoutMs 获取锁超时时间
     * @return Lock
     */
Lock getLock(String lockName, long acquireTimeoutMs)
    /**
     * 获取锁
     *
     * @param lockName       锁名称
     * @return Lock
     */
Lock getLock(String lockName)
    /**
     * 释放锁
     *
     * @param lock 锁公共类
     * @return true/false
     */
boolean unlock(Lock lock);
```

**本页编辑**      *[@yangbingwen](http://192.168.1.23/yangbingwen)


## 更新历史

### [v3.0.0.PRE] 2022.2.24

> 兼容性：不完全兼容2.x之前的版本

- **[FEAT]** 新增：
  
  - 框架名称修改为Rock。
  - 添加openfeign模块，包含了openfeign,sentinel组件  
  - 添加了cloud模块，包含了对nacos等组件，默认集成了openfeign组件。
  - 添加了gateway模块，增加了对黑白名单，动态路由功能。
  - Spring项目增加了actuator观测组件。
  
  

- **[REFACTOR]** 重构：
  - 删除的模块：shiro模块，zk-client模块，ci模块，embedded-pg模块。
  - swagger模块移植至web模块。
  - 数据库由Postgres切换为MySQL。
  - 数据库连接池由Druid切换为Hikari。
  - 移植了Akso的浮点运算等工具类，其他模块后续根据场景进行整合。
  - 合并common模块到component中。



### [v2.3.6.PRE] 2021.7.15

> 兼容性：v2.2.0.RELEASE之后


- **[ refactor]** 新增：
  - [引入配置加密](http://192.168.1.23/cecdat/framework/backend/framework2/merge_requests/169)
  - 移除 uac 模块




### [v2.3.5.PRE] 2021.1.25

> 兼容性：v2.2.0.RELEASE之后
>
> 预览版，适配UAC 2.0 版本。

- **[FIXED]** 修复：

  - [HOTFIX:tryLock 调用错误](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/144)
  - [修复”web 环境依赖问题“](http://gitlab.cecdat.com/framework/backend/rock/commit/9e5efa591b0b76e49ac1cb94dd021c3bea56c3c6)
- **[FEAT]** 新增：
  - [UAC 2.0 model 模块更新](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/141)
  - [使用lua脚本实现redis锁](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/143)
  - [在Strings工具类中增加汉字检查方法](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/152)
  - [单元测试使用 Embedded Postgres](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/158)





### [v2.3.4.RELEASE] 2021.1.22

> 兼容性：v2.2.0.RELEASE之后

- **[FIXED]** 修复：

  - [代码生成模板entity中主键使用TableId注解避免mybatis-plus启动警告](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/132)
  - [自动打tag，tagname异常问题修复](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/136)
- **[PERF]** 优化：
  - [refactor: 分布式锁接口定义和实现优化](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/135)
- **[其它]** ：
  - [API规范补充一个关于字段清空的最佳实践](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/134)



### [v2.3.4.PRE] 2020.12.28

> 兼容性：v2.2.0.RELEASE之后

- **[FIXED]** 修复：
- [修复 profiles.active=dev 时,会激活 framework2 中的dev数据库连接问题](http://gitlab.cecdat.com/framework/backend/rock/issues/22)
  - [修复日期工具类 DateUtil 捕获异常却未做处理问题](http://gitlab.cecdat.com/framework/backend/rock/issues/20)
  - [修复因移除lombok依赖导致的代码块报错](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/110)
- **[FEAT]** 新增：
  - [增加基于 Curator 框架的分布式锁实现](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/114)
  - [增加 zk-cilent 实现 ZK 的基础操作](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/114)
  - [基于 easyexcel 封装 excel 导入/导出](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/117)
- **[其它]** ：
  - [hutool 工具包使用demo](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/106)





### [v2.3.3.RELEASE] 2020.11.27

> 兼容性：v2.2.0.RELEASE之后

- **[FIXED]** 修复：
  - [修复redis 连接异常](http://gitlab.cecdat.com/framework/backend/rock/issues/17)
  - [修复部分demo模块lombok依赖问题](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/110)

- **[优化]** ：
  - [发布时增加代码归档，根据版和编译ID打上tag](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/104)

  



### [v2.3.2.RELEASE] 2020.09.25

> 兼容性：v2.2.0.RELEASE之后

- **[FIXED]** 修复：
  
    - [分页参数调整成long与返回结果保持一致](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/85)
- **[其它]** ：
    - [banner颜色修改](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/86)
    - [PR和Issue Bug 模板](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/83)
    - [docs发布配置](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/89)

    
### [v2.3.1.RELEASE] 2020.09.18

> 兼容性：v2.2.0.RELEASE之后

- **[FIX]** 修复：
  - [mybatis的page问题修复](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/68) 
  - [移除Lombok依赖](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/65)
  - [ConvertConfig使用Lambda表达式bug](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/72)



### [v2.3.0.RELEASE] 2020.09.11

> 兼容性：v2.2.0.RELEASE之后

- **[DOCS]** 文档补充：
  - [新增版本兼容说明](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/50)
- **[FEAT]** 新增：
  - [Pagination提供getOffset方法](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/51) 
  - [重写tree模块，提供工具（通过设置节点间的子父关系），构造无限级的树结构](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/53)



### [v2.2.0.RELEASE] 2020.09.04

> 兼容性：不兼容使用util.tree模块的应用

- **[FIXED]** 修复：
  
  - [修复uac使用shiro时，凭证失效提醒错误](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/40)
- **[FEAT]** 新增：
  - [ShiroConfig 改为yaml配置](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/41) 
- **[REFACTOR]** 调整以下：
   - [移除util.tree模块](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/44)



### [v2.1.1.RELEASE] 2020.08.31

> 兼容性：兼容所有旧版本

- **[FIXED]** 修复：
  - 修复MDC模块，线程与子线程的追踪ID传递问题



### [v2.1.0.RELEASE] 2020.08.21

> 兼容性：兼容所有旧版本

- **[FEAT]** 新增：
  - [UacUtil](http://gitlab.cecdat.com/framework/backend/rock/blob/develop/common/uac-client/src/main/java/com/cecdat/common/authorize/communicate/service/UacUtils.java) 工具，提供了获取当前用户信息，用户菜单/权限等相关信息
  - [更新springboot 主版本到2.3.3.RELEASE，修复一些存在的Bug](https://github.com/spring-projects/spring-boot/releases/tag/v2.3.3.RELEASE)
  



### [v2.0.0.RELEASE] 2020.08.03

> 兼容性：初始版本，无兼容性要求

- **[REFACTOR]** 调整以下：
  - RedisTemplate<String,Object> 序列化调整为 <StringRedisSerializer,GenericJackson2JsonRedisSerializer>
  - [更新springboot 主版本到2.3.2.RELEASE](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/14)
- **[PREF]**优化以下：
  - 分页返回[PageData](http://gitlab.cecdat.com/framework/backend/rock/blob/develop/component/data/src/main/java/com/cecdat/data/model/PageData.java)新增返回limit和page
  - [修改自动填充默认逻辑删除状态字段](http://gitlab.cecdat.com/framework/backend/rock/merge_requests/12)
  



### [v2.0.0.PRE] 2020.07.24

> 兼容性：preview版本，无兼容性要求

- **[REFACTOR]**调整framework：
  - Spring Boot 版本升级到 `2.3.2.RELEASE`
  - 简化框架代码结构，主要分为三大模块：core，common，component
  - 合并示例模块到 examples 
  - 新增文档模块 docs
  - 原common/authorization模块变更到 common/uac-client
  - 原common/authorize-models模块变更到 common/uac-model
- **[PREF]**升级framework1.0，优化以下：
  - 优化[Result](http://gitlab.cecdat.com/framework/backend/rock/blob/develop/core/src/main/java/com/cecdat/core/model/Result.java)统一返回对象，统一分页数据结构；
  - 优化错误返回处理
  - [Druid](https://github.com/alibaba/druid/)从1.1.6升级到1.1.22
  - [mybatis-plus](https://github.com/baomidou/mybatis-plus)从2.1.8升级到3.3.2
  - [redis](http://gitlab.cecdat.com/framework/backend/rock/tree/develop/component/redis/src/main/java/com/cecdat/redis)模块升级支持[redis5.0](https://redis.io/)
  - [kafka](http://gitlab.cecdat.com/framework/backend/rock/tree/develop/component/kafka/src/main/java/com/cecdat/kafka) 模块废弃原有封装，改而采用`Spring KafkaTemplete`。
  - ~~弃用`fastjson`~~,使用`jackson`
- **[FIXED]** 修复：
  - 授权模块[uac-client](http://gitlab.cecdat.com/framework/backend/rock/tree/develop/common/uac-client)适配了新版本网络客户端，并修复了登陆失败时异常httpcode与uac不一致问题。
- **[FEAT]** 新特新：
  - 引入MinIO用于对象存储，新增[OSS](http://gitlab.cecdat.com/framework/backend/rock/tree/develop/component/oss/src/main/java/com/cecdat)模块
  - 引入Nacos用于配置发布，新增[cloud-config](http://gitlab.cecdat.com/framework/backend/rock/tree/develop/component/cloud-config)模块
  - 引入[Knife4j](https://doc.xiaominfo.com/guide/useful.html)美化Swagger-UI
  - 引入Logback MDC，用于应用层调用追踪（traceId）
  - [redis](http://gitlab.cecdat.com/framework/backend/rock/tree/develop/component/redis/src/main/java/com/cecdat/redis)模块新增`spring.redis.prefix`配置，默认值为`cec`，用于隔离各个业务系统缓存使用域



**本页编辑**      **[@gongshiwen](http://192.168.1.23/gongshiwen)** <img src="http://192.168.1.23/uploads/-/system/user/avatar/10/avatar.png?width=100" style="zoom:10%;" />  **[@dengrijin](http://192.168.1.23/demgrijin)**
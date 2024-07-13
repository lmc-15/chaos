# database+mybatis使用说明

> [源码](http://gitlab.cecdat.com/framework/backend/rock/tree/develop/examples/database-demo)



## 快速开始

1、 导入maven依赖

``` xml
    <dependency>
      <groupId>com.cecdat</groupId>
      <artifactId>data</artifactId>
    </dependency>

```

2、 配置yml文件

<!-- tabs:start -->

#### ** 数据库配置 **

``` yaml
spring:
  datasource:
    driverClassName: org.postgresql.Driver
    url: jdbc:postgresql://postgres.cecdat:5432/template?currentSchema=template&useSSL=false&serverTimezone=GMT%2B8&autoReconnect=true
    username: postgres
    password: postgres
    druid:
      initial-size: 3
      min-idle: 3
      max-active: 10
      min-evictable-idle-time-millis: 300000
      keep-alive-between-time-millis: 60000
      max-wait: 60000
      test-while-idle: true
      test-on-borrow: false
      test-on-return: false
      pool-prepared-statements: true
      max-pool-prepared-statement-per-connection-size: 20
      connect-properties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000
      filters: stat,wall
      #可视化监控界面，该部分可以不配置
      stat-view-servlet:
        login-username: admin
        login-password: admin
        reset-enable: false
        url-pattern: /druid/*
        enabled: true
```

#### ** mybatis-plus配置 **

```yaml
  mybatis-plus:
      mapper-locations: classpath*:/mapper/*Dao.xml,classpath:**/*Dao.xml
      #实体扫描，多个package用逗号或者分号分隔
      typeAliasesPackage: com.cecdat.**.entity
      global-config:
        db-config:
          id-type: assign_id
          update-strategy: default
          table-underline: true
          capital-mode: false
          logic-delete-value: 1
          logic-not-delete-value: 0
        banner: false
      configuration:
        map-underscore-to-camel-case: true
        cache-enabled: false
  ```


<!-- tabs:end -->


3、使用mybati-plus

mybati-plus 基础使用参考 https://mp.baomidou.com/guide/page.html

4、自动填充功能

(1) 在Model中配置@TableField 的 FieldFill.INSERT字段

```java
//默认不处理 DEFAULT,插入时填充字段 INSERT, 更新时填充字段 UPDATE, 插入和更新时填充字段INSERT_UPDATE
@TableField(value = "version", fill = FieldFill.INSERT)
```

(2) 框架中默认会自动填充 "createTime"， "updateTime"， "deleteStatus"，"isDelete"字段。如步骤(1)中需要填充"version"，则可以添加一个SqlFieldFillConfig的配置，如下

```java
@Configuration
public class SqlFieldFillConfig extends FieldFillConfig {
    public SqlFieldFillConfig() {
        //默认给"version" 填充 Integer 类型的 10
        this.strictFills.add(StrictFill.of("version", Integer.class, 10));
    }
}
```

（3）调用mybatis-plus的save时或者model的insert时，会自动填充该字段。

5、分页查询

（1）首先定义查询参数，需要默认继承框架的Pagination

```java
public class SysUserParam extends Pagination {
}
```

```java
// Pagination 定义了三个变量
private int page = 0; // 当前页
private int limit = 10; // 每页条数
private List<String> sort; // 排序,默认ASC （[+/-]字段名）（+或不加前缀表示ASC，-表示DESC）
```

（2） 调用mybatis-plus提供的模板方法com.baomidou.mybatisplus.extension.service.IService#page()

```java
  public Result<PageRes<SysUser>> SysUserPage(SysUserParam param) {
        //PageConvert.page2MybatisPage 会将param中关于分页的参数转为mybatis-plus格式的分页参数
        Page<SysUser> page = mSysUserService.page(PageConvert.page2MybatisPage(param));
        //PageConvert.result 会把mybatis-plus格式分页返回统一成标准分页返回
        return Result.ok(PageConvert.result(page));
  }
```

6、编写复杂的sql的分页

（1）同步骤5 首先定义查询参数，需要默认继承框架的Pagination

（2）在BaseMapper中编写接口

``` java
 IPage<SysUser> getUsers(SysUserParam param, Page<SysUser> page);
```

（3）mapper.xml中编写sql语句，（仅需要编写普通的sql查询，无须关注分页相关）

``` xml
 <select id="getUsers" resultType="SysUser">
        select user_id AS userId, user_name AS userName from sys_user
        <where>
            <if test="param.username != null">
                and user_name=#{param.username}
            </if>
        </where>
    </select>
```

（4） 调用时分别传入原param和PageConvert.page2MybatisPage(param)转换后的mybatis-plus格式的分页参数

``` java
baseMapper.getUsers(param, PageConvert.page2MybatisPage(param));
```

（5）查询结果会自动填充分页及排序信息返回mybatis-plus格式分页返回

``` java
return Result.ok(PageConvert.result(page));
```



## 附录

### 默认分页请求参数格式

```json
{
	"limit": 10,
	"page": 0,
	"sort": [
		"+string",
		"-string2"
	],
	"otherQueryString": "otherQueryString",
	...
}
```

### 默认分页返回格式

```json
{
	"code": 0,
	"message": "message",
	"data": {
		"total": 109,
		"limit": 10,
		"page": 0,
		"items": [
		{},
		{},
		...
		]
	}
}
```




**本页编辑**      **[@gongshiwen](http://192.168.1.23/gongshiwen)** <img src="http://192.168.1.23/uploads/-/system/user/avatar/10/avatar.png?width=100" style="zoom:10%;" />  **[@dengrijin](http://192.168.1.23/demgrijin)**
# Cloud使用说明



## 快速开始

1、 导入maven依赖

``` xml
    <dependency>
      <groupId>com.cecdat</groupId>
      <artifactId>cloud</artifactId>
    </dependency>

```

2、 配置bootstrap.properties文件

创建一个bootstrap.yml文件，参考配置如下。

``` properties
server:
  port: 10012
spring:
  application:
    name: cloud-demo-consumer
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

3、nacos中心配置

在nacos中心服务中需要增加一个配置文件，配置文件id规则如下${prefix}-${spring.profile.active}.${file-extension}。

	-  ${prefix} 未特别指定则采用spring.application.name（步骤2中是配"cloud-demo-consumer"）
	-  ${spring.profile.active} 即bootstrap.properties配的spring.profile.active，没有则不填
	-  ${file-extension} 扩展名，默认properties

如步骤2配置的范例解析：

`${prefix}` 为cloud-demo-consumer，`${spring.profile.active}` 为local，`${file-extension}`使用yaml

最终在中心创建一个名为cloud-demo-consumer-local.yaml的配置文件即可。

文件内容样例：

``` yaml
userName: 李四
```

4、代码中使用

与本地定义的properties完全相同，应用会以8886启动，并能够读取到user.name和user.password变量。

``` java
    @Value("${userName:张三}")
    private String userName;
```

5、配置运行时刷新

在使用变量的类中，增加@RefreshScope

当在nacos中心修改了cloud-demo-consumer-local.yaml配置，无需重启应用，自定义变量user.name和user.password会动态更新。

## 服务间调用

1. 创建一个接口IProviderUserService，配置FeignClient熟悉，如：

   ``` java
   @FeignClient(name="cloud-demo-provider", fallback = UserServiceFallbackServiceImpl.class, configuration = FeignClientLogConfiguration.class)
   public interface IProviderUserService {
   
       @GetMapping("/username")
       String getUserNameById(@RequestParam Long id);
   
       @PostMapping("/username")
       String postUserNameById(@RequestParam Long id);
   }
   ```

   

2. 创建默认调用异常后的回调。

   ``` java
   @Component
   public class UserServiceFallbackServiceImpl implements IProviderUserService {
   
       @Override
       public String getUserNameById(Long id) {
           //throw new ServerException(500, "服务器内部错误，调用getUserNameById接口异常");
           //服务降级处理
           return "服务暂不可用";
       }
   
       @Override
       public String postUserNameById(Long id) {
           return "服务暂不可用";
       }
   }
   ```

   

3. 其他服务直接注入调用。

``` java
   @Resource
   private IProviderUserService iUserService;
```








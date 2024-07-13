# hutool工具中加减密使用说明

> [源码](http://gitlab.cecdat.com/framework/backend/rock/tree/develop/examples/hutool)



## 快速开始

1、 导入maven依赖

``` xml
    <dependency>
    <groupId>com.cecdat</groupId>
    <artifactId>hutool</artifactId>
    </dependency>

```


2、代码使用

** hutool加减密demo **

```java
public class EncryptDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String content = "这里是即将要加密的内容";
        String key = RandomUtil.randomString(16);
        System.out.println(key);
        byte[] bytes = key.getBytes();

        SM4 smf = new SM4("ECB", "PKCS5Padding", bytes);
        String encrypt = smf.encryptHex(content.getBytes());
        System.out.println(encrypt);
        String decrypt = smf.decryptStr(encrypt);
        System.out.println("解密结果："+decrypt);
    }
}
```


**本页编辑**      **[@fenghaixiong](http://192.168.1.23/fenghaixiong)**
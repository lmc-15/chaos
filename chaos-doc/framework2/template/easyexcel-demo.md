# Easy-Excel使用说明

> [源码](http://gitlab.cecdat.com/framework/backend/rock/tree/develop/examples/easyexcel-demo)



## 快速开始

#### **1、 导入maven依赖**

``` xml
    <dependency>
      <groupId>com.cecdat</groupId>
      <artifactId>easyexcel</artifactId>
    </dependency>

```

#### **2、 配置yml文件**

<!-- tabs:start -->

对导出的excel文件样式进行配置

配置demo：

```properties
excel:
  style:
    head-horizontal: 3
    font-height-in-points: 10
    word-wrap: false
    color: 10
    content-horizontal: 3
```
<!-- tabs:end -->

#### **3、代码使用**

##### **3.1 导出**

a.实体的导出

导出demo:

实体：

```java
@Data
public class User {

    @ExcelIgnore
    private Long userId;

    @ExcelProperty(value = {"用户编号"}, index = 0)
    private String userCode;

    @ExcelProperty(value = {"用户名称"}, index = 2)
    private String userName;

    @ExcelProperty(value = {"性别"}, index = 1)
    private String sex;
}
```

其中注解***@ExcelProperty***标识的是实体中需要导出的字段，注解中value表示导出的列名，index表示列的位置；注解***@ExcelIgnore***标识不需要导出的字段。

导出方法

``` java
ExcelUtil.writeByObject(response, 
                       List<User>, FILE_NAME, SHEET_NAME, User.class);
```

reponse为响应对象，List<User>为导出的实体列表，FILE_NAME为导出的文件名，SHEET_NAME为文件的sheet名，User.class为映射的对象。

b.无实体的导出

导出demo:

导出方法1

``` java
ExcelUtil.writeByList(response, List<String> head, List<String> body, FILE_NAME, SHEET_NAME);
```

其中reponse为响应对象，head为文件标题栏，body为导入的数据，FILE_NAME为导出的文件名，SHEET_NAME为文件的sheet名。

导出方法2

``` java
ExcelUtil. writeByMap(response, List<Map<String, Object>> body, FILE_NAME, SHEET_NAME);
```

其中reponse为响应对象，body为导入的数据(map的key值为标题栏，value值为导入的数据值)，FILE_NAME为导出的文件名，SHEET_NAME为文件的sheet名。

##### **3.2 导入**

导入demo:

监听器listener

``` java
public class ModelListener extends AbstractBaseListener<Model> {

    @Override
    public boolean addListBefore(Model model) {
        return true;
    }

    @Override
    public void doListAfter(Model model) {
    }

    @Override
    public void doAfterAll() {
        log.info("解析完成");
    }
}
```

其中addListBefore方法是数据添加到批处理list前进行的业务操作，如数据判断，数据处理等。其中doListAfter方法是数据添加到批处理list后进行的业务操作，如清空list,保存数据等。doAfterAll方法是解析完文件后进行的操作，如释放资源，保存剩余数据等。

导出方法

``` java
EasyExcelFactory.read(file.getInputStream(), Model.class, new ModelListener()).sheet().doRead();
```

file.getInputStream()为导入的文件流，Model.class 为映射的实体类，ModelListener()为监听器

**本页编辑**      **[@zhangyu](http://192.168.1.23/zhangyu)** 
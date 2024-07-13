# OSS服务使用说明

> [源码](http://gitlab.cecdat.com/framework/backend/rock/tree/develop/examples/oss)



## 快速开始

1、 导入maven依赖

``` xml
       <dependency>
            <groupId>com.cecdat.common</groupId>
            <artifactId>oss-boot-starter</artifactId>
        </dependency>
```

2、 配置yml文件

``` yaml
minio:
  url: http://192.168.1.52:9000 # url地址
  access-key: minioadmin # 
  secret-key: minioadmin #
  bucket-name: hmo	#桶名称
  expires: 600 # 默认从minio获取的url的过期时间(秒)
```



3、代码中使用

``` java
 	@Autowired
    MinioTemplate minioTemplate;
```



# 常见使用

1、 上传文件流
概念说明：

- 普通空间：minio默认的空间类型（bucket），不允许生成永久的下载URL（minio的URL生成策略），在控制页面查看的空间名称为private-{bucket-name}。

- 公共空间：框架自动配置了公开的空间类型（bucket），获取的下载URL为永久URL，在控制页面查看的空间名称为public-{bucket-name}。Api中操作该空间则需要带isPublic标记位。

两个空间的物理存储是隔离的，即在private空间存储的文件，读取时也要去private空间读取。（同一个文件上传、下载、删除，isPublic标记位状态必须保持一致）



1、 上传文件流

```java
// objectName 文件名称 ， stream 文件流， contextType 保存类型 ，isPublic 是否是公共空间标记位
public void putObject(String objectName, InputStream stream)；
public void putObject(String objectName, InputStream stream, String contextType)
public void putObject(String objectName, InputStream stream, String contextType, boolean isPublic)    
```

实际使用

``` java
 public void putObject(MultipartFile file) throws Exception {
        InputStream stream = file.getInputStream();
        String contextType = file.getContentType();
        minioTemplate.putObject(file.getOriginalFilename(), stream, contextType);
 }
```

2、获取上传URL，前端直接上传到minio。（该URL有时效，过期时间为配置文件中的expires）

```java
String getPutURL(String objectName);
String getPutURL(String objectName, boolean isPublic);
```

前端上传的demo参考附录里面的官方示例



3、获取文件下载URL（该URL有时效，过期时间为配置文件中的expires）

``` java
String getObjectURL(String objectName);
String getObjectURL(String objectName, boolean isPublic);
```



4、删除文件

``` java
void removeObject(String objectName);
void removeObject(String objectName, boolean isPublic)
```






## 附录

官方demo

``` js
<input type="file" id="selector" multiple>
<button onclick="upload()">Upload</button>

<div id="status">No uploads</div>

<script type="text/javascript">
    // `upload` iterates through all files selected and invokes a helper function called `retrieveNewURL`.
    function upload() {
        // Get selected files from the input element.
        var files = document.querySelector("#selector").files;
        for (var i = 0; i < files.length; i++) {
            var file = files[i];
            // 从服务器获取一个URL
            retrieveNewURL(file, (file, url) => {
                // 上传文件到服务器
                uploadFile(file, url);
            });
        }
    }

    // 发请求到Node.js server获取上传URL。
    // `retrieveNewURL` accepts the name of the current file and invokes the `/presignedUrl` endpoint to
    // generate a pre-signed URL for use in uploading that file:
    function retrieveNewURL(file, cb) {
        fetch(`/objects/upload?objectName=${file.name}`).then((response) => {
            response.text().then((url) => {
                cb(file, url);
            });
        }).catch((e) => {
            console.error(e);
        });
    }

    // 使用Fetch API来上传文件到S3。
    // ``uploadFile` accepts the current filename and the pre-signed URL. It then uses `Fetch API`
    // to upload this file to S3 at `play.min.io:9000` using the URL:
    function uploadFile(file, url) {
        if (document.querySelector('#status').innerText === 'No uploads') {
            document.querySelector('#status').innerHTML = '';
        }
        fetch(url, {
            method: 'PUT',
            body: file
        }).then(() => {
            // If multiple files are uploaded, append upload status on the next line.
            document.querySelector('#status').innerHTML += `<br>Uploaded ${file.name}.`;
        }).catch((e) => {
            console.error(e);
        });
    }
</script>
```



**本页编辑**      **[@dengrijin](http://192.168.1.23/demgrijin)**
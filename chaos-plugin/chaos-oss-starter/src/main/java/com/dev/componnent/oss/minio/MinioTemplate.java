package com.dev.componnent.oss.minio;

import com.dev.autoconfigure.oss.minio.MinioProperties;
import io.minio.MinioClient;
import io.minio.ObjectStat;
import io.minio.Result;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * MinioTemplate
 * <p>
 * 提供MinIo的基本操作API
 *
 * @author Siu
 * @author dengrijin
 * @date 2020 /2/21 9:12
 * @version 0.0.1
 */
@Component
public class MinioTemplate {

    /**
     * The Minio client.
     */
    @Autowired
    MinioClient minioClient;


    /**
     * The Minio properties.
     */
    MinioProperties minioProperties;

    private String publicPolicy;

    /**
     * The constant PREFIX.
     */
    public static final String PREFIX = "private-";
    /**
     * The constant PUBLIC_PREFIX.
     */
    public static final String PUBLIC_PREFIX = "public-";

    /**
     * Sets minio properties.
     *
     * @param minioProperties the minio properties
     */
    @Autowired
    public void setMinioProperties(MinioProperties minioProperties) {
        this.minioProperties = minioProperties;
        this.publicPolicy = "{\n" +
                "     \"Statement\": [\n" +
                "         {\n" +
                "             \"Action\": [\n" +
                "                 \"s3:GetBucketLocation\",\n" +
                "                 \"s3:ListBucket\"\n" +
                "             ],\n" +
                "             \"Effect\": \"Allow\",\n" +
                "             \"Principal\": \"*\",\n" +
                "             \"Resource\": \"arn:aws:s3:::" + getBucketName(true) + "\"\n" +
                "         },\n" +
                "         {\n" +
                "             \"Action\": \"s3:GetObject\",\n" +
                "             \"Effect\": \"Allow\",\n" +
                "             \"Principal\": \"*\",\n" +
                "             \"Resource\": \"arn:aws:s3:::" + getBucketName(true) + "/*\"\n" +
                "         }\n" +
                "     ],\n" +
                " \"Version\": \"2012-10-17\"" +
                " }";
    }

    /**
     * 获取全部bucket
     * <p>
     * https://docs.minio.io/cn/java-client-api-reference.html#listBuckets
     *
     * @return all buckets
     * @throws Exception the exception
     */
    public List<Bucket> getAllBuckets() throws Exception {
        return this.minioClient.listBuckets();
    }


    /**
     * 创建bucket
     * <p>
     * https://docs.minio.io/cn/java-client-api-reference.html#makeBucket
     *
     * @param bucketName bucket名称
     * @param isPublic   是否为公共空间
     * @throws Exception the exception
     */
    public void createBucket(String bucketName, boolean isPublic) throws Exception {
        MinioClient client = this.minioClient;
        if (!client.bucketExists(bucketName)) {
            client.makeBucket(bucketName);
            //公共空间需要设置策略为公开桶
            if (isPublic) {
                client.setBucketPolicy(bucketName, publicPolicy);
            }
        }
    }

    /**
     * 创建bucket
     * <p>
     * https://docs.minio.io/cn/java-client-api-reference.html#makeBucket
     *
     * @param bucketName bucket名称
     * @throws Exception the exception
     */
    public void createBucket(String bucketName) throws Exception {
        createBucket(bucketName, false);
    }


    /**
     * 删除bucket
     * <p>
     * https://docs.minio.io/cn/java-client-api-reference.html#removeBucket
     *
     * @param bucketName bucket名称
     * @throws Exception the exception
     */
    public void removeBucket(String bucketName) throws Exception {
        this.minioClient.removeBucket(bucketName);
    }


    /**
     * 根据前缀获取文件
     *
     * @param bucketName bucket名称
     * @param prefix     前缀
     * @param recursive  是否递归
     * @return all objects by prefix
     * @throws Exception the exception
     */
    public List<Item> getAllObjectsByPrefix(String bucketName, String prefix, boolean recursive) throws Exception {

        List<Item> objectList = new ArrayList<>();
        Iterable<Result<Item>> objectsIterator = this.minioClient.listObjects(bucketName, prefix, recursive);
        while (objectsIterator.iterator().hasNext()) {
            objectList.add(objectsIterator.iterator().next().get());
        }
        return objectList;
    }


    /**
     * 获取文件外链
     * https://docs.minio.io/cn/java-client-api-reference.html#presignedGetObject
     * <p>
     * 生成一个给HTTP GET请求用的presigned URL。浏览器/移动端的客户端可以用这个URL进行下载，即使其所在的存储桶是私有的。这个presigned URL可以设置一个失效时间，默认值是7天
     *
     * @param bucketName bucket名称
     * @param objectName 文件名称
     * @param expires    失效时间（以秒为单位），默认是7天，不得大于七天。
     * @return object url
     * @throws Exception the exception
     */
    public String getObjectURL(String bucketName, String objectName, int expires) throws Exception {
        return this.minioClient.presignedGetObject(bucketName, objectName, expires);
    }

    /**
     * Gets object url.
     *
     * @param objectName 文件名称
     * @param expires    the expires
     * @return the object url
     * @throws Exception the exception
     */
    public String getObjectURL(String objectName, int expires) throws Exception {
        return getObjectURL(getBucketName(), objectName, expires);
    }

    /**
     * Gets object url.
     *
     * @param objectName 文件名称
     * @return the object url
     * @throws Exception the exception
     */
    public String getObjectURL(String objectName) throws Exception {
        return getObjectURL(objectName, false);
    }

    /**
     * Gets object url.
     *
     * @param objectName 文件名称
     * @param isPublic   是否为公共空间
     * @return the object url
     * @throws Exception the exception
     */
    public String getObjectURL(String objectName, boolean isPublic) throws Exception {
        if (isPublic) {
            return this.minioClient.getObjectUrl(getBucketName(true), objectName);
        } else {
            return getObjectURL(objectName, minioProperties.getExpires());
        }
    }


    /**
     * 获取上传URL的地址，通过该地址可以上传文件,文件存储在私密空间
     *
     * @param objectName 文件名称
     * @return put url
     * @throws Exception the exception
     */
    public String getPutURL(String objectName) throws Exception {
        return getPutURL(objectName, false);
    }

    /**
     * 获取上传URL的地址，通过该地址可以上传文件
     *
     * @param objectName 文件名称
     * @param isPublic   是否为公共空间
     * @return put url
     * @throws Exception the exception
     */
    public String getPutURL(String objectName, boolean isPublic) throws Exception {
        createBucket(getBucketName(isPublic), isPublic);
        return this.minioClient.presignedPutObject(getBucketName(isPublic), objectName, minioProperties.getExpires());
    }


    /**
     * 获取文件
     * https://docs.minio.io/cn/java-client-api-reference.html#getObject
     *
     * @param bucketName bucket名称
     * @param objectName 文件名称
     * @return object
     * @throws Exception the exception
     */
    public InputStream getObject(String bucketName, String objectName) throws Exception {
        return this.minioClient.getObject(bucketName, objectName);

    }


    /**
     * 上传文件
     * https://docs.minio.io/cn/java-client-api-reference.html#putObject
     * <p>
     * 拿到流的数据，使用随机生成的content key进行加密，并上传到指定存储桶中。同时将加密后的content key和iv做为加密对象有header也上传到存储桶中。content key使用传入到该方法的master key进行加密
     *
     * @param bucketName bucket名称
     * @param objectName 文件名称
     * @param stream     文件流
     * @throws Exception the exception
     */
    public void putObject(String bucketName, String objectName, InputStream stream) throws Exception {
        this.putObject(bucketName, objectName, stream, "application/octet-stream");

    }

    /**
     * Put object.
     *
     * @param objectName 文件名称
     * @param stream     the stream
     * @throws Exception the exception
     */
    public void putObject(String objectName, InputStream stream) throws Exception {
        this.putObject(getBucketName(), objectName, stream, "application/octet-stream");

    }

    /**
     * Put object.
     *
     * @param objectName 文件名称
     * @param stream     the stream
     * @param isPublic   是否为公共空间
     * @throws Exception the exception
     */
    public void putObject(String objectName, InputStream stream, boolean isPublic) throws Exception {
        this.putObject(objectName, stream, "application/octet-stream", false);

    }

    /**
     * Put object.
     *
     * @param bucketName  bucket名称
     * @param objectName  文件名称
     * @param stream      the stream
     * @param contextType the context type
     * @throws Exception the exception
     */
    public void putObject(String bucketName, String objectName, InputStream stream, String contextType) throws Exception {
        putObject(bucketName, objectName, stream, contextType, false);
    }

    /**
     * Put object.
     *
     * @param bucketName  bucket名称
     * @param objectName  文件名称
     * @param stream      the stream
     * @param contextType the context type
     * @param isPublic    是否为公共空间
     * @throws Exception the exception
     */
    public void putObject(String bucketName, String objectName, InputStream stream, String contextType, boolean isPublic) throws Exception {
        createBucket(bucketName, isPublic);
        this.minioClient.putObject(bucketName, objectName, stream, (long) stream.available(), null, null, contextType);

    }

    /**
     * Put object.
     *
     * @param objectName  文件名称
     * @param stream      the stream
     * @param contextType the context type
     * @throws Exception the exception
     */
    public void putObject(String objectName, InputStream stream, String contextType) throws Exception {
        putObject(objectName, stream, contextType, false);
    }


    /**
     * 上传文件
     *
     * @param objectName  文件名
     * @param stream      文件流
     * @param contextType 文件类型
     * @param isPublic    是否为私有空间
     * @throws Exception the exception
     */
    public void putObject(String objectName, InputStream stream, String contextType, boolean isPublic) throws Exception {
        putObject(getBucketName(isPublic), objectName, stream, contextType, isPublic);
    }


    /**
     * 获取文件信息(对象的元数据)
     * <p>
     * https://docs.minio.io/cn/java-client-api-reference.html#statObject
     *
     * @param bucketName bucket名称
     * @param objectName 文件名称
     * @return object stat
     * @throws Exception the exception
     */
    public ObjectStat getObjectStat(String bucketName, String objectName) throws Exception {
        return this.minioClient.statObject(bucketName, objectName);
    }

    /**
     * 获取私有空间文件信息(对象的元数据)
     * <p>
     *
     * @param objectName 文件名称
     * @return object stat
     * @throws Exception the exception
     */
    public ObjectStat getObjectStat(String objectName) throws Exception {
        return this.minioClient.statObject(getBucketName(), objectName);
    }

    /**
     * 获取文件信息(对象的元数据)
     * <p>
     *
     * @param objectName 文件名称
     * @param isPublic   是否为公共空间
     * @return object stat
     * @throws Exception the exception
     */
    public ObjectStat getObjectStat(String objectName, boolean isPublic) throws Exception {
        return this.minioClient.statObject(getBucketName(isPublic), objectName);
    }


    /**
     * 删除文件
     * https://docs.minio.io/cn/java-client-api-reference.html#removeObject
     *
     * @param bucketName bucket名称
     * @param objectName 文件名称
     * @throws Exception the exception
     */
    public void removeObject(String bucketName, String objectName) throws Exception {
        this.minioClient.removeObject(bucketName, objectName);

    }

    /**
     * 删除私有空间文件
     *
     * @param objectName 文件名
     * @throws Exception the exception
     */
    public void removeObject(String objectName) throws Exception {
        removeObject(getBucketName(), objectName);
    }

    /**
     * 删除文件
     *
     * @param objectName 文件名
     * @param isPublic   是否为公共区域
     * @throws Exception the exception
     */
    public void removeObject(String objectName, boolean isPublic) throws Exception {
        removeObject(getBucketName(isPublic), objectName);
    }

    private String getBucketName() {
        return getBucketName(false);
    }

    private String getBucketName(boolean isPublic) {
        if (isPublic) {
            return PUBLIC_PREFIX + minioProperties.getBucketName();
        } else {
            return PREFIX + minioProperties.getBucketName();
        }
    }
}

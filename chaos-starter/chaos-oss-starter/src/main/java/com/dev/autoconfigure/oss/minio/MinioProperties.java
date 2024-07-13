package com.dev.autoconfigure.oss.minio;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * MinIO 配置项
 *
 * @author Siu
 * @author dengrijin
 * @date 2020/2/21 9:04
 * @version 0.0.1
 */
@Configuration
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {
    public static final String PREFIX = "minio-";

    /**
     * minio 服务地址 http://ip:port
     */
    String url = "";

    /**
     * accessKey
     */
    String accessKey = "";

    /**
     * 密码
     */
    String secretKey = "";

    /**
     * 存储桶
     */
    String bucketName = "default";

    /**
     * 连接的默认超时时间：600S(10分钟)
     */
    int expires = 600;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBucketName() {
        return PREFIX + bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public int getExpires() {
        return expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }
}

/*
 * @(#) HttpRequestParam.java 2018/09/26
 *
 * Copyright 2018 CEC(Fujian) Healthcare Big Data Operation Service Co., Ltd. All rights reserved.
 */
package com.dev.http;


import java.util.HashMap;
import java.util.Map;

import static com.dev.core.constant.GlobalConstants.DEFAULT_CAPACITY;


/**
 * 请求参数对象
 *
 * @author dengrijin
 * @version v0.1
 * @since JDK1.8
 */
public class HttpRequestParam {

    private Map<String, String> headerParams;
    private String url;
    private String content;
    private Map<String, Object> urlParam;
    private Integer socketTimeout;
    private Integer connectTimeout;
    private Integer connectionRequestTimeout;

    public HttpRequestParam(Map<String, String> headerParams, String url, String content, Map<String, Object> urlParam, Integer socketTimeout, Integer connectTimeout, Integer connectionRequestTimeout) {
        this.headerParams = headerParams;
        this.url = url;
        this.content = content;
        this.urlParam = urlParam;
        this.socketTimeout = socketTimeout;
        this.connectTimeout = connectTimeout;
        this.connectionRequestTimeout = connectionRequestTimeout;
    }

    public HttpRequestParam(Map<String, String> headerParams, String url, String content,
                            Map<String, Object> urlParam) {
        super();
        this.content = content;
        this.headerParams = headerParams;
        this.url = url;
        this.urlParam = urlParam;
    }

    public HttpRequestParam(Map<String, String> headerParams, String url, Map<String, Object> urlParam) {
        super();
        this.headerParams = headerParams;
        this.url = url;
        this.urlParam = urlParam;
    }

    public HttpRequestParam(Map<String, String> headerParams, String url) {
        super();
        this.headerParams = headerParams;
        this.url = url;
    }

    public HttpRequestParam() {
    }

    public void addHeaderParams(Map<String, String> headerParams) {
        if (null == this.headerParams) {
            this.headerParams = headerParams;
        } else {
            this.headerParams.putAll(headerParams);
        }
    }

    public void addHeaderParam(String key, String val) {
        if (headerParams == null) {
            headerParams = new HashMap<>(DEFAULT_CAPACITY);
        }
        this.headerParams.put(key, val);
    }


    public Map<String, String> getHeaderParams() {
        return headerParams;
    }

    public void setHeaderParams(Map<String, String> headerParams) {
        this.headerParams = headerParams;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, Object> getUrlParam() {
        return urlParam;
    }

    public void setUrlParam(Map<String, Object> urlParam) {
        this.urlParam = urlParam;
    }

    public Integer getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(Integer socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Integer getConnectionRequestTimeout() {
        return connectionRequestTimeout;
    }

    public void setConnectionRequestTimeout(Integer connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
    }
}

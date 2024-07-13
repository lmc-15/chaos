/*
 * @(#) HttpExcute.java 2018/09/26
 *
 * Copyright 2018 CEC(Fujian) Healthcare Big Data Operation Service Co., Ltd. All rights reserved.
 */
package com.dev.http;

import com.dev.core.exception.ComErrorCode;
import com.dev.core.util.CollUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.dev.core.constant.GlobalConstants.*;


/**
 * Http执行
 *
 * @author dengrijin
 * @author Siu
 * @version v1.1 2021/01/22
 * @since JDK1.8
 */
public class HttpExecute implements ResponseHandler<HttpResponseParam> {

    private static final Logger log = LoggerFactory.getLogger(HttpExecute.class);

    /**
     * 数据读取的超时时间
     */
    private int socketTimeout = 3000;
    /**
     * 连接的超时时间
     */
    private int connectTimeout = 2000;
    /**
     * (连接池)获取Connection 超时时间
     */
    private int connectionRequestTimeout = 2000;

    private RequestConfig defaultRequestConfig;


    private static final int DEFAULT_MAX_CONN = 150;
    private static final int DEFAULT_MAX_CONN_PER_ROUTE = 50;
    private static final CookieStore cookieStore = new BasicCookieStore();

    private final CloseableHttpClient httpClient;
    private final HttpClientContext httpClientContext = new HttpClientContext();


    private RequestConfig defaultRequestConfig() {
        return RequestConfig.custom()
                .setSocketTimeout(socketTimeout)
                .setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(connectionRequestTimeout).build();
    }


    // region Set Request Config

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public void setConnectionRequestTimeout(int connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
    }

    // endregion


    // region 构造函数

    public HttpExecute() {
        this(null, DEFAULT_MAX_CONN, DEFAULT_MAX_CONN_PER_ROUTE);
    }

    /**
     * 支持ssl的https构造函数
     */
    public HttpExecute(SSLConnectionSocketFactory sslConnectionSocketFactory) {
        this(sslConnectionSocketFactory, DEFAULT_MAX_CONN, DEFAULT_MAX_CONN_PER_ROUTE);
    }

    public HttpExecute(int maxConnTotal, int maxConnPerRoute) {
        this(null, maxConnTotal, maxConnPerRoute);

    }

    /**
     * @param sslConnectionSocketFactory SSL 支持
     * @param maxConnTotal               同时间正在使用的最多的连接数
     * @param maxConnPerRoute            一个域名同时间正在使用的最多的连接数
     */
    public HttpExecute(SSLConnectionSocketFactory sslConnectionSocketFactory, int maxConnTotal, int maxConnPerRoute) {
        this.defaultRequestConfig = defaultRequestConfig();
        this.httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslConnectionSocketFactory)
                .setMaxConnTotal(maxConnTotal)
                .setMaxConnPerRoute(maxConnPerRoute)
                .setDefaultCookieStore(cookieStore)
                .build();
    }


    public HttpExecute(HttpClientBuilder builder) {
        this.httpClient = builder.build();
    }

    public HttpExecute(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }


    // endregion


    // region http 操作
    /**
     * Get操作
     *
     * @param param 请求参数
     * @return HttpResponseParam 返回报文
     */
    @Deprecated
    public HttpResponseParam executeGet(HttpRequestParam param) {
        return get(param);
    }

    /**
     * Get操作
     *
     * @param param 请求参数
     * @return HttpResponseParam 返回报文
     */
    public HttpResponseParam get(HttpRequestParam param) {
        HttpGet httpGet = new HttpGet(param.getUrl());
        httpGet.setConfig(getRequestConfig(param));
        paramAnalysis(httpGet, param);
        return executeHttp(httpGet);
    }


    /**
     * Post操作
     *
     * @param param 请求参数
     * @return HttpResponseParam 返回报文
     */
    @Deprecated
    public HttpResponseParam executePost(HttpRequestParam param) {
        return post(param);
    }


    /**
     * Post操作
     *
     * @param param 请求参数
     * @return HttpResponseParam 返回报文
     * @throws
     */
    public HttpResponseParam post(HttpRequestParam param) {
        HttpPost httpPost = new HttpPost(param.getUrl());
        httpPost.setConfig(getRequestConfig(param));
        Optional.ofNullable(param.getContent()).ifPresent(content
                -> httpPost.setEntity(new StringEntity(content, ContentType.APPLICATION_JSON)));
        paramAnalysis(httpPost, param);
        return executeHttp(httpPost);
    }

    /**
     * Put操作
     *
     * @param param 请求参数
     * @return HttpResponseParam 返回报文
     */
    @Deprecated
    public HttpResponseParam executePut(HttpRequestParam param) {
        return put(param);
    }

    /**
     * Put操作
     *
     * @param param 请求参数
     * @return HttpResponseParam 返回报文
     */
    public HttpResponseParam put(HttpRequestParam param) {
        HttpPut httpPut = new HttpPut(param.getUrl());
        httpPut.setConfig(getRequestConfig(param));
        Optional.ofNullable(param.getContent()).ifPresent(content
                -> httpPut.setEntity(new StringEntity(content, ContentType.APPLICATION_JSON)));

        paramAnalysis(httpPut, param);
        return executeHttp(httpPut);
    }



    /**
     * Delete操作
     *
     * @param param 请求参数
     * @return HttpResponseParam 返回报文
     */
    @Deprecated
    public HttpResponseParam executeDelete(HttpRequestParam param) {
        return delete(param);
    }

    /**
     * Delete操作
     *
     * @param param 请求参数
     * @return HttpResponseParam 返回报文
     */
    public HttpResponseParam delete(HttpRequestParam param) {
        HttpDelete httpDelete = new HttpDelete(param.getUrl());
        httpDelete.setConfig(getRequestConfig(param));
        paramAnalysis(httpDelete, param);
        return executeHttp(httpDelete);
    }

    /**
     * 执行http请求
     *
     * @param httpMethod
     * @return
     */
    public HttpResponseParam executeHttp(HttpUriRequest httpMethod) {

        HttpResponseParam httpResponseParam = new HttpResponseParam();
        try (CloseableHttpResponse response = httpClient.execute(httpMethod, httpClientContext)) {
            httpResponseParam = handleResponse(response);
            return httpResponseParam;
        } catch (IOException e) {
            httpResponseParam.setHttpCode(ComErrorCode.NETWORK_ERROR_MSG.getCode());
            httpResponseParam.setErrorMessage(e.getLocalizedMessage());
            return httpResponseParam;
        }
    }

    // endregion


    /**
     * 最简单也是最方便的处理http响应的方法就是使用ResponseHandler接口，
     * 这个接口中有handleResponse(HttpResponse response)方法。 使用这个方法，用户完全不用关心http连接管理器。
     * 当使用ResponseHandler时，HttpClient会自动地将Http连接释放给Http管理器，即使http请求失败了或者抛出了异常。
     *
     * @param response 返回结果
     * @return HttpResponeParam 返回报文
     * @throws
     */
    @Override
    public HttpResponseParam handleResponse(HttpResponse response) throws IOException {
        HttpResponseParam httpResponseParam = new HttpResponseParam();
        httpResponseParam.setHttpCode(response.getStatusLine().getStatusCode());
        httpResponseParam.setHeaders(response.getAllHeaders());
        HttpEntity entity = response.getEntity();
        ContentType contentType = ContentType.getOrDefault(entity);
        Charset charset = Optional.ofNullable(contentType.getCharset()).orElse(UTF8);

        if (CollUtil.isNotEmpty(contentType.getMimeType())
                && BYTE_MIME_TYPE_LIST.contains(contentType.getMimeType().split(URL_SPLIT_CHAR)[0])) {
            httpResponseParam.setByteContents(EntityUtils.toByteArray(entity));
            return httpResponseParam;
        }

        String content = EntityUtils.toString(entity, charset);
        httpResponseParam.setStringContents(content);
        return httpResponseParam;
    }

    /**
     * 参数解析（header和url参数）
     *
     * @param httpRequestBase 请求参数
     * @param param           请求参数
     * @return HttpResponeParam 返回报文
     * @throws
     */
    private void paramAnalysis(HttpRequestBase httpRequestBase, HttpRequestParam param) {

        Optional.ofNullable(param.getHeaderParams()).ifPresent(map -> map.forEach(httpRequestBase::addHeader));

        Optional.ofNullable(param.getUrlParam()).ifPresent(map -> {
            List<NameValuePair> params = new ArrayList<>();
            map.forEach((k, v) -> params.add(new BasicNameValuePair(k, String.valueOf(v))));
            URIBuilder uriBuilder = new URIBuilder(httpRequestBase.getURI()).addParameters(params)
                    .setCharset(UTF8);
            try {
                httpRequestBase.setURI(uriBuilder.build());
            } catch (URISyntaxException e) {
                log.error("URL参数解析错误：", e);
            }
        });
    }


    /**
     * 请求类型处理
     *
     * @param method       请求方法
     * @param requestParam 请求参数
     * @return
     * @throws
     */
    public HttpResponseParam executeRequest(HttpMethod method, HttpRequestParam requestParam) {
        if (requestParam == null || requestParam.getUrl() == null) {
            log.info("请求URL为空");
            throw new IllegalArgumentException("请求URL为空");
        }
        HttpResponseParam responseParam;
        switch (method) {
            case GET:
                responseParam = this.get(requestParam);
                break;
            case PUT:
                responseParam = this.put(requestParam);
                break;
            case POST:
                responseParam = this.post(requestParam);
                break;
            case DELETE:
                responseParam = this.delete(requestParam);
                break;
            default:
                return null;
        }
        return responseParam;
    }


    /**
     * 网络请求仅提示
     *
     * @param method
     * @param requestParam
     * @param okMsg
     * @param failMsg
     */
    public HttpResponseParam executeHttpTips(HttpMethod method, HttpRequestParam requestParam, String okMsg, String failMsg) {
        HttpResponseParam responseParam = executeRequest(method, requestParam);
        if (HttpStatus.OK.value() == responseParam.getHttpCode()) {
            log.info("{} body:{}", okMsg, responseParam.getStringContents());
        } else {
            log.info("{} code:{}  body:{}", failMsg, responseParam.getHttpCode(), responseParam.getStringContents());
        }
        return responseParam;
    }

    public HttpResponseParam executeHttpTips(HttpMethod method, HttpRequestParam requestParam) {
        return executeHttpTips(method, requestParam, "请求成功", "请求失败");
    }

    /**
     * 请求服务
     *
     * @param method  请求的类型
     * @param url     请求的url
     * @param content 请求的body
     */
    public HttpResponseParam executeRequest(HttpMethod method, String url, String content) {
        HttpRequestParam requestParam = new HttpRequestParam();
        requestParam.setUrl(url);
        requestParam.setContent(content);
        return this.executeRequest(method, requestParam);
    }

    public HttpResponseParam executeRequest(HttpMethod method, String url, String content, Integer timeout) {
        HttpRequestParam requestParam = new HttpRequestParam();
        requestParam.setSocketTimeout(Objects.isNull(timeout) ? null : timeout);
        requestParam.setUrl(url);
        requestParam.setContent(content);
        return this.executeRequest(method, requestParam);
    }


    /**
     * 设置超时配置
     *
     * @param
     * @return
     * @throws
     */
    private RequestConfig getRequestConfig(HttpRequestParam param) {

        if (CollUtil.isNotEmpty(param.getSocketTimeout())
                || CollUtil.isNotEmpty(param.getConnectTimeout())
                || CollUtil.isNotEmpty(param.getConnectionRequestTimeout())) {
            return RequestConfig
                    .custom()
                    .setSocketTimeout(Optional.ofNullable(param.getSocketTimeout()).orElse(socketTimeout))
                    .setConnectTimeout(Optional.ofNullable(param.getConnectTimeout()).orElse(connectTimeout))
                    .setConnectionRequestTimeout(Optional.ofNullable(param.getConnectionRequestTimeout()).orElse(connectionRequestTimeout))
                    .build();
        } else {
            return defaultRequestConfig;
        }

    }

    public CloseableHttpClient getHttpClient() {
        return httpClient;
    }

    public CookieStore getCookieStore() {
        return cookieStore;
    }
}

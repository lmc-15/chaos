/*
 * @(#) HttpResponeParam.java 2018/09/26
 *
 * Copyright 2018 CEC(Fujian) Healthcare Big Data Operation Service Co., Ltd. All rights reserved.
 */
package com.dev.http;


import org.apache.http.Header;
import org.apache.http.message.HeaderGroup;

/**
 * 返回参数对象
 *
 * @author dengrijin<dengrijin   @   cecdat.com>
 * @version v0.1 2018/09/26
 * @since JDK1.8
 */
public class HttpResponseParam {
    private HeaderGroup headergroup;
    private String stringContents = null;
    private Integer httpCode;
    private String errorMessage;
    private byte[] byteContents;

    public HttpResponseParam() {
        super();
        this.headergroup = new HeaderGroup();
    }

    public HttpResponseParam(String stringContents, Header[] headers, int httpCode, String errorMessage) {
        super();
        this.headergroup = new HeaderGroup();
        this.stringContents = stringContents;
        this.headergroup.setHeaders(headers);
        this.httpCode = httpCode;
        this.errorMessage = errorMessage;
    }

    public Header[] getHeaders() {
        return this.headergroup.getAllHeaders();
    }

    public void setHeaders(Header[] headers) {
        this.headergroup.setHeaders(headers);
    }

    public byte[] getByteContents() {
        if (byteContents == null) {
            return null;
        }
        return byteContents.clone();
    }

    public HeaderGroup getHeadergroup() {
        return headergroup;
    }

    public void setHeadergroup(HeaderGroup headergroup) {
        this.headergroup = headergroup;
    }

    public void setByteContents(byte[] byteContents) {
        if (byteContents == null) {
            this.byteContents = null;
        } else {
            this.byteContents = byteContents.clone();
        }
    }

    public String getStringContents() {
        return stringContents;
    }

    public void setStringContents(String stringContents) {
        this.stringContents = stringContents;
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

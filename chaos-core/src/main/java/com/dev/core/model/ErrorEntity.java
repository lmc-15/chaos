package com.dev.core.model;

/**
 * <code>ErrorEntity</code>
 *
 * @author dengrijin
 * @version v0.1 2020/06/28
 * @since JDK1.8
 */
public class ErrorEntity {
    Integer httpCode;
    Integer code;
    String msg;

    public ErrorEntity() {
    }

    public ErrorEntity(Integer httpCode, Integer code, String msg) {
        this.httpCode = httpCode;
        this.code = code;
        this.msg = msg;
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public ErrorEntity setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public ErrorEntity setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ErrorEntity setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}

package com.dev.core.exception;

/**
 * @ClassDescription:
 * @JdkVersion: 1.8
 * @Author: lmc
 * @email: mingchao.liu@greatdb.com
 * @Created: 2024/7/3 13:54
 */
public enum ComErrorCode implements IError {
    /**
     * 常见错误
     */
    UNKNOWN_ERROR(1000, "未知异常"),
    UNKNOWN_ERROR_MSG(1000, "未知异常:%s"),
    PERMISSION_DENIED(2000, "权限被拒绝"),
    TOKEN_INVALID(2001, "凭证无效"),
    INNER_ERROR(3000, "未知系统内部错误"),
    INNER_ERROR_MSG(3000, "未知系统内部错误:%s"),
    DB_ERROR(3010, "数据库操作异常"),
    DB_ERROR_MSG(3010, "数据库操作异常:%s"),
    REDIS_ERROR(3020, "REDIS操作异常"),
    REDIS_ERROR_MSG(3020, "REDIS操作异常:%s"),
    NETWORK_ERROR(4000, "网络通讯异常"),
    NETWORK_ERROR_MSG(4000, "网络通讯异常"),
    PARAM_ERROR(5000, "参数校验错误"),
    PARAM_ERROR_MSG(5000, "参数校验错误：%s");
    private Integer code;
    private String msg;

    ComErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}

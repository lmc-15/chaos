package com.dev.core.exception;

/**
 * @ClassDescription:
 * @JdkVersion: 1.8
 * @Author: lmc
 * @email: mingchao.liu@greatdb.com
 * @Created: 2024/7/3 13:54
 */
public class ServerException extends BaseException {

    public ServerException(String msg) {
        super(3000, msg);
    }

    public ServerException(int code, String msg) {
        super(code, msg);
    }


    public ServerException(int code, String msg, Throwable throwable) {
        super(code, msg, throwable);
    }

    public ServerException(int code, String msg, Object... args) {
        super(code, msg, args);
    }

    public ServerException(IError error) {
        super(error);
    }

    public ServerException(IError error, Throwable throwable) {
        super(error, throwable);
    }

    public ServerException(IError error, Object... args) {
        super(error, args);
    }

}

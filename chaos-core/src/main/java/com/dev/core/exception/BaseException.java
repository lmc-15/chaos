package com.dev.core.exception;

/**
 * @ClassDescription:
 * @JdkVersion: 1.8
 * @Author: lmc
 * @email: mingchao.liu@greatdb.com
 * @Created: 2024/7/3 13:54
 */
public abstract class BaseException extends RuntimeException {
    private static final long serialVersionUID = -6979901566637669960L;


    private IError error;

    private int code;

    private String msg;

    public BaseException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(int code, String msg, Throwable throwable) {
        super(msg, throwable);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(int code, String msg, Object... args) {
        super(String.format(msg, args));
        this.code = code;
        this.msg = this.getMessage();
    }

    public BaseException(IError error) {
        super(error.getMsg());
        this.code = error.getCode();
        this.msg = error.getMsg();
        this.error = error;
    }

    public BaseException(IError error, Throwable throwable) {
        super(error.getMsg(), throwable);
        this.error = error;
        this.code = error.getCode();
        this.msg = error.getMsg();
    }

    public BaseException(IError error, Object... args) {
        super(String.format(error.getMsg(), args));
        this.error = error;
        this.code = error.getCode();
        this.msg = this.getMessage();
    }

    @Override
    public void printStackTrace() {
    }

    public IError getError() {
        return error;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

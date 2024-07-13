package com.dev.core.model;


import com.dev.core.constant.GlobalConstants;

/**
 * 接口返回对象
 *
 * @author dengrijin
 * @author siu
 * @date 2020年7月9日 下午14:17:32
 */
public class Result<T> {

    /**
     * 结果返回码
     */
    private int code;
    /**
     * 结果信息描述
     */
    private String message;
    /**
     * 结果数据
     */
    private T data;


    public Result() {
    }

    /**
     * 默认构造
     *
     * @param data
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    private static <T> Result<T> build(T data, int code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setData(data);
        result.setMessage(msg);
        return result;
    }


    // region 默认构造

    public static <T> Result<T> ok() {
        return build(null, GlobalConstants.SUCCESS, GlobalConstants.SUCCESS_MSG);
    }

    public static <T> Result<T> ok(T data) {
        return build(data, GlobalConstants.SUCCESS, GlobalConstants.SUCCESS_MSG);
    }

    public static <T> Result<T> ok(T data, String msg) {
        return build(data, GlobalConstants.SUCCESS, msg);
    }

    public static <T> Result<T> failed() {
        return build(null, GlobalConstants.FAIL, GlobalConstants.FAILED_MSG);
    }

    public static <T> Result<T> failed(String msg) {
        return build(null, GlobalConstants.FAIL, msg);
    }

    public static <T> Result<T> failed(int code, String msg) {
        return build(null, code, msg);
    }

    public static <T> Result<T> failed(T data) {
        return build(data, GlobalConstants.FAIL, GlobalConstants.FAILED_MSG);
    }
    public static <T> Result<T> failed(T data, String msg) {
        return build(data, GlobalConstants.FAIL, msg);
    }

    // endregion

    // region setter & getter

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    // endregion


}

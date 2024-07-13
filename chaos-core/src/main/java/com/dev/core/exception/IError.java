package com.dev.core.exception;

/**
 * @ClassDescription:
 * @JdkVersion: 1.8
 * @Author: lmc
 * @email: mingchao.liu@greatdb.com
 * @Created: 2024/7/3 13:54
 */
public interface IError {
    /**
     * Gets code.
     *
     * @return the code
     */
    int getCode();

    /**
     * Gets msg.
     *
     * @return the msg
     */
    String getMsg();
}

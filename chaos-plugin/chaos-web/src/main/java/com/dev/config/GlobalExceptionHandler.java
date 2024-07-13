/*
 * @(#) GlobalExceptionHandler.java 2018/09/19
 *
 * Copyright 2018 CEC(Fujian) Healthcare Big Data Operation Service Co., Ltd. All rights reserved.
 */
package com.dev.config;


import com.dev.core.exception.ComErrorCode;
import com.dev.core.exception.ServerException;
import com.dev.core.model.ErrorContains;
import com.dev.core.model.ErrorEntity;
import com.dev.core.model.Null;
import com.dev.core.model.Result;
import com.dev.core.util.CollUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;


/**
 * <code>GlobalExceptionHandler</code>
 * <p>
 * 全局异常处理
 *
 * @author dengrijin
 * @version v0.1 2018/09/19
 * @since JDK1.8
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(ServerException.class)
    public Result<Null> handleServerException(HttpServletRequest request, HttpServletResponse response, ServerException e) {

        StackTraceElement stackTraceElement = e.getStackTrace()[0];
        String path = stackTraceElement.getClassName() + ":" + stackTraceElement.getLineNumber();

        return Result.failed(e.getCode(), e.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public Result<Null> handleException(HttpServletRequest request, HttpServletResponse response, Exception e) {
        int httpCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        int code = ComErrorCode.INNER_ERROR.getCode();
        String msg = e.getMessage();
        if (Objects.isNull(msg)) {
            msg = e.toString();
        }
        StackTraceElement stackTraceElement = e.getStackTrace()[0];
        String path = stackTraceElement.getClassName() + ":" + stackTraceElement.getLineNumber();

        ErrorEntity errorEntity = ErrorContains.search(e.getClass());
        if (CollUtil.isNotEmpty(errorEntity)) {
            httpCode = errorEntity.getHttpCode();
            code = errorEntity.getCode();
            msg = String.format(errorEntity.getMsg(), e.getMessage());
        }

        response.setStatus(httpCode);
        return Result.failed(code, msg);
    }

}

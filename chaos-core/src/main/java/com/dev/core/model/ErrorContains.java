/*
 * @(#) BusinessConsts.java 2018/09/18
 *
 * Copyright 2018 CEC(Fujian) Healthcare Big Data Operation Service Co., Ltd. All rights reserved.
 */
package com.dev.core.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * <code>ErrorContains</code>
 * <p>
 * 错误容器
 *
 * @author dengrijin
 * @version v0.1 2020/06/28
 * @since JDK1.8
 */
public class ErrorContains {

    private ErrorContains() {
    }

    /**
     * 注册相关错误信息
     */
    private static Map<Class<?>, ErrorEntity> errorMaps = new ConcurrentHashMap<>();

    public static void registeredError(Map<Class<?>, ErrorEntity> errors) {
        errorMaps.putAll(errors);
    }

    public static void registeredError(Class<?> classz, ErrorEntity error) {
        errorMaps.put(classz, error);
    }

    public static ErrorEntity search(Class<?> classz) {
        return errorMaps.get(classz);
    }

}

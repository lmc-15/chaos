/*
 * @(#) IParamVerifiable.java 2020/04/08
 *
 * Copyright 2020 CEC(Fujian) Healthcare Big Data Operation Service Co., Ltd. All rights reserved.
 */
package com.dev.core.model;

/**
 * <code>IVerifiableParam</code>
 * 实现该接口表明该类为参数类，可校验值合法
 *
 * @author dengrijin
 * @version v0.1 2020/07/20
 * @see
 * @since JDK1.8
 */
@FunctionalInterface
public interface IParamVerifiable {

    /**
     * 参数校验方法
     * @param groups 验证组信息
     * @return 结果提示(无报错则为空)
     */
    String validate(Class<?>... groups);

}

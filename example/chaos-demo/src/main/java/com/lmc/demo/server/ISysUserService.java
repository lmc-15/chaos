/*
* @(#) CecProjectController.java 2018/09/18
*
* Copyright 2018 CEC(Fujian) Healthcare Big Data Operation Service Co., Ltd. All rights reserved.
*/
package com.lmc.demo.server;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lmc.demo.entity.SysUser;

/**
 * <code> ISysUserService  </code>
 * <p>
 * 用户 服务类
 *
 * @author developer<developer@cecdat.com>
 * @version v0.1 2018/09/18
 * @since JDK1.8
 */
public interface ISysUserService extends IService<SysUser> {
    String selectNickNameById(Long id);

    void add(SysUser sysUser);
}

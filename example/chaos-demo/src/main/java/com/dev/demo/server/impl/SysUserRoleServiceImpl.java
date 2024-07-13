/*
* @(#) CecProjectController.java 2018/09/18
*
* Copyright 2018 CEC(Fujian) Healthcare Big Data Operation Service Co., Ltd. All rights reserved.
*/
package com.dev.demo.server.impl;


import com.dev.demo.dao.SysUserRoleDao;
import com.dev.demo.entity.SysUserRole;
import com.dev.demo.server.ISysUserRoleService;
import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

 /**
 *
 * @ClassName: SysUserRoleServiceImpl
 * @Description: 用户角色关系表 服务实现类
 * @author developer<developer@cecdat.com>
 * @date 2024-07-12
 *
 */
@Slf4j
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRole> implements ISysUserRoleService {

}

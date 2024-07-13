/*
 * @(#) CecProjectController.java 2018/09/18
 *
 * Copyright 2018 CEC(Fujian) Healthcare Big Data Operation Service Co., Ltd. All rights reserved.
 */
package com.lmc.demo.server.impl;


import com.lmc.demo.dao.SysUserDao;
import com.lmc.demo.entity.SysUser;
import com.lmc.demo.server.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author developer<developer @ cecdat.com>
 * @ClassName: SysUserServiceImpl
 * @Description: 用户 服务实现类
 * @date 2024-07-12
 */
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements ISysUserService {

    private final SysUserDao sysUserDao;

    public SysUserServiceImpl(SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }

    @Override
    public String selectNickNameById(Long id) {
        return sysUserDao.selectNickNameById(id);
    }

    @Override
    public void add(SysUser sysUser) {
        baseMapper.insert(sysUser);
    }
}

/*
 * @(#) CecProjectController.java 2018/09/18
 *
 * Copyright 2018 CEC(Fujian) Healthcare Big Data Operation Service Co., Ltd. All rights reserved.
 */
package com.dev.demo.server.impl;


import com.dev.demo.dao.SysUserDao;
import com.dev.demo.entity.SysUser;
import com.dev.demo.server.ISysUserService;
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

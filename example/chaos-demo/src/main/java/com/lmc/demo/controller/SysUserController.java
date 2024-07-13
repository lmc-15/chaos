/*
* @(#) CecProjectController.java 2018/09/18
* 
* Copyright 2018 CEC(Fujian) Healthcare Big Data Operation Service Co., Ltd. All rights reserved.
*/
package com.lmc.demo.controller;

import com.dev.core.model.Null;
import com.dev.core.model.Result;
import com.lmc.demo.entity.SysUser;
import com.lmc.demo.server.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


/**
* <code> SysUser </code>
* <p>
*
* @author developer<developer@cecdat.com>
* @version v0.1 2018/09/18
* @since JDK1.8
*/
@RestController
@RequestMapping(value = "/v1/users")
@Api(tags = {"用户管理接口"})
public class SysUserController {

    private final ISysUserService iSysUserService;

    public SysUserController(ISysUserService iSysUserService) {
        this.iSysUserService = iSysUserService;
    }

    @ApiOperation(value = "查询NickName：根据用户Id")
    @GetMapping("/{id}")
    Result<String> getNickNameById(@PathVariable Long id) {
        return Result.ok(iSysUserService.selectNickNameById(id));
    }

    @ApiOperation(value = "新增用户")
    @PostMapping("")
    Result<Null> add(@RequestBody SysUser sysUser) {
        iSysUserService.add(sysUser);
        return Result.ok();
    }
}
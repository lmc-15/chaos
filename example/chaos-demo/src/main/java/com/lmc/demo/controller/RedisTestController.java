package com.lmc.demo.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.api.R;
import com.dev.core.model.Null;
import com.dev.core.model.Result;
import com.dev.redis.util.RedisUtils;
import com.lmc.demo.entity.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassDescription:
 * @JdkVersion: 1.8
 * @Author: lmc
 * @email: mingchao.liu@greatdb.com
 * @Created: 2024/7/13 11:47
 */
@RestController
@RequestMapping(value = "/v1/redis")
@Api(tags = {"Redis模块测试"})
public class RedisTestController {

    final
    RedisUtils redisUtils;

    public RedisTestController(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    @ApiOperation(value = "查询NickName：根据用户Id")
    @GetMapping("/{key}")
    Result<String> getNickNameById(@PathVariable String key) {
        System.out.println(redisUtils.getString(key));
        return Result.ok();
    }

    @ApiOperation(value = "新增用户")
    @PostMapping("")
    Result<Null> add(@RequestBody SysUser sysUser) {
        redisUtils.setString("sysUser", JSON.toJSONString(sysUser));
        return Result.ok();
    }
}

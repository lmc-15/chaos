package com.dev.controller;


import com.dev.core.model.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <code>PublicToolController</code>
 * <p>
 * 公共工具接口
 *
 * @author dengrijin
 * @version v0.1 2019/09/11
 * @since JDK1.8
 */
@RestController
@RequestMapping(value = "/V1.0/public")
@Api(tags = {"公共工具相关API"})
public class PublicToolController {
    @ApiOperation(value = "时间获取", httpMethod = "GET", notes = "时间获取")
    @GetMapping(value = "/time")
    public Result<Long> getServerTime() {
        return Result.ok(System.currentTimeMillis());
    }

}

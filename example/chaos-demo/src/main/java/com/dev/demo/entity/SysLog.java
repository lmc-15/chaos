/*
* @(#) CecProjectController.java 2018/09/18
* 
* Copyright 2018 CEC(Fujian) Healthcare Big Data Operation Service Co., Ltd. All rights reserved.
*/
package com.dev.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;


 /**
 * <code> SysLog </code>
 * <p>
 *
 * @author developer<developer@cecdat.com>
 * @version v0.1 2018/09/18
 * @since JDK1.8
 */
@ApiModel(value="登入日志对象",description="登入日志实体对象描述")
@TableName("sys_log")
public class SysLog extends Model<SysLog> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="主键ID")
    @TableId("id")
    private Integer id;

    @ApiModelProperty(value="用户ID")
    @TableField("create_by")
    private String createBy;

    @ApiModelProperty(value="请求时间")
    @TableField("request_time")
    private Integer requestTime;

    @ApiModelProperty(value="创建时间")
    @TableField("created_time")
    private Date createdTime;

    @ApiModelProperty(value="请求地址")
    @TableField("url")
    private String url;

    @ApiModelProperty(value="接口名称")
    @TableField("intf_name")
    private String intfName;

    @ApiModelProperty(value="返回状态")
    @TableField("code")
    private String code;

    @ApiModelProperty(value="异常内容")
    @TableField("exception_msg")
    private String exceptionMsg;



    public Integer getId() {
        return id;
    }

    public SysLog setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public SysLog setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public Integer getRequestTime() {
        return requestTime;
    }

    public SysLog setRequestTime(Integer requestTime) {
        this.requestTime = requestTime;
        return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public SysLog setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public SysLog setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getIntfName() {
        return intfName;
    }

    public SysLog setIntfName(String intfName) {
        this.intfName = intfName;
        return this;
    }

    public String getCode() {
        return code;
    }

    public SysLog setCode(String code) {
        this.code = code;
        return this;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public SysLog setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
        return this;
    }

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}

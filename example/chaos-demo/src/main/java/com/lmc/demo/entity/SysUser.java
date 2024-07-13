/*
* @(#) CecProjectController.java 2018/09/18
* 
* Copyright 2018 CEC(Fujian) Healthcare Big Data Operation Service Co., Ltd. All rights reserved.
*/
package com.lmc.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Getter;


/**
 * <code> SysUser </code>
 * <p>
 *
 * @author developer<developer@cecdat.com>
 * @version v0.1 2018/09/18
 * @since JDK1.8
 */
@Getter
@ApiModel(value="用户对象",description="用户实体对象描述")
@TableName("sys_user")
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="主键ID")
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value="用户账号")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty(value="用户密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value="用户昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty(value="用户电话号码")
    @TableField("telephone_number")
    private String telephoneNumber;

    @ApiModelProperty(value="用户邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value="用户状态;0:使用中")
    @TableField("state")
    private Integer state;

    @ApiModelProperty(value="是否禁用;0:启用,1:禁用")
    @TableField("enable")
    private Integer enable;

    @ApiModelProperty(value="用户类型;0:为root用户,1:为普通用户")
    @TableField("user_type")
    private Integer userType;

    @ApiModelProperty(value="修改密码时间")
    @TableField("last_updated_password")
    private Date lastUpdatedPassword;

    @ApiModelProperty(value="登入时间")
    @TableField("last_login_time")
    private Date lastLoginTime;

    @ApiModelProperty(value="删除;false正常true删除")
    @TableField("deleted")
    private Integer deleted;

    @ApiModelProperty(value="操作用户ID")
    @TableField("create_by")
    private String createBy;

    @ApiModelProperty(value="创建时间")
    @TableField("created_time")
    private Date createdTime;

    @ApiModelProperty(value="更新时间")
    @TableField("updated_time")
    private Date updatedTime;


    public SysUser setId(Long id) {
        this.id = id;
        return this;
    }

    public SysUser setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public SysUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public SysUser setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public SysUser setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    public SysUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public SysUser setState(Integer state) {
        this.state = state;
        return this;
    }

    public SysUser setEnable(Integer enable) {
        this.enable = enable;
        return this;
    }

    public SysUser setUserType(Integer userType) {
        this.userType = userType;
        return this;
    }

    public SysUser setLastUpdatedPassword(Date lastUpdatedPassword) {
        this.lastUpdatedPassword = lastUpdatedPassword;
        return this;
    }

    public SysUser setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        return this;
    }

    public SysUser setDeleted(Integer deleted) {
        this.deleted = deleted;
        return this;
    }

    public SysUser setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public SysUser setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public SysUser setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
        return this;
    }

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}

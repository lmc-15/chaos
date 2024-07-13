/*
* @(#) CecProjectController.java 2018/09/18
* 
* Copyright 2018 CEC(Fujian) Healthcare Big Data Operation Service Co., Ltd. All rights reserved.
*/
package com.lmc.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;


 /**
 * <code> SysUserRole </code>
 * <p>
 *
 * @author developer<developer@cecdat.com>
 * @version v0.1 2018/09/18
 * @since JDK1.8
 */
@ApiModel(value="用户角色关系表对象",description="用户角色关系表实体对象描述")
@TableName("sys_user_role")
public class SysUserRole extends Model<SysUserRole> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="主键ID")
    @TableId("id")
    private Integer id;

    @ApiModelProperty(value="用户id")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty(value="角色id")
    @TableField("role_id")
    private Long roleId;



    public Integer getId() {
        return id;
    }

    public SysUserRole setId(Integer id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public SysUserRole setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getRoleId() {
        return roleId;
    }

    public SysUserRole setRoleId(Long roleId) {
        this.roleId = roleId;
        return this;
    }

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}

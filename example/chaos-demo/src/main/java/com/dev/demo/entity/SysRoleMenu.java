/*
* @(#) CecProjectController.java 2018/09/18
* 
* Copyright 2018 CEC(Fujian) Healthcare Big Data Operation Service Co., Ltd. All rights reserved.
*/
package com.dev.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;


 /**
 * <code> SysRoleMenu </code>
 * <p>
 *
 * @author developer<developer@cecdat.com>
 * @version v0.1 2018/09/18
 * @since JDK1.8
 */
@ApiModel(value="角色菜单关系表对象",description="角色菜单关系表实体对象描述")
@TableName("sys_role_menu")
public class SysRoleMenu extends Model<SysRoleMenu> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="主键ID")
    @TableId("id")
    private Integer id;

    @ApiModelProperty(value="角色id")
    @TableField("role_id")
    private Long roleId;

    @ApiModelProperty(value="菜单id")
    @TableField("menu_id")
    private Long menuId;



    public Integer getId() {
        return id;
    }

    public SysRoleMenu setId(Integer id) {
        this.id = id;
        return this;
    }

    public Long getRoleId() {
        return roleId;
    }

    public SysRoleMenu setRoleId(Long roleId) {
        this.roleId = roleId;
        return this;
    }

    public Long getMenuId() {
        return menuId;
    }

    public SysRoleMenu setMenuId(Long menuId) {
        this.menuId = menuId;
        return this;
    }

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}

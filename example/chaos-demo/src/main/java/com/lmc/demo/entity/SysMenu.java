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


 /**
 * <code> SysMenu </code>
 * <p>
 *
 * @author developer<developer@cecdat.com>
 * @version v0.1 2018/09/18
 * @since JDK1.8
 */
@ApiModel(value="菜单对象",description="菜单实体对象描述")
@TableName("sys_menu")
public class SysMenu extends Model<SysMenu> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="主键ID")
    @TableId("id")
    private Long id;

    @ApiModelProperty(value="主键父ID")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty(value="菜单名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value="菜单编码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value="请求地址")
    @TableField("url")
    private String url;

    @ApiModelProperty(value="菜单类型;1:菜单,2:功能按钮")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value="菜单图标")
    @TableField("menu_icon")
    private String menuIcon;

    @ApiModelProperty(value="权限类型;1:默认权限,2:配置权限，3默认管理员权限")
    @TableField("permission_type")
    private Integer permissionType;

    @ApiModelProperty(value="排序")
    @TableField("sort_num")
    private Integer sortNum;

    @ApiModelProperty(value="逻辑删除标识;false正常true删除")
    @TableField("deleted")
    private Integer deleted;

    @ApiModelProperty(value="创建时间")
    @TableField("created_time")
    private Date createdTime;

    @ApiModelProperty(value="更新时间")
    @TableField("updated_time")
    private Date updatedTime;



    public Long getId() {
        return id;
    }

    public SysMenu setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getParentId() {
        return parentId;
    }

    public SysMenu setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getName() {
        return name;
    }

    public SysMenu setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public SysMenu setCode(String code) {
        this.code = code;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public SysMenu setUrl(String url) {
        this.url = url;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public SysMenu setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public SysMenu setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
        return this;
    }

    public Integer getPermissionType() {
        return permissionType;
    }

    public SysMenu setPermissionType(Integer permissionType) {
        this.permissionType = permissionType;
        return this;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public SysMenu setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
        return this;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public SysMenu setDeleted(Integer deleted) {
        this.deleted = deleted;
        return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public SysMenu setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public SysMenu setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
        return this;
    }

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}

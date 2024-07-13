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
 * <code> SysRole </code>
 * <p>
 *
 * @author developer<developer@cecdat.com>
 * @version v0.1 2018/09/18
 * @since JDK1.8
 */
@ApiModel(value="角色对象",description="角色实体对象描述")
@TableName("sys_role")
public class SysRole extends Model<SysRole> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="ID主键名称")
    @TableId("id")
    private Long id;

    @ApiModelProperty(value="角色名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value="类型;0、为root角色，1、为普通角色")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value="角色描述")
    @TableField("description")
    private String description;

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

    public SysRole setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SysRole setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public SysRole setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SysRole setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public SysRole setDeleted(Integer deleted) {
        this.deleted = deleted;
        return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public SysRole setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public SysRole setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
        return this;
    }

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}

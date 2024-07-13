package com.lmc.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lmc.demo.entity.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author developer<developer@cecdat.com>
 * @since 2024-07-12
 */
public interface SysUserDao extends BaseMapper<SysUser> {
 String selectNickNameById(@Param("id") Long id);
}

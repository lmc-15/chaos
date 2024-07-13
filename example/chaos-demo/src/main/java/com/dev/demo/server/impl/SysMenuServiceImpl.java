/*
* @(#) CecProjectController.java 2018/09/18
*
* Copyright 2018 CEC(Fujian) Healthcare Big Data Operation Service Co., Ltd. All rights reserved.
*/
package com.dev.demo.server.impl;


import com.dev.demo.dao.SysMenuDao;
import com.dev.demo.entity.SysMenu;
import com.dev.demo.server.ISysMenuService;
import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

 /**
 *
 * @ClassName: SysMenuServiceImpl
 * @Description: 菜单 服务实现类
 * @author developer<developer@cecdat.com>
 * @date 2024-07-12
 *
 */
@Slf4j
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenu> implements ISysMenuService {

}

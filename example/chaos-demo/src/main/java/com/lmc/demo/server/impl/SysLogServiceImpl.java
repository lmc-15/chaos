/*
* @(#) CecProjectController.java 2018/09/18
*
* Copyright 2018 CEC(Fujian) Healthcare Big Data Operation Service Co., Ltd. All rights reserved.
*/
package com.lmc.demo.server.impl;


import com.lmc.demo.dao.SysLogDao;
import com.lmc.demo.entity.SysLog;
import com.lmc.demo.server.ISysLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

 /**
 *
 * @ClassName: SysLogServiceImpl
 * @Description: 登入日志 服务实现类
 * @author developer<developer@cecdat.com>
 * @date 2024-07-12
 *
 */
@Slf4j
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogDao, SysLog> implements ISysLogService {

}

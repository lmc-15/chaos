package com.dev.lock.executor;

import com.dev.lock.annotation.ChaosLock;
import com.dev.lock.interceptor.Function;


/**
 * @ClassDescription:
 * @JdkVersion: 1.8
 * @Author: lmc
 * @email: mingchao.liu@greatdb.com
 * @Created: 2024/7/13 16:21
 */
public interface LockExecutor {
    Object execute(ChaosLock lock, Function function);
}

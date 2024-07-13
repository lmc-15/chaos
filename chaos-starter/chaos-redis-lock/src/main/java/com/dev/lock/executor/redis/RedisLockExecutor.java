package com.dev.lock.executor.redis;

import com.dev.context.util.SpringBootBeanUtil;
import com.dev.lock.annotation.ChaosLock;
import com.dev.lock.executor.LockExecutor;
import com.dev.lock.interceptor.Function;
import com.dev.redis.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassDescription:
 * @JdkVersion: 1.8
 * @Author: lmc
 * @email: mingchao.liu@greatdb.com
 * @Created: 2024/7/13 16:30
 */
public class RedisLockExecutor implements LockExecutor {
    private static final Logger log = LoggerFactory.getLogger(RedisLockExecutor.class);
    private static final RedisUtils REDIS_UTIL = SpringBootBeanUtil.getBean(RedisUtils.class);
    @Override
    public Object execute(ChaosLock lock, Function function) {
        String value = "";
        try {
            value = REDIS_UTIL.tryRedisLock(lock.name(),lock.acquireTimeout(),lock.expire());
            log.info("[{}]开始上锁",lock.name());
            return function.apply();
        } finally {
            REDIS_UTIL.unlockRedisLock(lock.name(), value);
            log.info("[{}]释放锁",lock.name());
        }
    }
}

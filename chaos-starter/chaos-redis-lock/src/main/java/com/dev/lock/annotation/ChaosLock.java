package com.dev.lock.annotation;

import com.dev.lock.executor.LockExecutor;
import com.dev.lock.executor.redis.RedisLockExecutor;

import java.lang.annotation.*;

/**
 * @ClassDescription:
 * @JdkVersion: 1.8
 * @Author: lmc
 * @email: mingchao.liu@greatdb.com
 * @Created: 2024/7/13 16:09
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface ChaosLock {
    String name() default"";

    Class<? extends LockExecutor> executor() default RedisLockExecutor.class;

    String[] keys() default{""};

    int expire() default -1;

    long acquireTimeout()default-1L;

    boolean autoRelease() default true;
}

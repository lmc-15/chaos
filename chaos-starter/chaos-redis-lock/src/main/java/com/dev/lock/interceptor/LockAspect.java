package com.dev.lock.interceptor;

import com.dev.lock.annotation.ChaosLock;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassDescription:
 * @JdkVersion: 1.8
 * @Author: lmc
 * @email: mingchao.liu@greatdb.com
 * @Created: 2024/7/6 10:38
 */
@Aspect
@Component
public class LockAspect {
    private final RedisProperties redisProperties;

    public LockAspect(RedisProperties redisProperties) {
        this.redisProperties = redisProperties;
    }


    @Pointcut("@annotation(com.dev.lock.annotation.ChaosLock)")
    public void lockPointcut() {
    }

    @Around("lockPointcut()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        int code = 0;
        String msg = "";
        // 获取方法签名
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();

        ChaosLock lock = method.getAnnotation(ChaosLock.class);
        return lock.executor().newInstance().execute(lock, () -> {
            try {
                return joinPoint.proceed();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        });
    }

}

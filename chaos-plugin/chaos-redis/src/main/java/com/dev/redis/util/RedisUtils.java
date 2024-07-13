/*
 * @(#) RedisUtils.java 2018/09/18
 *
 * Copyright 2018 CEC(Fujian) Healthcare Big Data Operation Service Co., Ltd. All rights reserved.
 */
package com.dev.redis.util;

import com.dev.core.ids.Ids;
import com.dev.core.util.CollUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.TimeoutUtils;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.Collectors;

import static com.dev.core.constant.GlobalConstants.REDIS_DELIMITER;


/**
 * redis 工具类
 *
 * @author dengrijin
 * @author Siu
 * @version v1.1 2021/01/25
 * @since JDK1.8
 */
@Component
public class RedisUtils {

    private static final Logger log = LoggerFactory.getLogger(RedisUtils.class);

    private String prefix;


    protected RedisTemplate<String, Object> redisTemplate;


    protected StringRedisTemplate stringRedisTemplate;



    /**
     * 批量删除对应的value
     *
     * @param keys 关键字
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern 正则匹配
     */
    public void removePattern(final String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        if (!CollectionUtils.isEmpty(keys)) {
            redisTemplate.delete(keys);
        }
    }

    /**
     * 删除对应的value
     *
     * @param key 关键字
     * @return
     * @throws
     */
    public void remove(final String key) {
        if (exists(key)) {
            Boolean res = redisTemplate.delete(getRealKey(key));
            log.debug("redis Delete, key:{},res:{}", key, res);
        }
    }


    /**
     * 删除对应的value,与remove区别是不会阻塞
     *
     * @param key 关键字
     * @return
     * @throws
     */
    public Boolean unlink(String key) {
        return redisTemplate.unlink(getRealKey(key));
    }


    public Long unlink(Collection<String> keys) {
        return redisTemplate.unlink(keys.stream().map(this::getRealKey).collect(Collectors.toList()));
    }

    private String getRealKey(String key) {
        return prefix + REDIS_DELIMITER + key;
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key 关键字
     * @return true/false
     */
    public boolean exists(final String key) {

        return CollUtil.getOrDefault(redisTemplate.hasKey(getRealKey(key)), false);

    }

    /**
     * 读取缓存
     *
     * @param key 关键字
     * @return Object 对象
     */
    public Object get(final String key) {
        Object result;
        result = redisTemplate.opsForValue().get(getRealKey(key));
        return result;
    }

    /**
     * 写入缓存，不过期
     *
     * @param key   关键字
     * @param value 值
     * @return true/false
     */
    public boolean set(final String key, Object value) {
        try {
            redisTemplate.opsForValue().set(getRealKey(key), value);
            return true;
        } catch (Exception e) {
            log.error("写入redis失败,{},error:", key, e);
            return false;
        }
    }

    /**
     * 写入缓存，设置过期时间
     *
     * @param key        关键字
     * @param value      值
     * @param expireTime 时间间隔（单位：秒）
     * @return true/false
     */
    public boolean set(final String key, Object value, Long expireTime) {
        try {
            redisTemplate.opsForValue().set(getRealKey(key), value, expireTime, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            log.error("写入redis失败,{},error:", key, e);
            return false;
        }

    }

    /**
     * 写入缓存
     *
     * @param key        关键字
     * @param value      值
     * @param expireDate 过期时间戳
     * @return true/false
     */
    public boolean set(final String key, Object value, Date expireDate) {
        try {
            redisTemplate.opsForValue().set(getRealKey(key), value);
            redisTemplate.expireAt(getRealKey(key), expireDate);
            return true;
        } catch (Exception e) {
            log.error("写入redis失败,{},error:", key, e);
            return false;
        }
    }

    /**
     * 写入数据，value为map
     *
     * @param key   关键字
     * @param value 集合对象
     * @return true/false
     */
    public boolean hmset(String key, Map<String, String> value) {
        boolean result = false;
        try {
            redisTemplate.opsForHash().putAll(getRealKey(key), value);
            result = true;
        } catch (Exception e) {
            log.error("写入redis失败,{},error:", key, e);
        }
        return result;
    }

    /**
     * 读取hashMap
     *
     * @param key 关键字
     * @return map对象
     */
    public Map<Object, Object> hmget(String key) {
        Map<Object, Object> result = null;
        try {
            result = redisTemplate.opsForHash().entries(getRealKey(key));
        } catch (Exception e) {
            log.error("获取redis失败,{},error:", key, e);
        }
        return result;
    }

    /**
     * 从redis中取出值
     *
     * @param key
     * @return 字符串
     */
    public String getString(String key) {
        if (CollUtil.isEmpty(key)) {
            return null;
        }
        return stringRedisTemplate.opsForValue().get(getRealKey(key));
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean setString(final String key, String value) {
        boolean result = false;
        try {
            stringRedisTemplate.opsForValue().set(getRealKey(key), value);
            result = true;
        } catch (Exception e) {
            log.error("设置redis失败,{},error:", key, e);
        }
        return result;
    }

    /**
     * 写入缓存，设置过期时间
     *
     * @param key
     * @param value
     * @param expireTime 时间间隔（单位：秒）
     * @return
     */
    public boolean setString(final String key, String value, Long expireTime) {
        boolean result = false;
        try {
            stringRedisTemplate.opsForValue().set(getRealKey(key), value, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            log.error("设置redis失败,{},error:", key, e);
        }
        return result;
    }

    /**
     * 设置过期时间
     *
     * @param key
     * @param timeout
     * @param timeUnit 过期时间戳
     * @return
     */
    public boolean setExpire(String key, long timeout, TimeUnit timeUnit) {
        boolean result = false;
        try {
            redisTemplate.expire(getRealKey(key), timeout, timeUnit);
            result = true;
        } catch (Exception e) {
            log.error("设置redis失败,{},error:", key, e);
        }
        return result;
    }

    /**
     * 设置过期时间
     *
     * @param key
     * @param expireTime 过期时间间隔
     * @return
     * @throws
     */
    public void setExpire(String key, Long expireTime) {
        redisTemplate.expire(getRealKey(key), expireTime, TimeUnit.SECONDS);
    }

    /**
     * 获取过期时间
     *
     * @param key 键
     * @return
     * @throws
     */
    public Long getExpire(String key) {
        Long result = 0L;
        try {
            result = redisTemplate.getExpire(getRealKey(key));
        } catch (Exception e) {
            log.error("获取redis失败,{},error:", key, e);
        }
        return result;
    }

    /**
     * 从左边添加对象
     *
     * @param key   列表名称
     * @param value 对象
     * @return
     * @throws
     */
    public boolean leftPush(String key, Object value) {
        boolean result = false;
        try {
            redisTemplate.opsForList().leftPush(getRealKey(key), value);
            result = true;
        } catch (Exception e) {
            log.error("获取redis失败,{},error:", key, e);
        }
        return result;
    }

    /**
     * 从右边添加对象
     *
     * @param key   列表名称
     * @param value 对象
     * @return
     * @throws
     */
    public boolean rightPush(String key, Object value) {
        boolean result = false;
        try {
            redisTemplate.opsForList().rightPush(getRealKey(key), value);
            result = true;
        } catch (Exception e) {
            log.error("获取redis失败,{},error:", key, e);
        }
        return result;
    }


    /**
     * 从左边抛出
     *
     * @param
     * @return
     * @throws
     */
    public Object listLeftPop(String key) {
        Object result = null;
        try {
            result = redisTemplate.opsForList().leftPop(getRealKey(key));
        } catch (Exception e) {
            log.error("获取redis失败,{},error:", key, e);
        }
        return result;
    }

    /**
     * 从右边抛出
     *
     * @param
     * @return
     * @throws
     */
    public Object listRightPop(String key) {
        Object result = null;
        try {
            result = redisTemplate.opsForList().rightPop(getRealKey(key));
        } catch (Exception e) {
            log.error("获取redis失败,{},error:", key, e);
        }
        return result;
    }

    /**
     * 返回列表长度
     *
     * @param key 关键字
     * @return
     * @throws
     */
    public long listSize(String key) {
        try {
            return stringRedisTemplate.opsForList().size(getRealKey(key));
        } catch (Exception e) {
            log.error("获取redis失败,{},error:", key, e);
            return -1;
        }
    }

    /**
     * @param script     脚本
     * @param returnType 返回类型
     * @param keys       key列表
     * @param values     参数值
     * @param <T>
     * @return
     */
    public <T> T runLuaScript(String script, Class<T> returnType, List<String> keys, Object... values) {
        DefaultRedisScript<T> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptText(script);
        redisScript.setResultType(returnType);
        return stringRedisTemplate.execute(redisScript, keys.stream().map(this::getRealKey).collect(Collectors.toList()), values);
    }

    /**
     * @param fileClasspath 脚本路径
     * @param returnType    返回类型
     * @param keys          key列表
     * @param values        参数值
     * @param <T>
     * @return
     */
    public <T> T runLua(String fileClasspath, Class<T> returnType, List<String> keys, Object... values) {
        DefaultRedisScript<T> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource(fileClasspath)));
        redisScript.setResultType(returnType);
        return stringRedisTemplate.execute(redisScript, keys.stream().map(this::getRealKey).collect(Collectors.toList()), values);
    }


    /**
     * Executes the given action object within a connection that can be exposed or not. Additionally, the connection can
     * be pipelined. Note the results of the pipeline are discarded (making it suitable for write-only scenarios).
     *
     * @param <T>              return type
     * @param action           callback object to execute
     * @param exposeConnection whether to enforce exposure of the native Redis Connection to callback code
     * @param pipeline         whether to pipeline or not the connection for the execution
     * @return object returned by the action
     */
    public <T> T execute(RedisCallback<T> action, boolean exposeConnection, boolean pipeline) {
        return redisTemplate.execute(action, exposeConnection, pipeline);
    }

    /**
     * Executes the given action object within a connection, which can be exposed or not.
     *
     * @param <T>              return type
     * @param action           callback object that specifies the Redis action
     * @param exposeConnection whether to enforce exposure of the native Redis Connection to callback code
     * @return object returned by the action
     */
    public <T> T execute(RedisCallback<T> action, boolean exposeConnection) {
        return redisTemplate.execute(action, exposeConnection);
    }


    /**
     * @param action
     * @param <T>
     * @return
     * @see org.springframework.data.redis.core.RedisOperations#execute(org.springframework.data.redis.core.RedisCallback)
     */
    public <T> T execute(RedisCallback<T> action) {
        return redisTemplate.execute(action);
    }


    /**
     * 获取锁
     *
     * @param lockId  lockName
     * @param timeout 获取锁的超时时间
     * @param expire  锁过期时间（秒）,默认 Integer.MAX_VALUE
     * @return
     */
    public String tryRedisLock(String lockId, long timeout, int expire) {
        final long startMillis = System.currentTimeMillis();
        final long millisToWait = timeout < 0 ? Long.MAX_VALUE : timeout;
        while (true) {
            String lockValue = tryRedisLock(lockId, expire <= 0 ? Integer.MAX_VALUE : expire, TimeUnit.SECONDS);
            if (lockValue != null) {
                return lockValue;
            }
            // 重试等待时间
            int retryAwait = 300;
            if (System.currentTimeMillis() - startMillis - retryAwait > millisToWait) {
                break;
            }
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(retryAwait));
        }
        return null;
    }

    /**
     * 获取锁
     *
     * @param lockId lockName
     * @param expire 锁过期时间（秒）
     * @return
     */
    private String tryRedisLock(String lockId, int expire) {
        String luaScript = "\nlocal r = tonumber(redis.call('SETNX', KEYS[1],ARGV[1]));"
                + "\nredis.call('EXPIRE',KEYS[1],ARGV[2]);"
                + "\nreturn r";

        List<String> keys = new ArrayList<>();
        keys.add(lockId);
        String value = Ids.randomId(10);

        Long ret = runLuaScript(luaScript, Long.class, keys, value, String.valueOf(expire));

        if (new Long(1).equals(ret)) {
            return value;
        }

        return null;
    }

    /**
     * 获取锁
     *
     * @param lockId lockName
     * @param expire 锁过期时间（秒）
     * @return
     */
    private String tryRedisLock(String lockId, int expire, TimeUnit timeUnit) {
        String luaScript = "\nlocal r = tonumber(redis.call('SETNX', KEYS[1],ARGV[1]));"
                + "\nredis.call('EXPIRE',KEYS[1],ARGV[2]);"
                + "\nreturn r";

        List<String> keys = new ArrayList<>();
        keys.add(lockId);
        String value = Ids.randomId(10);

        Long ret = runLuaScript(luaScript, Long.class, keys, value, Long.toString(TimeoutUtils.toSeconds(expire, timeUnit)));

        if (new Long(1).equals(ret)) {
            return value;
        }

        return null;
    }


    /**
     * 释放锁
     *
     * @param key   lockName
     * @param value lock 中保存的值
     * @return
     */
    public boolean unlockRedisLock(String key, String value) {
        String luaScript = "\nlocal v = redis.call('GET', KEYS[1]);"
                + "\nlocal r= 0;"
                + "\nif v == ARGV[1] then"
                + "\nr =redis.call('DEL',KEYS[1]);"
                + "\nend"
                + "\nreturn r";
        List<String> keys = new ArrayList<>();
        keys.add(key);

        Long ret = runLuaScript(luaScript, Long.class, keys, value);

        return new Long(1).equals(ret);
    }

    /**
     * key和value都一致时，设置过期时间
     *
     * @param key
     * @param value
     * @param timeout  过期时间戳
     * @param timeUnit 过期时间戳
     * @return 返回{@code true}设置过期时间成功，返回{@code false}设置过期时间失败
     */
    public boolean setExpire(String key, String value, long timeout, TimeUnit timeUnit) {
        String luaScript = "\nlocal v = redis.call('GET', KEYS[1]);"
                + "\nlocal r= 0;"
                + "\nif v == ARGV[1] then"
                + "\nr =redis.call('EXPIRE',KEYS[1],ARGV[2]);"
                + "\nend"
                + "\nreturn r";
        List<String> keys = new ArrayList<>();
        keys.add(key);
        Long ret = runLuaScript(luaScript, Long.class, keys, value, Long.toString(TimeoutUtils.toSeconds(timeout, timeUnit)));
        return 1 == ret;
    }
    /**
     * 标记：当前 redis 连接信息是否已初始化成功
     */
    public boolean isInit = false;
    @Autowired
    public void init(RedisConnectionFactory connectionFactory) {
        // 如果已经初始化成功了，就立刻退出，不重复初始化
        if(this.isInit) {
            return;
        }

        // 指定相应的序列化方案
        StringRedisSerializer keySerializer = new StringRedisSerializer();
        JdkSerializationRedisSerializer valueSerializer = new JdkSerializationRedisSerializer();

        // 构建StringRedisTemplate
        StringRedisTemplate stringTemplate = new StringRedisTemplate();
        stringTemplate.setConnectionFactory(connectionFactory);
        stringTemplate.afterPropertiesSet();


        // 开始初始化相关组件
        this.stringRedisTemplate = stringTemplate;

        // 打上标记，表示已经初始化成功，后续无需再重新初始化
        this.isInit = true;
        this.prefix = "chaos";
    }

}
package com.dev.core.dlock;


import com.dev.core.dlock.entity.Lock;

/**
 * @author Siu
 * @version 0.0.1
 * @date 2020/12/25 9:32
 */
public interface IDistributedLockService {


    /**
     * 获取锁
     *
     * @param lockName 锁的路径/标识
     * @return 锁对象
     */
    Lock newLock(String lockName);


    /**
     * 获取锁
     *
     * @param lock 锁的路径/标识
     * @return
     */
    @Deprecated
    boolean tryLock(Lock lock);


    /**
     * 获取锁
     *
     * @param lock             锁的路径/标识
     * @param acquireTimeoutMs 获取锁的超时时间（毫秒，小于等于0时，代表不断尝试获取锁，直到成功获取锁）
     * @return
     */
    @Deprecated
    boolean tryLock(Lock lock, long acquireTimeoutMs);


    /**
     * 获取锁
     *
     * @param lock              锁
     * @param acquireTimeoutMs  获取锁的超时时间（毫秒，小于等于0时，代表不断尝试获取锁，直到成功获取锁）
     * @param lockExpireSeconds 锁的过期时间（大于0时有效，小于等于0未启用过期）
     * @return
     */
    @Deprecated
    boolean tryLock(Lock lock, long acquireTimeoutMs, int lockExpireSeconds);


    /**
     * 释放锁
     *
     * @param lock 锁对象
     * @return
     */
    @Deprecated
    boolean unlock(Lock lock);

    /**
     * 获取锁
     * <p>未获取到锁立即返回，不等待</p>
     * <p>默认锁无过期时间，永久持有</p>
     *
     * @param lockName 锁的路径/标识
     * @return
     */
    boolean tryLock(String lockName);

    /**
     * 获取锁
     * <p>默认锁无过期时间，永久持有</p>
     *
     * @param lockName         锁的路径/标识
     * @param acquireTimeoutMs 获取锁的超时时间（毫秒，小于0时，代表不断尝试获取锁，直到成功获取锁，等于0代表未获取到锁立即返回）
     * @return
     */
    boolean tryLock(String lockName, long acquireTimeoutMs);

    /**
     * 获取锁
     *
     * @param lockName          锁的路径/标识
     * @param acquireTimeoutMs  获取锁的超时时间（毫秒，小于0时，代表不断尝试获取锁，直到成功获取锁，等于0时，代表未获取到锁立即返回）
     * @param lockExpireSeconds 锁过期时间
     * @return
     */
    boolean tryLock(String lockName, long acquireTimeoutMs, int lockExpireSeconds);

    /**
     * 释放锁
     *
     * @param lockName 锁对象
     * @return
     */
    boolean unlock(String lockName);

}

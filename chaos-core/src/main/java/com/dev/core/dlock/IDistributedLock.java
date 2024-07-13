package com.dev.core.dlock;

/**
 * 分布式锁接口
 *
 * @author liaochunshui
 * @version 1.1 2021/1/27
 */
public interface IDistributedLock {

    /**
     * 获取锁
     * <p>未获取到锁立即返回，不等待</p>
     *
     * @return
     */
    boolean tryLock();

    /**
     * 获取锁
     *
     * @param acquireTimeoutMs 获取锁的超时时间（毫秒，小于0时，代表不断尝试获取锁，直到成功获取锁，等于0时，代表未获取到则立即返回）
     * @return
     */
    boolean tryLock(long acquireTimeoutMs);

    /**
     * 释放锁
     *
     * @return
     */
    boolean unlock();

}

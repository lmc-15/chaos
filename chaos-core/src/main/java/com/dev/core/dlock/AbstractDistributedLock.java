package com.dev.core.dlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 分布式锁抽象类
 *
 * @author liaochunshui
 * @version 1.1 2021/1/27
 */
public abstract class AbstractDistributedLock implements IDistributedLock {

    /**
     * key-线程名称，value-锁对象
     */
    private static final Map<Thread, Map<String, AbstractDistributedLock>> DISTRIBUTED_LOCK_CONTAINS = new ConcurrentHashMap<>();

    /**
     * 锁的路径/标识
     */
    protected final String name;

    /**
     * 获取的锁对象
     */
    protected Object lockData;

    /**
     * 锁计数器：当前线程获得锁次数
     */
    protected AtomicInteger lockCount;

    public AbstractDistributedLock(String name) {
        this.name = name;
    }

    public Object getLockData() {
        return lockData;
    }

    public void setLockData(Object lockData) {
        this.lockData = lockData;
    }

    public String getName() {
        return name;
    }

    public int getLockCount() {
        return lockCount.get();
    }

    /**
     * 当前线程是否持有该锁
     *
     * @return
     */
    protected boolean isHold() {
        return AbstractDistributedLock.getCurrentThreadDistributedLock(this.name) != null;
    }

    /**
     * 线程是否持有该锁
     *
     * @param thread 线程对象
     * @return
     */
    protected boolean isHold(Thread thread) {
        return AbstractDistributedLock.getDistributedLock(thread, this.name) != null;
    }

    /**
     * 增加持有锁
     * <p>将锁添加到当前线程中</p>
     * <p>锁计数器初始化为1，每调用1次新增1</p>
     */
    protected void incrementHold() {
        AbstractDistributedLock.putCurrentThreadDistributedLock(this);
        if (this.lockCount == null || this.lockCount.get() <= 0) {
            this.lockCount = new AtomicInteger(1);
        } else {
            this.lockCount.incrementAndGet();
        }
    }

    /**
     * 减少持有锁
     * <p>当持有锁数量小于等于0时，将锁从本地线程中移除</p>
     */
    protected void decrementHold() {
        if (this.lockCount.decrementAndGet() <= 0) {
            AbstractDistributedLock.removeCurrentThreadDistributedLock(this.name);
        }
    }

    /**
     * 设置不持有锁
     */
    protected void setNotHold() {
        AbstractDistributedLock.removeCurrentThreadDistributedLock(this.name);
    }

    /**
     * 添加当前线程分布式锁
     *
     * @param distributedLock 分布式锁
     */
    protected static void putCurrentThreadDistributedLock(AbstractDistributedLock distributedLock) {
        if (distributedLock != null) {
            Map<String, AbstractDistributedLock> distributedLockMap = AbstractDistributedLock.DISTRIBUTED_LOCK_CONTAINS.computeIfAbsent(Thread.currentThread(), k -> new HashMap<>());
            distributedLockMap.putIfAbsent(distributedLock.getName(), distributedLock);
        }
    }

    /**
     * 移除当前线程lockName分布式锁
     */
    protected static void removeCurrentThreadDistributedLock(String lockName) {
        Map<String, AbstractDistributedLock> distributedLockMap = AbstractDistributedLock.DISTRIBUTED_LOCK_CONTAINS.get(Thread.currentThread());
        if (distributedLockMap != null && !distributedLockMap.isEmpty()) {
            distributedLockMap.remove(lockName);
        }
        if (distributedLockMap != null && distributedLockMap.isEmpty()) {
            AbstractDistributedLock.DISTRIBUTED_LOCK_CONTAINS.remove(Thread.currentThread());
        }
    }

    /**
     * 获取当前线程分布式锁对象
     *
     * @return 返回分布式锁
     */
    public static AbstractDistributedLock getCurrentThreadDistributedLock(String lockName) {
        return getDistributedLock(Thread.currentThread(), lockName);
    }

    /**
     * 获取当前线程分布式锁对象
     *
     * @return 返回分布式锁
     */
    public static AbstractDistributedLock getDistributedLock(Thread thread, String lockName) {
        Map<String, AbstractDistributedLock> distributedLockMap = AbstractDistributedLock.DISTRIBUTED_LOCK_CONTAINS.get(thread);
        if (distributedLockMap != null && !distributedLockMap.isEmpty()) {
            return distributedLockMap.get(lockName);
        } else {
            return null;
        }
    }

}

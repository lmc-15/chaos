package com.dev.core.dlock.entity;

/**
 * @author Siu
 * @date 2020/12/25 9:30
 * @version 0.0.1
 */
public class Lock {

    /**
     * 锁的路径/标识
     */
    private final String name;

    /**
     * 获取的锁对象
     */
    private Object lock;

    /**
     * 是否获得锁成功
     */
    private boolean success;


    public Lock(String name) {
        this.name = name;
    }

    public Object getLock() {
        return lock;
    }

    public void setLock(Object lock) {
        this.lock = lock;
    }

    public boolean isSuccess() {
        return success;
    }

    public void success() {
        this.success = true;
    }

    public String getName() {
        return name;
    }
}

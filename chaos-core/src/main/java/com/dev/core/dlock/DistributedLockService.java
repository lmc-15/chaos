package com.dev.core.dlock;


import com.dev.core.dlock.entity.Lock;

/**
 * @author Siu
 * @version v1.1
 * @date 2021/1/25
 */
public class DistributedLockService implements IDistributedLockService {

    IDistributedLockService distributedLock;


    public DistributedLockService(IDistributedLockService distributedLock) {
        this.distributedLock = distributedLock;
    }

    @Override
    public Lock newLock(String lockName) {

        return distributedLock.newLock(lockName);
    }

    @Deprecated
    public boolean lock(Lock lock) {
        return distributedLock.tryLock(lock);
    }

    @Override
    public boolean tryLock(Lock lock, long acquireTimeoutMs) {
        return distributedLock.tryLock(lock, acquireTimeoutMs);
    }

    @Override
    public boolean tryLock(Lock lock, long acquireTimeoutMs, int lockExpireSeconds) {
        return false;
    }

    @Override
    public boolean tryLock(Lock lock) {
        return distributedLock.tryLock(lock);
    }

    @Override
    public boolean unlock(Lock lock) {
        return distributedLock.unlock(lock);
    }

    @Override
    public boolean tryLock(String lockName) {
        return distributedLock.tryLock(lockName);
    }

    @Override
    public boolean tryLock(String lockName, long acquireTimeoutMs) {
        return distributedLock.tryLock(lockName, acquireTimeoutMs);
    }

    @Override
    public boolean tryLock(String lockName, long acquireTimeoutMs, int lockExpireSeconds) {
        return distributedLock.tryLock(lockName, acquireTimeoutMs, lockExpireSeconds);
    }

    @Override
    public boolean unlock(String lockName) {
        return distributedLock.unlock(lockName);
    }


}

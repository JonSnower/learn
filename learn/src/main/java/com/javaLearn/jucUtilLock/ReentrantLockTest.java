package com.javaLearn.jucUtilLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 */
public class ReentrantLockTest {

    // fair:true,设置公平锁，默认非公平
    Lock lock = new ReentrantLock(true);


    void m1() {
        boolean isLocked = false;
        try {
            // 尝试在3秒内拿到锁
            isLocked = lock.tryLock(3, TimeUnit.SECONDS);
            System.out.println("do some thing");
            Thread.sleep(1000);
        } catch (Exception e) {
         } finally {
            // 释放锁
            if (isLocked) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        new Thread(reentrantLockTest::m1, "").start();
        new Thread(reentrantLockTest::m1, "").start();
    }

}

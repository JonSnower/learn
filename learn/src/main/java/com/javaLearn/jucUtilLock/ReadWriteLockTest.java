package com.javaLearn.jucUtilLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁，读写锁分离，效率高
 */
public class ReadWriteLockTest {

    private static ReadWriteLock lock = new ReentrantReadWriteLock();
    // 读锁
    private static Lock rLock = lock.readLock();
    // 写锁
    private static Lock wLock = lock.writeLock();

    static void read() {
        try {
            rLock.lock();
            Thread.sleep(1000);
            System.out.println("read over");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rLock.unlock();
        }
    }

    static void write() {
        try {
            wLock.lock();
            Thread.sleep(1000);
            System.out.println("write over");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            wLock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        // 执行完只需要一秒
        for (int i = 0; i < 10; i++) {
            new Thread(ReadWriteLockTest::read).start();
        }
        // 执行完需要二秒
        for (int i = 0; i < 2; i++) {
            new Thread(ReadWriteLockTest::write, "").start();
        }
    }


}

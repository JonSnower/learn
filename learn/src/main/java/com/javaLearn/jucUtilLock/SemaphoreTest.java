package com.javaLearn.jucUtilLock;

import java.util.concurrent.Semaphore;

/**
 * 信号：限流，控制执行线程数量
 */
public class SemaphoreTest {


    public static void main(String[] args) {

        // 同时只能有两个线程拿到锁
        Semaphore semaphore = new Semaphore(2);

        new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("t1 running");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }, "").start();

        new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("t2 running");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }, "").start();

        new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("t3 running");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }, "").start();

    }

}



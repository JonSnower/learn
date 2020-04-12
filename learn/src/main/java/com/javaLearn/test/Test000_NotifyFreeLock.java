package com.javaLearn.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 两个线程：一个线程往容器中加数据，当容器大小为5时另外一个线程输出
 */
public class Test000_NotifyFreeLock {

    private List<Object> list = new ArrayList<>();

    private void add(Object object) {
        list.add(object);
    }

    private int size() {
        return list.size();
    }

    private final static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        Test000_NotifyFreeLock c = new Test000_NotifyFreeLock();

        new Thread(() -> {
            synchronized (lock) {
                try {
                    // 先阻塞，等待其它线程通知
                    lock.wait();
                    if (c.size() == 5) {
                        System.out.println("t1开始执行。。。");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 通知其它线程继续执行
                lock.notify();
            }
        }, "t1").start();

        // 让t1先执行
        Thread.sleep(1000);

        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    c.add(new Object());
                    if (c.size() == 5) {
                        // 通知其它线程开始执行,但不释放锁
                        lock.notify();
                        try {
                            // 当前线程阻塞，并释放锁
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(c.size());
                }
            }
        }, "t1").start();


    }

}

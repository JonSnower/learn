package com.javaLearn.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者与消费者
 */
public class Test011_MyContainer {

    // 容器
    private static List<String> container = new ArrayList<>();

    private final int MAX_SIZE = 10;

    private static ReentrantLock lock = new ReentrantLock();
    // 本质上就是两个等待对列,可以精确的对线程进行操作
    private static Condition consumer = lock.newCondition();
    private static Condition producer = lock.newCondition();

    // 增加
    private void put(String str) {
        try {
            lock.lock();
            // 用while是因为当前线程被叫醒后，再判断一次，如果不等于MAX_SIZE则还需要继续等待消费者消费
            while (container.size() == MAX_SIZE) {
                try {
                    producer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            container.add(str);
            System.out.println("生产者生产：当前容量：" + container.size());
            // 通知消费者消费
            consumer.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 取出
    private synchronized void get() {
        try {
            lock.lock();
            // 用while是因为当前线程被叫醒后，再判断一次，如果容器还是空的，需要生产者进行生产
            while (container.size() == 0) {
                try {
                    consumer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            container.remove(0);
            System.out.println("消费者消费：容量：" + container.size());
            // 通知生产者生产
            producer.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {

        // 生产线程
        Test011_MyContainer container = new Test011_MyContainer();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                container.put("");
            }).start();
        }

        // 消费线程
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                container.get();
            }).start();
        }

    }


}

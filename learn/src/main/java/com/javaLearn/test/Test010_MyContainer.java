package com.javaLearn.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产者与消费者
 */
public class Test010_MyContainer {

    // 容器
    private List<String> container = new ArrayList<>();

    private final int MAX_SIZE = 10;

    // 增加
    private synchronized void put(String str) {
        // 用while是因为当前线程被叫醒后，再判断一次，如果不等于MAX_SIZE则还需要继续等待消费者消费
        while (container.size() == MAX_SIZE) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        container.add(str);
        System.out.println("生产者生产：当前容量：" + container.size());
        this.notifyAll();
    }

    // 取出
    private synchronized void get() {
        // 用while是因为当前线程被叫醒后，再判断一次，如果容器还是空的，需要生产者进行生产
        while (container.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        container.remove(0);
        System.out.println("消费者消费：容量：" + container.size());
        this.notifyAll();
    }

    public static void main(String[] args) {

        // 生产线程
        Test010_MyContainer container = new Test010_MyContainer();
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

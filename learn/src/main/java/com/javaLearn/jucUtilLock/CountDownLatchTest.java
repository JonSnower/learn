package com.javaLearn.jucUtilLock;

import java.util.concurrent.CountDownLatch;

/**
 * 倒数门栓：归零执行
 */
public class CountDownLatchTest {

    static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                // 执行一次countDown
                countDownLatch.countDown();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "").start();
        }

        try {
            // 阻塞，执行完countDown后，继续执行
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("done");
    }

}

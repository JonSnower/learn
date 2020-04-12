package com.javaLearn.jucUtilLock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环栅栏：满多少，就执行
 */
public class CyclicBarrierTest {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println("do something");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "").start();
            Thread.sleep(1000);
        }

        System.out.println("done");

    }

}

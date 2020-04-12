package com.javaLearn.jucUtilLock;


import java.util.concurrent.Exchanger;

/**
 * 交换：两个线程间数据交换
 */
public class ExchangerTest {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(() -> {
            String o = null;
            try {
                // 阻塞，等待另一个线程交换数据
                o = exchanger.exchange("t1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "/" + o);
        }, "t1").start();

        new Thread(() -> {
            String o = null;
            try {
                // 阻塞，等待另一个线程交换数据
                o = exchanger.exchange("t2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "/" + o);
        }, "t2").start();

    }

}

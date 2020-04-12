package com.javaLearn.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * 两个线程：一个线程往容器中加数据，当容器大小为5时另外一个线程输出
 */
public class Test001_LockSupport {

    private List<Object> list = new ArrayList<>();

    private void add(Object object) {
        list.add(object);
    }

    private int size() {
        return list.size();
    }

    private static Thread t1 = null, t2 = null;

    public static void main(String[] args) {

        Test001_LockSupport c = new Test001_LockSupport();

        t1 = new Thread(() -> {
            // 先阻塞，等待其它线程通知
            LockSupport.park(t1);
            System.out.println("t1开始执行。。。");
            // t1执行完成后，t2还需要继续执行
            LockSupport.unpark(t2);
        }, "t1");


        t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                if (c.size() == 5) {
                    // 满足条件后，让t1执行，t2等待
                    LockSupport.unpark(t1);
                    LockSupport.park(t2);
                }
                System.out.println(c.size());
            }
        }, "t2");

        t1.start();
        t2.start();

    }

}

package com.javaLearn.jucUtilLock;

/**
 * ThreadLocal中的数据，不会被其它线程共享，本质是上是因为保存在当前线程中
 */
public class ThreadLocalTest {

    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        new Thread(() -> {
            // set的时候设到了当前线程的map中（看源码）
            threadLocal.set("T1");
        }).start();

        new Thread(() -> {
            // 从当前线程的map中去get（看源码），因些取不到
            System.out.println(threadLocal.get());
        }).start();

    }

}

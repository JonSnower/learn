package com.javaLearn.container.collection.queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 有界队列
 */
public class ConcurrentLinkedQueueTest {


    public static void main(String[] args) {

        Queue<String> queue = new ConcurrentLinkedQueue<>();

        // 添加，有返回值，add添加失败会抛异常
        boolean b = queue.offer("q1");
        System.out.println("是否添加成功：" + b);

        // 取出数据，但数据还在Queue当中
        System.out.println("取出数据：" + queue.peek());

        // 取出数据，并且数据会从Queue中移除
        String out = queue.poll();
        System.out.println(out);


    }

}

package com.javaLearn.container.collection.queue.blocking;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 无界队列：可以一直装，只到内存满了为止，链表没有长度的限制
 */
public class LinkedBlockingQueueTest {


    public static void main(String[] args) {

        Queue<String> queue = new LinkedBlockingQueue<>();

        for (int i = 0; i < 1000; i++) {
            // 不会阻塞
            queue.offer("Q" + i);
        }

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    String tName = Thread.currentThread().getName();
                    // 不会阻塞
                    String str = queue.poll();
                    if (str == null) {
                        break;
                    }
                    System.out.println(tName + ",get:" + str);
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }

        LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
        try {
            // 如果加不进去（比如内在满了后）,线程阻塞，直到可以put数据
            blockingQueue.put("bq1");
            // 如果取不出数据，线程阻塞，直到可以取出数据
            blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

package com.javaLearn.container.collection.queue.blocking;

import java.util.concurrent.SynchronousQueue;

/**
 * 同步queue:size大小为0的queue
 */
public class SynchronousQueueTest {

    public static void main(String[] args) throws Exception {

        SynchronousQueue<String> queue = new SynchronousQueue<>();
        new Thread(() -> {
            String res = null;
            try {
                // 会一直阻塞，直到有线程来放数据
                res = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("result:" + res);
        }).start();

        Thread.sleep(3000);

        // 会一直阻塞，只到有线程来取数据
        queue.put("abc");
        System.out.println("queue size:" + queue.size());

    }

}

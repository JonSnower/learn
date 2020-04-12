package com.javaLearn.container.collection.queue.blocking;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 有界队列
 */
public class ArrayBlockingQueueTest {


    public static void main(String[] args) {

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

        for (int i = 0; i < 10; i++) {
            try {
                // 放不下会阻塞
                queue.put("q" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 10; i++) {
            try {
                // 取不出会阻塞
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}

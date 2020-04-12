package com.javaLearn.container.collection.queue.blocking;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * 交换阻塞对列
 */
public class TransferQueueTest {

    public static void main(String[] args) {

        TransferQueue<String> queue = new LinkedTransferQueue<>();

        new Thread(() -> {
            String res = null;
            try {
                res = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(res);
        }).start();

        try {
            // 阻塞，只到有线程取出
            queue.transfer("abc");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

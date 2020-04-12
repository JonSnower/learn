package com.javaLearn.container.collection.queue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 按序排列的queue
 */
public class PriorityQueueTest {

    public static void main(String[] args) {

        Queue<String> queue = new PriorityQueue<>();
        queue.offer("b");
        queue.offer("c");
        queue.offer("f");
        queue.offer("e");
        queue.offer("z");

        int size = queue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(queue.poll());
        }

    }

}

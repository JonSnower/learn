package com.javaLearn.container.collection.queue.blocking;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 按时间排序的阻塞queue
 */
public class DelayQueueTest {

    public static void main(String[] args) {

        DelayQueue<MyTask> delayQueue = new DelayQueue<>();

        MyTask delay1 = new MyTask("task1", 500);
        delayQueue.put(delay1);

        MyTask delay2 = new MyTask("task1",1000);
        delayQueue.put(delay2);

        int size = delayQueue.size();
        for (int i = 0; i < size; i++) {
            try {
                System.out.println(delayQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

class MyTask implements Delayed {

    private String name;
    private long runningTime;

    public MyTask(String name, long runningTime) {
        this.name = name;
        this.runningTime = runningTime;
    }

    @Override
    public String toString() {
        return "MyDelay{" +
                "name=" + name +
                ",runningTime=" + runningTime +
                '}';
    }

    @Override
    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(runningTime - System.currentTimeMillis(), timeUnit);
    }

    @Override
    public int compareTo(Delayed delayed) {
        long time = delayed.getDelay(TimeUnit.MILLISECONDS);
        if (this.getDelay(TimeUnit.MILLISECONDS) > delayed.getDelay(TimeUnit.MILLISECONDS)) {
            return 1;
        } else if (this.getDelay(TimeUnit.MILLISECONDS) < delayed.getDelay(TimeUnit.MILLISECONDS)) {
            return -1;
        }
        return 0;
    }
}
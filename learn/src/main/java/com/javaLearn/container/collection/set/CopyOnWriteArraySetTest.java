package com.javaLearn.container.collection.set;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 写时复制：写加锁，读不加锁，读的时候共享锁，写的时候排它锁
 * 用在读特别多，写比较少的情况
 */
public class CopyOnWriteArraySetTest {

    public static void main(String[] args) {
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
    }

}

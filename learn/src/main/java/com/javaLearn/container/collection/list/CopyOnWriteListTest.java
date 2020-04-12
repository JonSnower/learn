package com.javaLearn.container.collection.list;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 写时复制:写加锁，读不加锁，读的时候共享锁，写的时候排它锁
 * 用在读特别多，写比较少的情况
 */
public class CopyOnWriteListTest {


    public static void main(String[] args) {
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
    }

}

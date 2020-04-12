package com.javaLearn.container.map.cocurrent;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * ConcurrentSkipListMap:跳表结构，有序
 * 跳表结构就是在链表结构的基础上加了几层链表的关键元素，通过一层一层查找，因此在查找效率上比链表还要高
 */
public class ConcurrentSkipListMapTest {

    public static void main(String[] args) {
        ConcurrentSkipListMap map = new ConcurrentSkipListMap();
    }

}

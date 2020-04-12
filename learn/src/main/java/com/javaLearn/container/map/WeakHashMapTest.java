package com.javaLearn.container.map;

import java.util.WeakHashMap;

/**
 * 弱引用map,执行gc后,没有被引用指向的数据会被回收掉
 */
public class WeakHashMapTest {

    public static void main(String[] args) {

        String k1 = new String("k1");
        String k2 = new String("k2");

        WeakHashMap<String, String> map = new WeakHashMap<>();
        map.put(k1, "v1");
        map.put(k2, "v2");

        System.out.println("before:" + map);

        k1 = null;
        // 执行gc后,没有被引用指向的数据会被回收掉
        System.gc();

        System.out.println("after" + map);
    }

}

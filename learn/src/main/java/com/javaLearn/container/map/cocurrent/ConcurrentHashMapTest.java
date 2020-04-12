package com.javaLearn.container.map.cocurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap：无序
 * 多线程使用：读的效率高，写所效率可能还低一些
 * 没有ConcurrentTreeMap，有ConcurrentSkipListMap
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {

        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("", "");
        System.out.println(map);

    }

}

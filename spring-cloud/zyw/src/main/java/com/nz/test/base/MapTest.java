package com.nz.test.base;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    /**
     * 1、数组结构 2、链表结构 3、哈希表结构 = 数组 + 链表 4、JDK 1.8: 数组 + 链表 + 红黑树（链表长度超过阈值（8）时，将链表转换为红黑树）
     * key: hashCode 、 equals
     * HashMap（Entry数组来存储key-value对、Entry是个单向链表、16 、填充因子默认都是0.75、扩容时当前容量翻倍-capacity*2、对key的hashcode进行了二次hash）、
     * SortedMap 、 TreeMap 、 ConcurrentHashMap 、 Hashtable（synchronized）、IdentityHashMap
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * IdentityhashMap类利用哈希表实现Map接口,key(value)引用相等性替代对象相等性,kye(value)只比较两个key是否引用同一个对象,比较的是对象的地址
         * 字符串是放在常量池中的,str1和str2实际上还是同一个对象，所以它们的key值是相同的,会被覆盖；
         */
        String str1 = "key";
        String str2 = "key";
        System.out.println(str1 == str2);
        Map<String, Object> map1 = new IdentityHashMap<>();
        map1.put(str1, "a");
        map1.put(str2, "b");
        map1.forEach((k, v) -> System.out.println(k + "->" + v));

        /**
         * str1和str2是通过new的方式创建出来的,属于不同对象,所以它们的引用不同,key值也就不同,所以put的时候不会被覆盖
         */
        String str3 = new String("key");
        String str4 = new String("key");
        System.out.println(str3 == str4);
        Map<String, String> map2 = new IdentityHashMap<>();
        map2.put(str3, "value1");
        map2.put(str4, "value2");
        map2.forEach((k, v) -> System.out.println(k + "->" + v));

        /**
         * HashMap -> AbstractMap, 可以存储一个Key为null,多个value为null的元素,put -> hash(key): (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16)
         * 原因: key为null的键值对的hash为0,因此一个hashmap对象只会存储一个key为null的键值对,因为它们的hash值都相同
         */
        Map<String, Object> map3 = new HashMap<>();
        map3.put(null, null);
        map3.put("key1", null);
        map3.put("key2", UUID.randomUUID().toString());
        map3.forEach((k, v) -> System.out.println(k + "->" + v));

        /**
         * Hashtable -> Dictionary, put:
         * 1. if (value == null) {throw new NullPointerException();},所以Hashtable不能存储value为null的键值对
         * 2. int hash = key.hashCode(); 在此处计算key的hash值,如果此处key为null,则直接抛出空指针异常
         */
        Map<String, Object> map4 = new Hashtable<>();
        map4.put("key1", "value1");
        map4.forEach((k, v) -> System.out.println(k + "->" + v));

        /**
         * ConcurrentHashMap -> AbstractMap
         * 1. 在此处直接过滤掉key或value为null的情况, if (key == null || value == null) throw new NullPointerException();
         * 2. hash值采用了二次hash,使得hash值分布更均匀, int hash = spread(key.hashCode());
         */
        Map<String, Object> map5 = new ConcurrentHashMap<>();
        map5.put("key1", "value1");
        map5.forEach((k, v) -> System.out.println(k + "->" + v));
    }
}

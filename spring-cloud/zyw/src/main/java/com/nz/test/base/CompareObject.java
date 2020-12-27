package com.nz.test.base;

public class CompareObject {
    public static void main(String[] args) {

        /**
         * 若对象未被修改, 则多次调用hashCode返回同一整数;
         * 若a -eq b 为 true,  则a,b hashCode一定相等;   [相等的对象必须具有相等的散列码(hashCode)]
         * 若a -eq b 为 false, 则a,b hashCode不一定相等; [不相等的对象产生截然不同的整数结果,有可能提高散列表的性能]
         */

        String a = "abc";
        String b = "abc";
        System.out.println("eq:\t" + a.equals(b) + "\t" + a.hashCode() + "\t" + b.hashCode() + "\r\n");

        String c = new String("abc");
        String d = new String("abc");
        System.out.println("eq:\t" + c.equals(d) + "\t" + c.hashCode() + "\t" + d.hashCode() + "\r\n");

        System.out.println("eq:\t" + a.equals(c) + "\t" + a.hashCode() + "\t" + c.hashCode() + "\r\n");

        String e = new String("def");
        System.out.println("eq:\t" + a.equals(e) + "\t" + a.hashCode() + "\t" + e.hashCode() + "\r\n");

        /**
         * equals
         * 两个对象相等, hashcode一定相等
         * 两个对象不等, hashcode不一定不等
         * hashcode相等, 两个对象不一定相等
         * hashcode不等, 两个对象一定不等
         *
         * 先进行hashcode比较,如果不同,就没有必要进行equals比较
         */
        Object object = new Object();
    }
}

package com.nz.test.base;

import com.nz.test.pojo.RoleEntity;
import com.nz.test.pojo.UserEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * 两个相等的对象必须具有相等的散列码
 */
public class OverrideEquals {
    public static void main(String[] args) {
        /**
         * 比如一个人在不同的时期在系统中生成了两个实例,要想判断这两个实例是不是一个人,比较身份证号就可以了.假定这两个实例,一个是16岁时建立的档案,一个是24岁入职建立的档案,如果不重写equals方法.这两个实例肯定不是一个人了.
         * 如果不被重写（原生）的hashCode和equals是什么样的？
         *     1.不被重写（原生）的hashCode值是根据内存地址换算出来的一个值。
         *     2.不被重写（原生）的equals方法是严格判断一个对象是否相等的方法（object1 == object2）。
         * 通用约定:
         *     1.同一个对象的equals方法做对比用到的信息没被修改,多次调用hashCode返回值一样
         *     2.相等的对象必须具有相等的散列码
         *     3.不等的对象散列码不一定相等
         */

        UserEntity userEntity1 = new UserEntity(1,"zyw","612522199109195617");
        UserEntity userEntity2 = new UserEntity(2,"zyw","612522199109195617");

        Map<String, Object> map = new HashMap<>();
        map.put("user1", userEntity1);
        map.put("user2", userEntity2);

        /**
         * object对象中的 public boolean equals(Object obj),对于任何非空引用值 x 和 y,当且仅当 x 和 y 引用同一个对象时,此方法才返回 true;
         * 注意:当此方法被重写时,通常有必要重写 hashCode 方法,以维护 hashCode 方法的常规协定,该协定声明相等对象必须具有相等的哈希码.如下:
         * (1)当obj1.equals(obj2)为true时,obj1.hashCode() == obj2.hashCode()必须为true
         * (2)当obj1.hashCode() != obj2.hashCode()为true时,obj1.equals(obj2)必须为false
         *
         * Java规范:
         * 1.两个对象相等,hashcode一定相等(栈内存地址)
         * 2.两个对象不等,hashcode不一定不等(Map = 数组 + 链表)
         * 3.hashcode相等,两个对象不一定相等
         * 4.hashcode不等,两个对象一定不等
         *
         * 如果不重写equals,那么比较的将是对象的引用是否指向同一块内存地址,重写之后目的是为了比较两个对象的value值是否相等.
         *
         * 如果我们对一个对象重写了euqals,意思是只要对象的成员变量值都相等那么euqals就等于true,但不重写hashcode,那么我们再new一个新的对象，
         * 那么当原对象.equals（新对象）等于true时,两者的hashcode却是不一样的,由此将产生了理解的不一致,如在存储散列集合时（如Set类）,将会存储了两个值一样的对象，导致混淆，
         * 因此就也需要重写hashcode()
         */
        System.out.println("#### "+userEntity1.equals(userEntity2));
        System.out.println("#### "+userEntity1.hashCode());
        System.out.println("#### "+userEntity2.hashCode());
    }
}
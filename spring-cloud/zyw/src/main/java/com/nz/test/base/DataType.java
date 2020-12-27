package com.nz.test.base;

/**
 * Java中变量分为基本数据类型和引用类型,前者分配在栈内,出了作用域就自动释放,后者分配在堆内或者常量池(比如字符串常量和基本数据类型常量),需要new出来
 *
 * 栈,堆和常量池,对于栈和常量池中的对象可以 共享, 对于堆中的对象不可以共享.        基本数据、常量池共享变量值对另外一个变量没影响,编译器完成,节省空间;两个引用类型,一个改变会影响另一个
 * 栈中的数据大小和生命周期是可以确定的,当没有引用指向数据时,这个数据就会消失;
 * 堆中的对象的由垃圾回收器负责回收,因此大小和生命周期不需要确定,具有很大的灵活性;
 *
 * 对于equals相等的字符串,在常量池中永远只有一份,在堆中有多份;
 *
 * JVM是基于堆栈的虚拟机.JVM为每个新创建的线程都分配一个堆栈.也就是说,对于一个Java程序来说.它的运行就是通过对堆栈的操作来完成的.堆栈以帧为单位保存线程的状态.JVM对堆栈只进行两种操作:以帧为单位的压栈和出栈操作
 *
 * 对于成员变量和局部变量：
 * 成员变量就是方法外部，类的内部定义的变量；成员变量存储在堆中的对象里面，由垃圾回收器负责回收。
 * 局部变量就是方法或语句块内部定义的变量;局部变量必须初始化,形式参数是局部变量,局部变量的数据存在于栈内存中,栈内存中的局部变量随着方法的消失而消失。
 *
 * 基本数据类型(栈内存):共8种基本数据类型,byte、short、int、long、float、double、char、boolean,其中:
 * 1.byte、short、int、long是整型; 默认值都为0;
 * 2.float、double是浮点型; 默认值为0.0;
 * 3.char是字符型; 默认值为空
 * 4.boolean是布尔型; 默认值为false
 * <p>
 * 引用类型(引用地址栈内存,实际对象保存在堆内存):每种基本类型都提供了对应的封装类型,分别为：Byte、Short、Integer、Long、Float、Double、Character、Boolean; 默认值都为null
 * 引用类型是一种对象类型,它的值是指向内存空间的引用,即地址.
 * 包装类型默认值都为null
 * <p>
 * 自动装箱、自动拆箱:
 * 自动装箱时编译器会调用valueOf方法,将原始类型转化为对象类型; 自动装箱主要发生在两种情况：一种是赋值时,一种是方法调用时
 * 自动拆箱时编译器会调用intValue(),doubleValue()这类的方法将对象转换成原始类型值
 * 自动装箱、拆箱带来的问题:
 * 1.程序的性能: 装箱会隐式地创建对象创建.不要在一个循环中进行自动装箱的操作
 * 2.空指针异常
 */
public class DataType {

    public static void main(String[] args) {
        Integer a = 120;
        int b = 120;
        Integer c = 120;
        Integer d = new Integer(120);
        System.out.println(a==b);
        System.out.println(a.equals(c));
        System.out.println(a.equals(d));

        String str1 = "abc";
        String str2 = "abc";
        str1= "bcd";
    }
}

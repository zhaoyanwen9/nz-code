package com.nz.test.service.impl;

import com.nz.test.mapper.AccountMapper;
import com.nz.test.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountDao;

    /**
     * ############# 默认地 只 在抛出 运行时 和 不可查异常 时才标识事务回滚 #############
     * <p>
     * Throwable: Exception（异常）和Error（错误）,二者都是Java异常处理的重要子类
     * 1.Error（错误）是程序无法处理的错误,代码运行时JVM（Java虚拟机）出现的问题.
     * 例如: Java虚拟机运行错误（Virtual MachineError）,当JVM不再有继续执行操作所需要的内存资源时,将出现内存溢出(OutOfMemoryError).异常发生时,Java虚拟机（JVM）一般会选择线程终止
     * 2.Exception（异常）:是程序本身可以处理的异常.分为运行时异常RuntimeException和非运行时异常
     * <p>
     * Exception:
     * 1.运行时异常: Java编译器不会检查
     * 空指针 - NullPointerException
     * 类型强转 - ClassCastException
     * 数字格式异常 - NumberFormatException
     * 参数非法 -
     * 算术运算异常 : 由于除数为0引起的异常 - ArithmeticException
     * 向数组中存放与声明类型不兼容的对象 -
     * 下标越界 - IndexOutOfBoundsException
     * 创建一个大小为负数的数组错误异常 - NegativeArraySizeException
     * 数组存储空间不够引起的异常 - ArrayStoreException
     * 安全异常 - SecurityException
     * 不支持的操作符异常
     * 运行中逻辑错误引起的
     * 不可察异常
     * <p>
     * 2.非运行时异常: Exception类及其子类,JAVA编译器强制要求必需对出现的异常进行catch并处理,否则程序编译时无法通过
     * IO异常 - IOException
     * SQL异常 - SQLException
     * 未找到指定名字的类或接口引起异常 - ClassNotFoundException
     * <p>
     * 可查异常: Exception下除了RuntimeException外的异常;
     * 不可查异常: RuntimeException及其子类和错误（Error）;
     * <p>
     * 如果不对运行时异常进行处理,那么出现运行时异常之后,要么是线程中止,要么是主程序终止
     * 如果不想终止,则必须捕获所有的运行时异常;队列里面出现异常数据,正常的处理应该是把异常数据舍弃,然后记录日志.不应该由于异常数据而影响下面对正常数据的处理
     * <p>
     * 1.可查异常例外回滚:在方法上加 @Transactional(rollbackFor=Exception.class)
     * 2.不可察异常例外不回滚:在方法上加@Transactional(notRollbackFor=RunTimeException.class)
     * 3.不需要事务管理的(只查询的)方法：@Transactional(propagation=Propagation.NOT_SUPPORTED)
     * <p>
     * 如果异常被try｛｝catch｛｝了,事务就不回滚了. 如果想让事务回滚必须再往外抛try｛｝catch｛throw Exception｝
     *
     * @param outter
     * @param inner
     * @param money
     *
     * spring支持编程式事务管理和声明式事务管理两种方式:
     * 1.对于编程式事务管理，spring推荐使用TransactionTemplate。
     * 2.声明式事务管理建立在AOP之上的,其本质是对方法前后进行拦截,然后在目标方法开始之前创建或者加入一个事务,在执行完目标方法之后根据执行情况提交或者回滚事务
     * 声明式事务管理也有两种常用的方式
     * 2.1 一种是基于tx和aop名字空间的xml配置文件
     * 2.2 另一种就是基于@Transactional注解
     *
     * 当作用于类上时,该类的所有 public 方法将都具有该类型的事务属性.同时,我们也可以在方法级别使用该标注来覆盖类级别的定义
     *
     * @Transactional(rollbackFor=Exception.class), 如果类加了这个注解,那么这个类里面的方法抛出异常,就会回滚,数据库里面的数据也会回滚
     * 在@Transactional注解中如果不配置rollbackFor属性,那么事物只会在遇到RuntimeException的时候才会回滚,加上rollbackFor=Exception.class,可以让事物在遇到非运行时异常时也回滚
     *
     * value-> String -> 可选的限定描述符,指定使用的事务管理器
     * propagation -> enum: Propagation -> 可选的事务传播行为设置
     * isolation -> enum: Isolation -> 可选的事务隔离级别设置
     * readOnly ->	boolean ->	读写或只读事务,默认读写
     * timeout -> int (in seconds granularity) -> 事务超时时间设置
     * rollbackFor -> Class对象数组,必须继承自Throwable -> 导致事务回滚的异常类数组
     * rollbackForClassName	-> 类名数组,必须继承自Throwable -> 导致事务回滚的异常类名字数组
     * noRollbackFor -> Class对象数组，必须继承自Throwable -> 不会导致事务回滚的异常类数组
     * noRollbackForClassName -> 类名数组，必须继承自Throwable -> 不会导致事务回滚的异常类名字数组
     */

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void transfer(int outter, int inner, Integer money) {
        // 转出
        accountDao.moveOut(outter, money);

        // 抛出异常, 事务不回滚
        //try {
        //    int i = 1 / 0;
        //} catch (Exception e) {
        //}

        // 转入
        accountDao.moveIn(inner, money);
    }
}

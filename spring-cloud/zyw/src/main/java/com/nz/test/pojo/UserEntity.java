package com.nz.test.pojo;

public class UserEntity {

    private int id;

    private String idCard;

    private String name;

    public UserEntity(int id, String idCard, String name) {
        this.id = id;
        this.idCard = idCard;
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        /**
         * instanceof 严格来说是Java中的一个双目运算符,用来测试一个对象是否为一个类的实例,用法为: boolean result = object instanceof Class
         * 1.object必须为引用类型，不能是基本类型
         * 2.obj 为 null
         * 3.obj 为 class 类的实例对象
         * 4.obj 为 class 接口的实现类
         * 5.obj 为 class 类的直接或间接子类
         */
        if (object instanceof UserEntity) {
            UserEntity userEntity = (UserEntity) object;
            return (this.idCard.equals(userEntity.idCard));
        }
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return idCard.hashCode();
    }
}

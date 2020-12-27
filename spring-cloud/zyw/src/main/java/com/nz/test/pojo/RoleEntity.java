package com.nz.test.pojo;

public class RoleEntity {
    private int id;

    public RoleEntity() {
    }

    public RoleEntity(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        // 用来测试一个对象是否为一个类的实例
        if (obj instanceof RoleEntity) {
            System.out.println("l");
        }
        return super.equals(obj);
    }
}

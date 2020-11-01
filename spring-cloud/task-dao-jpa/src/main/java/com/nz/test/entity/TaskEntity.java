package com.nz.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    public TaskEntity() {
    }

    public TaskEntity(String name) {
        this.name = name;
    }

    public TaskEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

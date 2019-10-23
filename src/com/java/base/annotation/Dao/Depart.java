package com.java.base.annotation.Dao;

/**
 * @ClassName Depart
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/8/21 9:25
 * @Version 1.0
 **/
public class Depart {
    private int id;
    private String name;
    private int count;
    private String address;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

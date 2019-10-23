package com.java.base.annotation.Dao;

/**
 * @ClassName School
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/8/21 9:45
 * @Version 1.0
 **/
@Table("school")
public class School {
    @Column("school_id")
    private int id;
    @Column("school_name")
    private String name;
    @Column("school_address")
    private String address;
    @Column("create_year")
    private String born;
    @Column("student_count")
    private int count;
    @Column("depart")
    private String depart;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }
}

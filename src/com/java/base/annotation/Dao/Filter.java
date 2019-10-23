package com.java.base.annotation.Dao;

/**
 * @ClassName Filter
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/8/20 18:39
 * @Version 1.0
 **/
public class Filter {
    private int id;
    private String userName;
    private String nickName;
    private int age;
    private String city;
    private String email;
    private String mobile;

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getNickName() {
        return nickName;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}

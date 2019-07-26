package com.book.borrow.pojo;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/12/9:34
 * @description: null
 */

public class User {
    private String id;
    private String name;
    private String userId;
    private String password;
    private String gender;
    private int age;
    private String phone;
    private String inClass;

    public User(String id, String name, String userId, String password, String gender, int age, String phone, String inClass) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.inClass = inClass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInClass() {
        return inClass;
    }

    public void setInClass(String inClass) {
        this.inClass = inClass;
    }
}

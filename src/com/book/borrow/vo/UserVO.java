package com.book.borrow.vo;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/12/17:14
 * @description: null
 */

public class UserVO {
    private String name;
    private String userId;
    private String gender;
    private int age;
    private int noReturnCount;

    public UserVO(String userId,String name, String gender, int age,int noReturnCount) {
        this.age=age;
        this.gender=gender;
        this.name=name;
        this.userId=userId;
        this.noReturnCount=noReturnCount;
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


    public int getNoReturnCount() {
        return noReturnCount;
    }

    public void setNoReturnCount(int noReturnCount) {
        this.noReturnCount = noReturnCount;
    }
}

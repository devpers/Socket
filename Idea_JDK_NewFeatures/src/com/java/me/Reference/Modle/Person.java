package com.java.me.Reference.Modle;

public class Person {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 性别
     */
    private String sex;
    /**
     * 身份证
     */
    private String idCard;

    public Person(String name, String idCard) {
        this.name = name;
        this.idCard = idCard;
    }

    public Person(String name, int age, String sex, String idCard) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}

package com.xyq.entity;

public class Person {
    //成员变量是私有的
    private String name;
    private int age;
    //可以有效保护成员变量不被胡乱赋值
    //setter
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        if(age < 0) {
            this.age = 0;
        } else {
            this.age = age;
        }
    }
    //getter
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public void eat(){
        System.out.println(this.name + "在吃东西");
    }
}

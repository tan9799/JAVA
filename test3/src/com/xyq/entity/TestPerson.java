package com.xyq.entity;

public class TestPerson {
    public static void main(String[] args) {
        Person P = new Person();
        P.setName("周润发");
        P.setAge(-1);
        //查看这个人的名字和年龄
        System.out.println(P.getName());
        System.out.println(P.getAge());
        P.eat();
    }
}

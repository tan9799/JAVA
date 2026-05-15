package com.tablegame;

public class Customer {
    private String name;
    private String phone;
    private Member member;   // 关联会员，可为null

    public Customer() {}
    public Customer(String name, String phone) {
        this(name, phone, null);
    }
    public Customer(String name, String phone, Member member) {
        this.name = name;
        this.phone = phone;
        this.member = member;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Member getMember() { return member; }
    public void setMember(Member member) { this.member = member; }

    public double getDiscount() {
        return (member != null) ? member.getDiscount() : 1.0;
    }
}
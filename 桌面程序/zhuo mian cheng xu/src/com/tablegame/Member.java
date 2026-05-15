package com.tablegame;

public class Member {
    private String memberId;      // 会员卡号
    private String name;          // 会员姓名
    private String phone;         // 联系电话
    private int level;            // 会员等级 1-5
    private double discount;      // 折扣率 0.9表示9折

    public Member() {}

    public Member(String memberId, String name, String phone, int level) {
        this.memberId = memberId;
        this.name = name;
        this.phone = phone;
        setLevel(level);
    }

    public void setLevel(int level) {
        this.level = level;
        // 根据等级设置折扣率，可配置
        switch (level) {
            case 1: this.discount = 1.0; break;   // 无折扣
            case 2: this.discount = 0.95; break;
            case 3: this.discount = 0.90; break;
            case 4: this.discount = 0.85; break;
            case 5: this.discount = 0.80; break;
            default: this.discount = 1.0;
        }
    }

    // getters/setters 省略，自行添加
    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public int getLevel() { return level; }
    public double getDiscount() { return discount; }
}
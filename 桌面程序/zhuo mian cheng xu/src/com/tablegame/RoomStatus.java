package com.tablegame;

public enum RoomStatus {
    FREE("空闲"), USING("使用中"), RESERVED("已预约");

    private String desc;
    RoomStatus(String desc) { this.desc = desc; }
    public String getDesc() { return desc; }
}
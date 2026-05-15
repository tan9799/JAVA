package com.tablegame;

public class StdRoom extends Room {
    public StdRoom() {}
    public StdRoom(String roomId, double pricePerHour) {
        super(roomId, "标准间", pricePerHour);
    }
    @Override
    public double calculateCost(double hours) {
        return pricePerHour * hours;
    }
}
package com.tablegame;

public class VIPRoom extends Room {
    private static final double SERVICE_RATE = 0.2;
    public VIPRoom() {}
    public VIPRoom(String roomId, double pricePerHour) {
        super(roomId, "VIP间", pricePerHour);
    }
    @Override
    public double calculateCost(double hours) {
        return pricePerHour * hours * (1 + SERVICE_RATE);
    }
}
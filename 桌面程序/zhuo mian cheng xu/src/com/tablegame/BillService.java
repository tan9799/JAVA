package com.tablegame;

public class BillService {
    public static double calculate(Room room, double hours) {
        return room.calculateCost(hours);
    }
}
package com.tablegame;

import java.time.Duration;
import java.time.LocalDateTime;

public class NormalPricing implements PricingStrategy {
    @Override
    public double calculate(Room room, LocalDateTime start, LocalDateTime end) {
        long minutes = Duration.between(start, end).toMinutes();
        double hours = minutes / 60.0;
        return room.calculateCost(hours);
    }
}
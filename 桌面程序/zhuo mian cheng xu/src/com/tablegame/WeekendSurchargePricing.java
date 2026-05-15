package com.tablegame;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;

public class WeekendSurchargePricing implements PricingStrategy {
    @Override
    public double calculate(Room room, LocalDateTime start, LocalDateTime end) {
        long minutes = Duration.between(start, end).toMinutes();
        double hours = minutes / 60.0;
        double base = room.calculateCost(hours);
        if (end.getDayOfWeek() == DayOfWeek.SATURDAY || end.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return base * 1.2;
        }
        return base;
    }
}
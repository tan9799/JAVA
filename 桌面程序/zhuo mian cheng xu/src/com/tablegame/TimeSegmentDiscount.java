package com.tablegame;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeSegmentDiscount implements PricingStrategy {
    @Override
    public double calculate(Room room, LocalDateTime start, LocalDateTime end) {
        long minutes = Duration.between(start, end).toMinutes();
        double hours = minutes / 60.0;
        double base = room.calculateCost(hours);
        LocalTime startTime = start.toLocalTime();
        LocalTime endTime = end.toLocalTime();
        boolean isNight = (startTime.isAfter(LocalTime.of(22, 0)) || startTime.isBefore(LocalTime.of(8, 0))) ||
                (endTime.isAfter(LocalTime.of(22, 0)) || endTime.isBefore(LocalTime.of(8, 0)));
        if (isNight) return base * 0.8;
        return base;
    }
}
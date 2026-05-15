package com.tablegame;

import java.time.LocalDateTime;

public interface PricingStrategy {
    double calculate(Room room, LocalDateTime start, LocalDateTime end);
}
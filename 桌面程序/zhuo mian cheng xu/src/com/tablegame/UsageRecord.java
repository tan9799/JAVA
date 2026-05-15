package com.tablegame;

import java.time.Duration;
import java.time.LocalDateTime;

public class UsageRecord {
    private transient Room room;
    private String roomId;
    private Customer customer;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double cost;
    private transient PricingStrategy pricingStrategy;

    public UsageRecord() {}
    public UsageRecord(Room room, Customer customer, PricingStrategy strategy) {
        this.room = room;
        this.roomId = room.getRoomId();
        this.customer = customer;
        this.startTime = LocalDateTime.now();
        this.pricingStrategy = strategy;
    }

    public void endUsage() {
        this.endTime = LocalDateTime.now();
        if (pricingStrategy != null) {
            this.cost = pricingStrategy.calculate(room, startTime, endTime);
        } else {
            long minutes = Duration.between(startTime, endTime).toMinutes();
            double hours = minutes / 60.0;
            this.cost = room.calculateCost(hours);
        }
        // 应用会员折扣
        if (customer != null && customer.getDiscount() < 1.0) {
            this.cost *= customer.getDiscount();
        }
    }

    public void linkRoom(Room room) {
        if (room != null && room.getRoomId().equals(this.roomId)) {
            this.room = room;
        }
    }

    // Getters/Setters
    public Room getRoom() { return room; }
    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
    public PricingStrategy getPricingStrategy() { return pricingStrategy; }
    public void setPricingStrategy(PricingStrategy pricingStrategy) { this.pricingStrategy = pricingStrategy; }
}
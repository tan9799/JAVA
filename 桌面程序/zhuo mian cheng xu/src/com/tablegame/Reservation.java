package com.tablegame;

import java.time.LocalDateTime;

public class Reservation {
    private String reservationId;
    private String roomId;
    private Customer customer;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;  // "有效", "已使用", "已过期", "已取消"

    public Reservation() {}
    public Reservation(String reservationId, String roomId, Customer customer,
                       LocalDateTime startTime, LocalDateTime endTime) {
        this.reservationId = reservationId;
        this.roomId = roomId;
        this.customer = customer;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = "有效";
    }

    // Getters/Setters
    public String getReservationId() { return reservationId; }
    public void setReservationId(String reservationId) { this.reservationId = reservationId; }
    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
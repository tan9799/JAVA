package com.tablegame;

public abstract class Room {
    protected String roomId;
    protected String type;
    protected double pricePerHour;
    protected RoomStatus status;
    protected Reservation currentReservation;  // 当前预约

    public Room() {}

    public Room(String roomId, String type, double pricePerHour) {
        this.roomId = roomId;
        this.type = type;
        this.pricePerHour = pricePerHour;
        this.status = RoomStatus.FREE;
        this.currentReservation = null;
    }

    public abstract double calculateCost(double hours);

    // Getters/Setters
    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getPricePerHour() { return pricePerHour; }
    public void setPricePerHour(double pricePerHour) { this.pricePerHour = pricePerHour; }
    public RoomStatus getStatus() { return status; }
    public void setStatus(RoomStatus status) { this.status = status; }
    public Reservation getCurrentReservation() { return currentReservation; }
    public void setCurrentReservation(Reservation currentReservation) { this.currentReservation = currentReservation; }

    @Override
    public String toString() {
        String statusDesc = status.getDesc();
        if (status == RoomStatus.RESERVED && currentReservation != null) {
            statusDesc += "(预约 " + currentReservation.getStartTime().toLocalTime() + ")";
        }
        return roomId + " (" + type + ", " + pricePerHour + "元/小时, " + statusDesc + ")";
    }
}
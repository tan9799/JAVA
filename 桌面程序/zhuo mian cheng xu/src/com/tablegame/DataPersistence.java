package com.tablegame;

import java.io.IOException;
import java.util.List;

public interface DataPersistence {
    void saveRooms(List<Room> rooms) throws IOException;
    void saveRecords(List<UsageRecord> records) throws IOException;
    void saveReservations(List<Reservation> reservations) throws IOException;   // 新增
    void saveMembers(List<Member> members) throws IOException;                 // 新增
    List<Room> loadRooms() throws IOException;
    List<UsageRecord> loadRecords() throws IOException;
    List<Reservation> loadReservations() throws IOException;
    List<Member> loadMembers() throws IOException;
}
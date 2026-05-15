package com.tablegame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileStorage implements DataPersistence {
    private static final String ROOM_FILE = "rooms.json";
    private static final String RECORD_FILE = "records.json";
    private static final String RESERVATION_FILE = "reservations.json";
    private static final String MEMBER_FILE = "members.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public void saveRooms(List<Room> rooms) throws IOException {
        List<JsonObject> list = new ArrayList<>();
        for (Room r : rooms) {
            JsonObject obj = (JsonObject) gson.toJsonTree(r);
            obj.addProperty("className", r.getClass().getName());
            list.add(obj);
        }
        try (FileWriter w = new FileWriter(ROOM_FILE)) {
            gson.toJson(list, w);
        }
    }

    @Override
    public List<Room> loadRooms() throws IOException {
        File file = new File(ROOM_FILE);
        if (!file.exists()) return new ArrayList<>();
        try (FileReader r = new FileReader(file)) {
            Type type = new TypeToken<List<JsonObject>>(){}.getType();
            List<JsonObject> list = gson.fromJson(r, type);
            List<Room> rooms = new ArrayList<>();
            for (JsonObject obj : list) {
                String className = obj.get("className").getAsString();
                obj.remove("className");
                try {
                    Class<?> clazz = Class.forName(className);
                    Room room = (Room) gson.fromJson(obj, clazz);
                    rooms.add(room);
                } catch (ClassNotFoundException e) {
                    throw new IOException("房间类型加载失败: " + className, e);
                }
            }
            return rooms;
        }
    }

    @Override
    public void saveRecords(List<UsageRecord> records) throws IOException {
        try (FileWriter w = new FileWriter(RECORD_FILE)) {
            gson.toJson(records, w);
        }
    }

    @Override
    public List<UsageRecord> loadRecords() throws IOException {
        File file = new File(RECORD_FILE);
        if (!file.exists()) return new ArrayList<>();
        try (FileReader r = new FileReader(file)) {
            Type type = new TypeToken<List<UsageRecord>>(){}.getType();
            List<UsageRecord> list = gson.fromJson(r, type);
            return list != null ? list : new ArrayList<>();
        }
    }

    @Override
    public void saveReservations(List<Reservation> reservations) throws IOException {
        try (FileWriter w = new FileWriter(RESERVATION_FILE)) {
            gson.toJson(reservations, w);
        }
    }

    @Override
    public List<Reservation> loadReservations() throws IOException {
        File file = new File(RESERVATION_FILE);
        if (!file.exists()) return new ArrayList<>();
        try (FileReader r = new FileReader(file)) {
            Type type = new TypeToken<List<Reservation>>(){}.getType();
            List<Reservation> list = gson.fromJson(r, type);
            return list != null ? list : new ArrayList<>();
        }
    }

    @Override
    public void saveMembers(List<Member> members) throws IOException {
        try (FileWriter w = new FileWriter(MEMBER_FILE)) {
            gson.toJson(members, w);
        }
    }

    @Override
    public List<Member> loadMembers() throws IOException {
        File file = new File(MEMBER_FILE);
        if (!file.exists()) return new ArrayList<>();
        try (FileReader r = new FileReader(file)) {
            Type type = new TypeToken<List<Member>>(){}.getType();
            List<Member> list = gson.fromJson(r, type);
            return list != null ? list : new ArrayList<>();
        }
    }
}
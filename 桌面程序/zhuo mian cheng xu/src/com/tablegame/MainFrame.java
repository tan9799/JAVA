package com.tablegame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

public class MainFrame extends JFrame {
    private List<Room> rooms;
    private List<UsageRecord> records;
    private List<Reservation> reservations;
    private List<Member> members;
    private DataPersistence storage;
    private DefaultListModel<String> listModel;
    private JList<String> roomJList;
    private JTextArea infoArea;
    private Room selectedRoom;
    private JLabel statusBar;
    private Timer refreshTimer;

    public MainFrame() {
        storage = new FileStorage();
        loadData();
        if (rooms == null || rooms.isEmpty()) initDemoRooms();
        if (records == null) records = new java.util.ArrayList<>();
        if (reservations == null) reservations = new java.util.ArrayList<>();
        if (members == null) members = new java.util.ArrayList<>();
        // 关联记录的房间对象
        for (UsageRecord rec : records) {
            for (Room room : rooms) {
                if (room.getRoomId().equals(rec.getRoomId())) {
                    rec.linkRoom(room);
                    break;
                }
            }
        }
        // 检查预约状态
        updateReservationStatus();
        initUI();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveData();
                System.exit(0);
            }
        });
        // 自动刷新计时显示
        refreshTimer = new Timer(1000, e -> {
            if (selectedRoom != null && selectedRoom.getStatus() == RoomStatus.USING) updateInfoArea();
        });
        refreshTimer.start();
    }

    private void loadData() {
        try {
            rooms = storage.loadRooms();
            records = storage.loadRecords();
            reservations = storage.loadReservations();
            members = storage.loadMembers();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "加载数据失败: " + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveData() {
        try {
            storage.saveRooms(rooms);
            for (UsageRecord rec : records) {
                if (rec.getRoom() != null) rec.setRoomId(rec.getRoom().getRoomId());
            }
            storage.saveRecords(records);
            storage.saveReservations(reservations);
            storage.saveMembers(members);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "保存数据失败: " + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initDemoRooms() {
        rooms = new java.util.ArrayList<>();
        rooms.add(new StdRoom("101", 30.0));
        rooms.add(new StdRoom("102", 30.0));
        rooms.add(new VIPRoom("201", 80.0));
    }

    private void updateReservationStatus() {
        LocalDateTime now = LocalDateTime.now();
        for (Reservation res : reservations) {
            Room room = findRoomById(res.getRoomId());
            if (room == null) continue;
            if ("有效".equals(res.getStatus())) {
                if (now.isAfter(res.getEndTime())) {
                    res.setStatus("已过期");
                    if (room.getCurrentReservation() == res) {
                        room.setStatus(RoomStatus.FREE);
                        room.setCurrentReservation(null);
                    }
                } else if (now.isAfter(res.getStartTime()) && now.isBefore(res.getEndTime())) {
                    room.setStatus(RoomStatus.RESERVED);
                    room.setCurrentReservation(res);
                }
            }
        }
    }

    private Room findRoomById(String id) {
        for (Room r : rooms) if (r.getRoomId().equals(id)) return r;
        return null;
    }

    private void initUI() {
        setTitle("桌游馆计时收费系统 (高级版)");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        roomJList = new JList<>(listModel);
        roomJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        roomJList.addListSelectionListener(this::onRoomSelected);
        JScrollPane leftScroll = new JScrollPane(roomJList);
        leftScroll.setBorder(BorderFactory.createTitledBorder("房间列表"));
        add(leftScroll, BorderLayout.WEST);

        JPanel rightPanel = new JPanel(new BorderLayout());
        infoArea = new JTextArea();
        infoArea.setEditable(false);
        rightPanel.add(new JScrollPane(infoArea), BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new GridLayout(9, 1, 5, 5));
        JButton btnStart = new JButton("开始计时");
        JButton btnEnd = new JButton("结束计时");
        JButton btnReserve = new JButton("预约房间");
        JButton btnAddRoom = new JButton("添加房间");
        JButton btnDelRoom = new JButton("删除房间");
        JButton btnStats = new JButton("日营业额统计");
        JButton btnRefresh = new JButton("刷新列表");
        JButton btnQuery = new JButton("查询记录");
        JButton btnAddMember = new JButton("添加会员");
        btnPanel.add(btnStart);
        btnPanel.add(btnEnd);
        btnPanel.add(btnReserve);
        btnPanel.add(btnAddRoom);
        btnPanel.add(btnDelRoom);
        btnPanel.add(btnStats);
        btnPanel.add(btnRefresh);
        btnPanel.add(btnQuery);
        btnPanel.add(btnAddMember);
        rightPanel.add(btnPanel, BorderLayout.EAST);
        add(rightPanel, BorderLayout.CENTER);

        statusBar = new JLabel("就绪");
        add(statusBar, BorderLayout.SOUTH);

        btnStart.addActionListener(e -> startTiming());
        btnEnd.addActionListener(e -> endTiming());
        btnReserve.addActionListener(e -> makeReservation());
        btnAddRoom.addActionListener(e -> addRoom());
        btnDelRoom.addActionListener(e -> deleteRoom());
        btnStats.addActionListener(e -> new StatsDialog(this, records).setVisible(true));
        btnRefresh.addActionListener(e -> refreshRoomList());
        btnQuery.addActionListener(e -> new RecordQueryDialog(this, records).setVisible(true));
        btnAddMember.addActionListener(e -> addMember());

        refreshRoomList();
        setVisible(true);
    }

    private void addMember() {
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField phoneField = new JTextField();
        JComboBox<Integer> levelCombo = new JComboBox<>(new Integer[]{1,2,3,4,5});
        JPanel panel = new JPanel(new GridLayout(4,2));
        panel.add(new JLabel("会员卡号:")); panel.add(idField);
        panel.add(new JLabel("姓名:")); panel.add(nameField);
        panel.add(new JLabel("电话:")); panel.add(phoneField);
        panel.add(new JLabel("等级:")); panel.add(levelCombo);
        int result = JOptionPane.showConfirmDialog(this, panel, "添加会员", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();
            int level = (int) levelCombo.getSelectedItem();
            if (id.isEmpty() || name.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(this, "请完整填写信息");
                return;
            }
            members.add(new Member(id, name, phone, level));
            JOptionPane.showMessageDialog(this, "会员添加成功");
        }
    }

    private void makeReservation() {
        if (selectedRoom == null) { JOptionPane.showMessageDialog(this, "请选择房间"); return; }
        if (selectedRoom.getStatus() != RoomStatus.FREE) { JOptionPane.showMessageDialog(this, "该房间不可预约"); return; }
        ReservationDialog dlg = new ReservationDialog(this, selectedRoom.getRoomId());
        dlg.setVisible(true);
        if (dlg.isConfirmed()) {
            String resId = UUID.randomUUID().toString().substring(0, 8);
            Reservation res = new Reservation(resId, selectedRoom.getRoomId(),
                    dlg.getCustomer(), dlg.getStartDateTime(), dlg.getEndDateTime());
            reservations.add(res);
            updateReservationStatus();
            refreshRoomList();
            JOptionPane.showMessageDialog(this, "预约成功");
        }
    }

    private void startTiming() {
        if (selectedRoom == null) { JOptionPane.showMessageDialog(this, "请选择房间"); return; }
        boolean canStart = selectedRoom.getStatus() == RoomStatus.FREE ||
                (selectedRoom.getStatus() == RoomStatus.RESERVED && selectedRoom.getCurrentReservation() != null);
        if (!canStart) { JOptionPane.showMessageDialog(this, "房间不可用"); return; }
        Customer preCustomer = null;
        if (selectedRoom.getStatus() == RoomStatus.RESERVED && selectedRoom.getCurrentReservation() != null) {
            int opt = JOptionPane.showConfirmDialog(this,
                    "该房间已被预约，是否按预约信息开台？\n预约人：" + selectedRoom.getCurrentReservation().getCustomer().getName(),
                    "预约开台", JOptionPane.YES_NO_OPTION);
            if (opt == JOptionPane.YES_OPTION) {
                preCustomer = selectedRoom.getCurrentReservation().getCustomer();
                selectedRoom.getCurrentReservation().setStatus("已使用");
                selectedRoom.setCurrentReservation(null);
            }
        }
        StartTimingDialog dlg = new StartTimingDialog(this, selectedRoom, members, preCustomer);
        dlg.setVisible(true);
        if (dlg.isConfirmed()) {
            Customer customer = dlg.getCustomer();
            PricingStrategy strategy = dlg.getSelectedStrategy();
            UsageRecord record = new UsageRecord(selectedRoom, customer, strategy);
            records.add(record);
            selectedRoom.setStatus(RoomStatus.USING);
            refreshRoomList();
            JOptionPane.showMessageDialog(this, "计时开始！");
        }
    }

    private void endTiming() {
        if (selectedRoom == null) { JOptionPane.showMessageDialog(this, "请选择房间"); return; }
        if (selectedRoom.getStatus() != RoomStatus.USING) { JOptionPane.showMessageDialog(this, "房间未在使用"); return; }
        UsageRecord record = null;
        for (UsageRecord r : records) {
            if (r.getRoom() == selectedRoom && r.getEndTime() == null) {
                record = r; break;
            }
        }
        if (record == null) { JOptionPane.showMessageDialog(this, "未找到使用记录"); return; }
        record.endUsage();
        double cost = record.getCost();
        long minutes = java.time.Duration.between(record.getStartTime(), record.getEndTime()).toMinutes();
        statusBar.setText(String.format("房间 %s 使用 %.1f 小时，费用 %.2f 元", selectedRoom.getRoomId(), minutes/60.0, cost));
        JOptionPane.showMessageDialog(this, String.format("使用时长: %.1f 小时\n费用: %.2f 元", minutes/60.0, cost));
        selectedRoom.setStatus(RoomStatus.FREE);
        refreshRoomList();
    }

    private void addRoom() {
        AddRoomDialog dlg = new AddRoomDialog(this, rooms);
        dlg.setVisible(true);
        if (dlg.isConfirmed()) {
            Room newRoom;
            if ("标准间".equals(dlg.getRoomType()))
                newRoom = new StdRoom(dlg.getRoomId(), dlg.getPrice());
            else
                newRoom = new VIPRoom(dlg.getRoomId(), dlg.getPrice());
            rooms.add(newRoom);
            refreshRoomList();
        }
    }

    private void deleteRoom() {
        if (selectedRoom == null) { JOptionPane.showMessageDialog(this, "请选择房间"); return; }
        if (selectedRoom.getStatus() != RoomStatus.FREE) { JOptionPane.showMessageDialog(this, "只能删除空闲房间"); return; }
        int confirm = JOptionPane.showConfirmDialog(this, "删除房间 " + selectedRoom.getRoomId() + " ?", "确认", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            rooms.remove(selectedRoom);
            selectedRoom = null;
            refreshRoomList();
        }
    }

    private void refreshRoomList() {
        listModel.clear();
        for (Room r : rooms) listModel.addElement(r.toString());
        if (selectedRoom != null && !rooms.contains(selectedRoom)) selectedRoom = null;
        updateInfoArea();
    }

    private void onRoomSelected(ListSelectionEvent e) {
        int idx = roomJList.getSelectedIndex();
        selectedRoom = (idx >= 0 && idx < rooms.size()) ? rooms.get(idx) : null;
        updateInfoArea();
    }

    private void updateInfoArea() {
        if (selectedRoom == null) { infoArea.setText("未选择房间"); return; }
        StringBuilder sb = new StringBuilder();
        sb.append("房间号: ").append(selectedRoom.getRoomId()).append("\n");
        sb.append("类型: ").append(selectedRoom.getType()).append("\n");
        sb.append("单价: ").append(selectedRoom.getPricePerHour()).append(" 元/小时\n");
        sb.append("状态: ").append(selectedRoom.getStatus().getDesc()).append("\n");
        if (selectedRoom.getStatus() == RoomStatus.USING) {
            for (UsageRecord rec : records) {
                if (rec.getRoom() == selectedRoom && rec.getEndTime() == null) {
                    LocalDateTime start = rec.getStartTime();
                    long minutes = java.time.Duration.between(start, LocalDateTime.now()).toMinutes();
                    sb.append("开始时间: ").append(start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n");
                    sb.append("已用时长: ").append(minutes/60).append(" 小时 ").append(minutes%60).append(" 分钟\n");
                    sb.append("顾客: ").append(rec.getCustomer().getName()).append(" 电话:").append(rec.getCustomer().getPhone());
                    if (rec.getCustomer().getMember() != null)
                        sb.append(" (会员 ").append(rec.getCustomer().getMember().getLevel()).append("级)");
                    break;
                }
            }
        } else if (selectedRoom.getStatus() == RoomStatus.RESERVED && selectedRoom.getCurrentReservation() != null) {
            Reservation res = selectedRoom.getCurrentReservation();
            sb.append("预约时间: ").append(res.getStartTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                    .append(" 至 ").append(res.getEndTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))).append("\n");
            sb.append("预约人: ").append(res.getCustomer().getName()).append(" ").append(res.getCustomer().getPhone());
        }
        infoArea.setText(sb.toString());
    }
}
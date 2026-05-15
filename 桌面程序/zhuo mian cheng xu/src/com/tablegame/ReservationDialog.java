package com.tablegame;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ReservationDialog extends JDialog {
    private JTextField nameField, phoneField, startDateField, startTimeField, endDateField, endTimeField;
    private boolean confirmed = false;
    private Customer customer;
    private LocalDateTime startDateTime, endDateTime;
    private String roomId;

    public ReservationDialog(JFrame parent, String roomId) {
        super(parent, "预约房间 " + roomId, true);
        this.roomId = roomId;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());
        JPanel form = new JPanel(new GridLayout(6, 2, 5, 5));
        form.add(new JLabel("顾客姓名:"));
        nameField = new JTextField();
        form.add(nameField);
        form.add(new JLabel("联系电话:"));
        phoneField = new JTextField();
        form.add(phoneField);
        form.add(new JLabel("开始日期 (yyyy-mm-dd):"));
        startDateField = new JTextField(LocalDate.now().toString());
        form.add(startDateField);
        form.add(new JLabel("开始时间 (HH:MM):"));
        startTimeField = new JTextField("10:00");
        form.add(startTimeField);
        form.add(new JLabel("结束日期 (yyyy-mm-dd):"));
        endDateField = new JTextField(LocalDate.now().toString());
        form.add(endDateField);
        form.add(new JLabel("结束时间 (HH:MM):"));
        endTimeField = new JTextField("12:00");
        form.add(endTimeField);
        add(form, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        JButton okBtn = new JButton("确定");
        JButton cancelBtn = new JButton("取消");
        btnPanel.add(okBtn);
        btnPanel.add(cancelBtn);
        add(btnPanel, BorderLayout.SOUTH);

        okBtn.addActionListener(e -> {
            try {
                String name = nameField.getText().trim();
                String phone = phoneField.getText().trim();
                if (name.isEmpty() || phone.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "请填写姓名和电话");
                    return;
                }
                LocalDate startDate = LocalDate.parse(startDateField.getText());
                LocalTime startTime = LocalTime.parse(startTimeField.getText());
                LocalDate endDate = LocalDate.parse(endDateField.getText());
                LocalTime endTime = LocalTime.parse(endTimeField.getText());
                startDateTime = LocalDateTime.of(startDate, startTime);
                endDateTime = LocalDateTime.of(endDate, endTime);
                if (startDateTime.isAfter(endDateTime)) {
                    JOptionPane.showMessageDialog(this, "开始时间不能晚于结束时间");
                    return;
                }
                if (startDateTime.isBefore(LocalDateTime.now())) {
                    JOptionPane.showMessageDialog(this, "预约开始时间不能早于当前时间");
                    return;
                }
                customer = new Customer(name, phone);
                confirmed = true;
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "日期或时间格式错误");
            }
        });
        cancelBtn.addActionListener(e -> dispose());
        setSize(400, 300);
        setLocationRelativeTo(getParent());
    }

    public boolean isConfirmed() { return confirmed; }
    public Customer getCustomer() { return customer; }
    public LocalDateTime getStartDateTime() { return startDateTime; }
    public LocalDateTime getEndDateTime() { return endDateTime; }
}
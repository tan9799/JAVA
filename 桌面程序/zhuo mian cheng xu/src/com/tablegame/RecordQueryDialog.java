package com.tablegame;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class RecordQueryDialog extends JDialog {
    private List<UsageRecord> records;
    private JTextField roomIdField, customerNameField;
    private JComboBox<String> dateRangeCombo;
    private JTextArea resultArea;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public RecordQueryDialog(JFrame parent, List<UsageRecord> records) {
        super(parent, "消费记录查询", true);
        this.records = records;
        setSize(800, 500);
        setLocationRelativeTo(parent);
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());
        JPanel conditionPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        conditionPanel.setBorder(new TitledBorder("查询条件"));
        conditionPanel.add(new JLabel("房间号:"));
        roomIdField = new JTextField();
        conditionPanel.add(roomIdField);
        conditionPanel.add(new JLabel("顾客姓名:"));
        customerNameField = new JTextField();
        conditionPanel.add(customerNameField);
        conditionPanel.add(new JLabel("日期范围:"));
        dateRangeCombo = new JComboBox<>(new String[]{"全部", "今日", "本周", "本月"});
        conditionPanel.add(dateRangeCombo);
        JPanel btnPanel = new JPanel();
        JButton queryBtn = new JButton("查询");
        JButton clearBtn = new JButton("清空条件");
        btnPanel.add(queryBtn);
        btnPanel.add(clearBtn);
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane sp = new JScrollPane(resultArea);
        sp.setBorder(new TitledBorder("查询结果"));
        add(conditionPanel, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.CENTER);
        add(sp, BorderLayout.SOUTH);
        queryBtn.addActionListener(e -> performQuery());
        clearBtn.addActionListener(e -> clearConditions());
    }

    private void performQuery() {
        String roomId = roomIdField.getText().trim();
        String customerName = customerNameField.getText().trim();
        String range = (String) dateRangeCombo.getSelectedItem();
        LocalDate now = LocalDate.now();
        List<UsageRecord> filtered = records.stream()
                .filter(r -> r.getEndTime() != null)
                .filter(r -> roomId.isEmpty() || r.getRoom().getRoomId().contains(roomId))
                .filter(r -> customerName.isEmpty() || r.getCustomer().getName().contains(customerName))
                .filter(r -> {
                    LocalDate startDate = r.getStartTime().toLocalDate();
                    switch (range) {
                        case "今日": return startDate.equals(now);
                        case "本周": return startDate.isAfter(now.minusWeeks(1));
                        case "本月": return startDate.getMonth() == now.getMonth() && startDate.getYear() == now.getYear();
                        default: return true;
                    }
                })
                .collect(Collectors.toList());
        if (filtered.isEmpty()) {
            resultArea.setText("未找到符合条件的记录。");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (UsageRecord r : filtered) {
            sb.append("房间: ").append(r.getRoom().getRoomId())
                    .append(" | 顾客: ").append(r.getCustomer().getName())
                    .append("(").append(r.getCustomer().getPhone()).append(")")
                    .append(" | 开始: ").append(r.getStartTime().format(formatter))
                    .append(" | 结束: ").append(r.getEndTime().format(formatter))
                    .append(" | 费用: ").append(String.format("%.2f", r.getCost())).append("元\n");
        }
        resultArea.setText(sb.toString());
    }

    private void clearConditions() {
        roomIdField.setText("");
        customerNameField.setText("");
        dateRangeCombo.setSelectedIndex(0);
        resultArea.setText("");
    }
}
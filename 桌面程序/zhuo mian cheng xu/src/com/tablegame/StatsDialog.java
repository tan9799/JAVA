package com.tablegame;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class StatsDialog extends JDialog {
    private List<UsageRecord> records;
    private JTextField dateField;
    private JTextArea resultArea;

    public StatsDialog(JFrame parent, List<UsageRecord> records) {
        super(parent, "日营业额统计", true);
        this.records = records;
        setSize(500, 400);
        setLocationRelativeTo(parent);
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());
        JPanel top = new JPanel(new FlowLayout());
        top.add(new JLabel("日期 (yyyy-mm-dd):"));
        dateField = new JTextField(10);
        dateField.setText(LocalDate.now().toString());
        JButton queryBtn = new JButton("统计");
        top.add(dateField);
        top.add(queryBtn);
        add(top, BorderLayout.NORTH);
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane sp = new JScrollPane(resultArea);
        sp.setBorder(new TitledBorder("统计结果"));
        add(sp, BorderLayout.CENTER);
        queryBtn.addActionListener(e -> computeStats());
    }

    private void computeStats() {
        try {
            LocalDate target = LocalDate.parse(dateField.getText());
            double total = 0.0;
            int count = 0;
            for (UsageRecord rec : records) {
                if (rec.getEndTime() != null && rec.getEndTime().toLocalDate().equals(target)) {
                    total += rec.getCost();
                    count++;
                }
            }
            resultArea.setText(String.format("日期: %s\n订单数: %d\n总营业额: %.2f 元", target, count, total));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "日期格式错误");
        }
    }
}
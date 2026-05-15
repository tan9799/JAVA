package com.tablegame;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AddRoomDialog extends JDialog {
    private JTextField idField, priceField;
    private JComboBox<String> typeCombo;
    private boolean confirmed = false;
    private String roomId;
    private String roomType;
    private double price;
    private List<Room> existingRooms;

    public AddRoomDialog(JFrame parent, List<Room> rooms) {
        super(parent, "添加房间", true);
        this.existingRooms = rooms;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());
        JPanel form = new JPanel(new GridLayout(3, 2, 5, 5));
        form.add(new JLabel("房间编号:"));
        idField = new JTextField();
        form.add(idField);
        form.add(new JLabel("房间类型:"));
        typeCombo = new JComboBox<>(new String[]{"标准间", "VIP间"});
        form.add(typeCombo);
        form.add(new JLabel("单价(元/小时):"));
        priceField = new JTextField();
        form.add(priceField);
        add(form, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        JButton okBtn = new JButton("确定");
        JButton cancelBtn = new JButton("取消");
        btnPanel.add(okBtn);
        btnPanel.add(cancelBtn);
        add(btnPanel, BorderLayout.SOUTH);

        okBtn.addActionListener(e -> {
            String id = idField.getText().trim();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(this, "请输入房间编号");
                return;
            }
            for (Room r : existingRooms) {
                if (r.getRoomId().equals(id)) {
                    JOptionPane.showMessageDialog(this, "房间号已存在");
                    return;
                }
            }
            double p;
            try {
                p = Double.parseDouble(priceField.getText());
                if (p <= 0) throw new NumberFormatException();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "单价必须是正数");
                return;
            }
            roomId = id;
            roomType = (String) typeCombo.getSelectedItem();
            price = p;
            confirmed = true;
            dispose();
        });
        cancelBtn.addActionListener(e -> dispose());
        setSize(300, 180);
        setLocationRelativeTo(getParent());
    }

    public boolean isConfirmed() { return confirmed; }
    public String getRoomId() { return roomId; }
    public String getRoomType() { return roomType; }
    public double getPrice() { return price; }
}
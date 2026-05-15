package com.tablegame;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StartTimingDialog extends JDialog {
    private JTextField nameField, phoneField;
    private JComboBox<String> strategyCombo;
    private JComboBox<String> memberCombo;
    private boolean confirmed = false;
    private Customer customer;
    private PricingStrategy selectedStrategy;
    private List<Member> members;

    public StartTimingDialog(JFrame parent, Room room, List<Member> members, Customer preCustomer) {
        super(parent, "开始计时 - " + room.getRoomId(), true);
        this.members = members;
        initUI(preCustomer);
    }

    private void initUI(Customer preCustomer) {
        setLayout(new BorderLayout());
        JPanel form = new JPanel(new GridLayout(5, 2, 5, 5));
        form.add(new JLabel("顾客姓名:"));
        nameField = new JTextField();
        if (preCustomer != null) nameField.setText(preCustomer.getName());
        form.add(nameField);
        form.add(new JLabel("联系电话:"));
        phoneField = new JTextField();
        if (preCustomer != null) phoneField.setText(preCustomer.getPhone());
        form.add(phoneField);
        form.add(new JLabel("选择会员:"));
        memberCombo = new JComboBox<>();
        memberCombo.addItem("无会员");
        for (Member m : members) {
            memberCombo.addItem(m.getMemberId() + " - " + m.getName() + " (Lv." + m.getLevel() + ")");
        }
        form.add(memberCombo);
        form.add(new JLabel("计费策略:"));
        strategyCombo = new JComboBox<>(new String[]{
                "普通计费", "周末附加费", "夜间折扣"
        });
        form.add(strategyCombo);
        add(form, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        JButton okBtn = new JButton("确定");
        JButton cancelBtn = new JButton("取消");
        btnPanel.add(okBtn);
        btnPanel.add(cancelBtn);
        add(btnPanel, BorderLayout.SOUTH);

        okBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();
            if (name.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(this, "请填写姓名和电话");
                return;
            }
            // 选择会员
            Member selectedMember = null;
            int memberIdx = memberCombo.getSelectedIndex();
            if (memberIdx > 0 && members.size() >= memberIdx) {
                selectedMember = members.get(memberIdx - 1);
            }
            Customer cust = new Customer(name, phone, selectedMember);
            // 选择策略
            int strategyIdx = strategyCombo.getSelectedIndex();
            switch (strategyIdx) {
                case 0: selectedStrategy = new NormalPricing(); break;
                case 1: selectedStrategy = new WeekendSurchargePricing(); break;
                case 2: selectedStrategy = new TimeSegmentDiscount(); break;
                default: selectedStrategy = new NormalPricing();
            }
            customer = cust;
            confirmed = true;
            dispose();
        });
        cancelBtn.addActionListener(e -> dispose());

        setSize(400, 220);
        setLocationRelativeTo(getParent());
    }

    public boolean isConfirmed() { return confirmed; }
    public Customer getCustomer() { return customer; }
    public PricingStrategy getSelectedStrategy() { return selectedStrategy; }
}
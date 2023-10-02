package com.keith151725;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {
    private JButton btnShopkeeper;
    private JButton btnBuyer;
    private JPanel dashPanel;

    public Dashboard(){

            super("Dashboard Page");
            setContentPane(dashPanel);
            setMinimumSize(new Dimension(600,800));
            setTitle("Duka Dashboard Page");
          //  setLocationRelativeTo(parent);
          //  setModal(true);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setVisible(true);
        btnBuyer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchItem buyerSearch = new SearchItem();
                buyerSearch.setVisible(true);
                dispose();

            }
        });
        btnShopkeeper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AddItems addItems = new AddItems();
                addItems.setVisible(true);
                dispose();

            }
        });
    }

    public static void main(String[] args) {
        Dashboard dashboard = new Dashboard();
    }
}

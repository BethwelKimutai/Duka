package com.keith151725;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItems extends JFrame{
    private JButton btnAdd;
    private JButton btnCancel;
    private JPanel addItemsPanel;

    public AddItems(){

            super("Shopkeeper Add Items");
            setContentPane(addItemsPanel);
            setMinimumSize(new Dimension(600,800));
            setTitle("Shopkeeper Add Items");
           // setLocationRelativeTo(parent);
            //setModal(true);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setVisible(true);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UploadItems upload = new UploadItems();
                upload.setVisible(true);
                dispose();
            }
        });
    }


    public static void main(String[] args) {
        AddItems addItems = new AddItems();
    }

}

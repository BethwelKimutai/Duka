package com.keith151725;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UploadItems extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton uploadButton;
    private JButton cancelButton;
    private JPanel uploadPanel;

    public UploadItems() {
        super("Upload Items");
        setContentPane(uploadPanel);
        setMinimumSize(new Dimension(600,800));
        setTitle("Shopkeeper Add Items");
        // setLocationRelativeTo(parent);
        //setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        UploadItems uploadItems = new UploadItems();
    }
}

package com.keith151725;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ShopkeeperLogin extends JDialog {
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private JPanel shopkeeperLogin;


    public ShopkeeperLogin(JFrame parent){
        super(parent);
        setContentPane(shopkeeperLogin);
        setMinimumSize(new Dimension(300,300));
        setTitle("ShopKeeper Login Page");
        setLocationRelativeTo(parent);
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

               shopkeeper = getAuthentication(email, password);

               if(shopkeeper!=null){
                   dispose();
               }else {

                   JOptionPane.showMessageDialog(ShopkeeperLogin.this, "Invalid User", "Try Again", JOptionPane.ERROR_MESSAGE);
               }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }


    public Shopkeeper shopkeeper;

    private Shopkeeper getAuthentication(String email, String password){

        Shopkeeper shopkeeper = null;
        final String DB_URL = "jdbc:mysql://localhost:3306/dukaap";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try{



            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                shopkeeper = new Shopkeeper();
                shopkeeper.name = resultSet.getString("name");
                shopkeeper.email = resultSet.getString("email");
                shopkeeper.phone = resultSet.getString("phone");
                shopkeeper.address = resultSet.getString("address");
                shopkeeper.password = resultSet.getString("password");
            }

            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return shopkeeper;
    }

    public static void main(String[] args) {
        ShopkeeperLogin loginForm = new ShopkeeperLogin(null);

        Shopkeeper user = loginForm.shopkeeper;
        if (user != null) {
            System.out.println("Successful Authentication of: " + user.name);
            System.out.println("          Email: " + user.email);
            System.out.println("          Phone: " + user.phone);
            System.out.println("          Address: " + user.address);
        }
        else {
            System.out.println("Authentication canceled");
        }
    }
}

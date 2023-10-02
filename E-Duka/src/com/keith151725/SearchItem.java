package com.keith151725;

import javax.swing.*;
import java.awt.*;

public class SearchItem extends JFrame {
    private JTextField txtSearch;
    private JButton btnSearch;
    private JPanel searchPanel;


    public SearchItem(){

            super("Buyer Search Item");
            setContentPane(searchPanel);
            setMinimumSize(new Dimension(700,300));
            setTitle("Buyer Search Item");
            //setLocationRelativeTo(parent);
            //setModal(true);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setVisible(true);
    }

    public static void main(String[] args) {
        SearchItem buyerSearch = new SearchItem();
    }


}

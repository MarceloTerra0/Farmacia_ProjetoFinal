package com.klm.farmacia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JButton button1;
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JTextField textField1;

    public App() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello, World!");
            }
        });
    }
    public void initialize(){
        JFrame jframe = new JFrame("App");
        jframe.setContentPane(new App().panel1);
        //window.dispose
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.pack();
        jframe.setVisible(true);
    }
}

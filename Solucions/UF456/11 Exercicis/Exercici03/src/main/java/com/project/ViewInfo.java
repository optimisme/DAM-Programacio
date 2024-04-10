package com.project;

import javax.swing.*;
import java.awt.*;

public class ViewInfo extends JPanel {

    public JTextArea dataArea = new JTextArea(10, 20);

    public ViewInfo() {
        setLayout(new BorderLayout());
        dataArea.setEditable(false);
        add(new JScrollPane(dataArea), BorderLayout.CENTER);
    }

    public void setData(String name, String phoneNumber, String age, String email) {
        dataArea.setText("Name: " + name + "\nPhone Number: " + phoneNumber + "\nAge: " + age + "\nEmail: " + email);
    }
}


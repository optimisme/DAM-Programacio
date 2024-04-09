package com.project;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JPanel {
    
    public JTextField result;
    public JButton bC = new JButton("C");
    public JButton bAdd = new JButton("+");
    public JButton bSub = new JButton("-");
    public JButton bMul = new JButton("x");
    public JButton bDiv = new JButton("/");
    public JButton bEqual = new JButton("=");
    public JButton b0 = new JButton("0");
    public JButton b1 = new JButton("1");
    public JButton b2 = new JButton("2");
    public JButton b3 = new JButton("3");
    public JButton b4 = new JButton("4");
    public JButton b5 = new JButton("5");
    public JButton b6 = new JButton("6");
    public JButton b7 = new JButton("7");
    public JButton b8 = new JButton("8");
    public JButton b9 = new JButton("9");

    public View() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createVerticalStrut(10));

        result = new JTextField();
        result.setAlignmentX(Component.CENTER_ALIGNMENT);
        result.setEditable(false);
        add(result);

        add(Box.createVerticalStrut(10));

        // panel per als botons
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(5, 4, 10, 10));
        panelButtons.add(bC);
        panelButtons.add(new JLabel());
        panelButtons.add(new JLabel());
        panelButtons.add(bAdd);
        panelButtons.add(b7);
        panelButtons.add(b8);
        panelButtons.add(b9);
        panelButtons.add(bSub);
        panelButtons.add(b4);
        panelButtons.add(b5);
        panelButtons.add(b6);
        panelButtons.add(bMul);
        panelButtons.add(b1);
        panelButtons.add(b2);
        panelButtons.add(b3);
        panelButtons.add(bDiv);
        panelButtons.add(b0);
        panelButtons.add(new JLabel());
        panelButtons.add(new JLabel());
        panelButtons.add(bEqual);

        add(panelButtons);
    }
}

package com.codingbat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BlackJack extends JFrame{
    private JPanel panelWrap;
    private JPanel panelInfo;
    private JPanel panelData;
    private JPanel panelResult;
    private JTextField txtData1;
    private JTextField txtData2;
    private JLabel lblV1;
    private JLabel lblV2;
    private JButton goButton;
    private JTextArea terminal;
    private JPanel panelData1;
    private JPanel panelData2;
    private JPanel panelData3;
    private JLabel lblI1;
    private JLabel lblI2;
    int result;

    public BlackJack(){
        setTitle("BlackJack");
        setSize(600, 500);
        setContentPane(panelWrap);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 255, 255));

        panelInfo.setBackground(Colors.BlueR);
        lblI1.setForeground(Colors.White);
        lblI2.setForeground(Colors.White);
        goButton.setBackground(Colors.Green800);
        goButton.setForeground(Colors.White);
        styleButtons(goButton);

        panelData.setBackground(Colors.BlueR);
        panelData1.setBackground(Colors.BlueR);
        panelData2.setBackground(Colors.BlueR);
        panelData3.setBackground(Colors.BlueR);
        lblV1.setForeground(Colors.White);
        lblV2.setForeground(Colors.White);
        terminal.setEditable(false);

        initComponents();
        initListeners();
    }

    private void styleButtons(JButton btn) {
        btn.setBorder(new EmptyBorder(5, 10, 5, 10));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void initComponents(){
        terminal.append(" -> Bienvenido\n");
    }

    private void initListeners(){
        goButton.addActionListener(new BtnGoButton());
        txtData1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                TxtNumberKeyTyped(keyEvent, txtData1);
            }
        });
        txtData2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                TxtNumberKeyTyped(keyEvent, txtData2);
            }
        });
    }

    private class BtnGoButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (txtData1.getText().length() != 0 && txtData2.getText().length() != 0){
                result = blackJack(Integer.parseInt(txtData1.getText()), Integer.parseInt(txtData2.getText()));
                terminal.append(" -> blackJack("+txtData1.getText()+", "+txtData2.getText()+") → "+result+"\n");
                txtData1.setText("");
                txtData2.setText("");
            } else {
                if (txtData1.getText().length() == 0){
                    JOptionPane.showMessageDialog(null, "Olvidaste el número 1", "Error de variable", JOptionPane.ERROR_MESSAGE);
                } else if (txtData2.getText().length() ==0){
                    JOptionPane.showMessageDialog(null, "Olvidaste el número 2", "Error de variable", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /* solo caracteres numéricos metodo */
    private void TxtNumberKeyTyped(KeyEvent evt, JTextField txt){
        int k = (int) evt.getKeyChar();
        if (k >= 33 && k <= 47 || k >= 58 && k <= 97) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "Solo se permiten caracteres Númericos", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
        } else if (k >= 58) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "Solo se permiten caracteres Númericos", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
        } else if (k == 10) {
            txt.transferFocus();
        }
    }

    public int blackJack(int a, int b){
        int n = 0;
        if (a>0 && b>0){
            if (a>21 && b<=21){
                n = b;
            } else if (b>21 && a<=21){
                n = a;
            } else if (a>21 && b>21){
                n = 0;
            } else {
                int c = 21-a;
                int d = 21-b;
                if (c < d){
                    n = a;
                } else {
                    n = b;
                }
            }
        }
        return n;
    }
}

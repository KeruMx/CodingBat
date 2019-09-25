package com.codingbat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InOrderEqual extends JFrame {
    private JPanel panelWrap;
    private JTextField textN1;
    private JTextField textN2;
    private JTextField textN3;
    private JPanel panelData;
    private JPanel panelResult;
    private JPanel panelInfo;
    private JPanel panelData1;
    private JPanel panelData2;
    private JPanel panelData3;
    private JPanel panelData4;
    private JComboBox cmbEqual;
    private JButton goButton;
    private JTextArea terminal;
    private JLabel lblN1;
    private JLabel lblN2;
    private JLabel lblN3;
    private JLabel lblEq;
    private JLabel lblI1;
    private JLabel lblI2;
    private JLabel lblI3;
    private JTextArea terminalPruebas;
    boolean result, checkEq;

    public InOrderEqual(){
        setTitle("In Order Equals");
        setSize(600, 500);
        setContentPane(panelWrap);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 255, 255));

        panelWrap.setBackground(Colors.BlueR);
        panelInfo.setBackground(Colors.BlueR);
        lblI1.setForeground(Colors.White);
        lblI2.setForeground(Colors.White);
        lblI3.setForeground(Colors.White);

        goButton.setBackground(Colors.Green800);
        goButton.setForeground(Colors.White);
        styleButtons(goButton);
        cmbEqual.setBackground(Colors.White);
        panelData.setBackground(Colors.BlueR);
        panelData1.setBackground(Colors.BlueR);
        panelData2.setBackground(Colors.BlueR);
        panelData3.setBackground(Colors.BlueR);
        panelData4.setBackground(Colors.BlueR);
        lblN1.setForeground(Colors.White);
        lblN2.setForeground(Colors.White);
        lblN3.setForeground(Colors.White);
        lblEq.setForeground(Colors.White);
        terminal.setEditable(false);

        initComponents();
        initListeners();
    }


    private void styleButtons(JButton btn) {
        btn.setBorder(new EmptyBorder(5, 10, 5, 10));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void initComponents(){
        cmbEqual.addItem("True");
        cmbEqual.addItem("False");
        terminal.append(" -> Bienvenido\n");

        prueba(2, 5, 11, false);
        prueba(5, 7, 6, false);
        prueba(5, 5, 7, true);
        prueba(5, 5, 7, false);
        prueba(2, 5, 4, false);
        prueba(3, 4, 3, false);
        prueba(3, 4, 4, false);
        prueba(3, 4, 3, true);
        prueba(3, 4, 4, true);
        prueba(1, 5, 5, true);
        prueba(5, 5, 5, true);
        prueba(2, 2, 1, true);
        prueba(9, 2, 2, true);
        prueba(0, 1, 0, true);
    }

    private void prueba(int a, int b, int c, boolean pruebaCheck){
        result = inOrderEqual(a, b, c, pruebaCheck);
        terminalPruebas.append(" -> inOrderEqual("+a+", "+b+", "+c+", "+pruebaCheck+") → "+result+"\n");
    }

    private void initListeners(){
        goButton.addActionListener(new BtnGoButton());
        textN1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                TxtNumberKeyTyped(keyEvent, textN1);
            }
        });

        textN2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                TxtNumberKeyTyped(keyEvent, textN2);
            }
        });

        textN3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                TxtNumberKeyTyped(keyEvent, textN3);
            }
        });
    }

    private class BtnGoButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (textN1.getText().length() != 0 && textN2.getText().length() != 0 && textN3.getText().length() != 0 ){
                if (cmbEqual.getSelectedIndex() == 0){
                    checkEq = true;
                } else {
                    checkEq = false;
                }
                result = inOrderEqual(Integer.parseInt(textN1.getText()), Integer.parseInt(textN2.getText()), Integer.parseInt(textN3.getText()), checkEq);
                terminal.append(" -> inOrderEqual("+textN1.getText()+", "+textN2.getText()+", "+textN3.getText()+", "+checkEq+") → "+result+"\n");
                textN1.setText("");
                textN2.setText("");
                textN3.setText("");
            } else {
                if (textN1.getText().length() == 0){
                    JOptionPane.showMessageDialog(null, "Olvidaste el número 1", "Error de variable", JOptionPane.ERROR_MESSAGE);
                } else if (textN2.getText().length() ==0){
                    JOptionPane.showMessageDialog(null, "Olvidaste el número 2", "Error de variable", JOptionPane.ERROR_MESSAGE);
                } else if (textN3.getText().length() ==0){
                    JOptionPane.showMessageDialog(null, "Olvidaste el número 3", "Error de variable", JOptionPane.ERROR_MESSAGE);
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

    public boolean inOrderEqual(int a, int b, int c, boolean equalOk) {
        boolean check = false;
        if(equalOk == true){
            if (a <= b && b <= c){
                check = true;
            }
        } else {
            if (a < b && b < c){
                check = true;
            }
        }
        return check;
    }
}

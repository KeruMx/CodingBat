package com.codingbat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

public class WordCount extends JFrame{
    private JPanel panelWrap;
    private JPanel panelInfo;
    private JPanel panelData;
    private JPanel panelResult;
    private JTextArea terminal;
    private JTextField txtCadena;
    private JButton goButton;
    private JLabel lblCadena;
    private JLabel lblI1;
    private JLabel lblI2;
    private JLabel lblI3;
    private JTextArea terminalPruebas;
    int cantPalabras;
    String[] words;
    Map<String, Integer> mapAux;

    public WordCount(){
        setTitle("Word Count");
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

        panelData.setBackground(Colors.BlueR);
        lblCadena.setForeground(Colors.White);
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
        String[] prueba1 = {"a", "b", "a", "c", "b"};
        String[] prueba2 = {"c", "b", "a"};
        String[] prueba3 = {"c", "c", "c", "c"};
        String[] prueba4 = {"this", "and", "this", ""};
        String[] prueba5 = {"x", "y", "x", "Y", "X"};
        String[] prueba6 = {"123", "0", "123", "1"};
        String[] prueba7 = {"d", "a", "e", "d", "a", "d", "b", "b", "z", "a", "a", "b", "z", "x", "b", "f", "x", "two", "b", "one", "two"};
        String[] prueba8 = {"apple", "banana", "apple", "apple", "tea", "coffee", "banana"};
        printResult(prueba1, terminalPruebas);
        printResult(prueba2, terminalPruebas);
        printResult(prueba3, terminalPruebas);
        printResult(prueba4, terminalPruebas);
        printResult(prueba5, terminalPruebas);
        printResult(prueba6, terminalPruebas);
        printResult(prueba7, terminalPruebas);
        printResult(prueba8, terminalPruebas);
    }

    private void printResult(String[] array, JTextArea terminal) {
        mapAux = wordCount(array);
        terminal.append(" -> wordCount([");
        for (int x=0; x<array.length; x++){
            terminal.append("'"+array[x]+"'");
            if (x<array.length-1){
                terminal.append(", ");
            }
        }
        terminal.append("]) → {");
        for (Map.Entry<String, Integer> entry : mapAux.entrySet()) {
            terminal.append("'" + entry.getKey() + "': " + entry.getValue().toString() + " ");
        }
        terminal.append("} \n");
        mapAux.clear();
    }

    private void initListeners(){
        goButton.addActionListener(new BtnGoButton());

        txtCadena.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                TxtNumberKeyTyped(keyEvent, txtCadena);
            }
        });
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

    int cacracterAscii;
    private class BtnGoButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (txtCadena.getText().length() != 0){
                cantPalabras = Integer.parseInt(txtCadena.getText());
                words = new String[cantPalabras];
                for (int x = 0; x < cantPalabras; x++){
                    words[x] = JOptionPane.showInputDialog(null, "Palabra " + (x+1));
                }
                printResult(words, terminal);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor introduce una cantidad correcta", "Error de syntaxis", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public Map<String, Integer> wordCount(String[] strings) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int x = 0; x < strings.length; x++){
            if (map.isEmpty() == true){
                map.put(strings[x], 1);
            } else{
                if(map.containsKey(strings[x]) == true){
                    int oldValue = map.get(strings[x]);
                    map.put(strings[x], (oldValue+1));
                } else {
                    map.put(strings[x], 1);
                }
            }
        }
        return map;
    }
}

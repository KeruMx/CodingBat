package com.codingbat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    String cadenaTemp;
    char readChar;
    int charFound, charCont, i;
    boolean error;
    String[] words;
    Map<String, Integer> mapAux;

    public WordCount(){
        setTitle("Word Count");
        setSize(600, 500);
        setContentPane(panelWrap);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 255, 255));

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
    }

    private void initListeners(){
        goButton.addActionListener(new BtnGoButton());
    }

    int cacracterAscii;
    private class BtnGoButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            error = false;
            charFound = 0;
            charCont = 0;
            if (txtCadena.getText().length() != 0){
                cadenaTemp = txtCadena.getText();
                for (int x=0 ; x < cadenaTemp.length(); x++){
                    readChar = cadenaTemp.charAt(x);
                    cacracterAscii = (int)readChar;
                    if(charFound == 1){
                        if (cacracterAscii != 32 && cacracterAscii != 44){
                            error = true;
                            break;
                        } else {
                            charFound = 0;
                        }
                    } else {
                        if (cacracterAscii != 32 || cacracterAscii != 44){
                            charCont += 1;
                            charFound = 1;
                        }
                    }
                }
                if (error == true){
                    JOptionPane.showMessageDialog(null, "Error de syntaxis", "Error de syntaxis", JOptionPane.ERROR_MESSAGE);
                } else {
                    System.out.println(charCont);
                    i = 0;
                    words = new String[charCont];
                    charFound = 0;
                    for (int x=0 ; x < cadenaTemp.length(); x++){
                        readChar = cadenaTemp.charAt(x);
                        cacracterAscii = (int)readChar;
                        if(charFound == 1){
                            if (cacracterAscii != 32 && cacracterAscii != 44){
                                error = true;
                                System.out.println("Error");
                                break;
                            } else {
                                charFound = 0;
                            }
                        } else {
                            if (cacracterAscii != 32 || cacracterAscii != 44){
                                words[i] = String.valueOf(readChar);
                                i++;
                                charFound = 1;
                            }
                        }
                    }
                    mapAux = wordCount(words);
                    terminal.append(" -> wordCount([");
                    for (int x=0; x<words.length; x++){
                        terminal.append("'"+words[x]+"'");
                        if (x<words.length-1){
                            terminal.append(", ");
                        }
                    }
                    terminal.append("]) → {");
                    for (Map.Entry<String, Integer> entry : mapAux.entrySet()) {
//                        System.out.println(entry.getKey() + ":" + entry.getValue().toString());
                        terminal.append("'" + entry.getKey() + "': " + entry.getValue().toString() + " ");
                    }
                    terminal.append("} \n");
                    txtCadena.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor introduce una cadena correcta", "Error de syntaxis", JOptionPane.ERROR_MESSAGE);
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

package com.codingbat.WarmUp2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Array667 extends JDialog {
//    Given an array of ints, return the number of times that two 6's are next to each other in the array. Also count instances where the second "6" is actually a 7.
Panel panelPrinp = new Panel();
    JButton btnCalcular = new JButton("Calcular");
    JTextField date = new JTextField(8);
    JTextField array = new JTextField(8);
    public Array667(){
        setSize(300,100);
        panelPrinp.setBounds(0,0,300,100);
        panelPrinp.setLayout(new FlowLayout());
        setContentPane(panelPrinp);
        setLocationRelativeTo(null);
        init();
    }
    public void init(){
        JOptionPane.showMessageDialog(null, "Dada una matriz de ints, devuelve el número de veces que dos 6 están uno al\n lado del otro en la matriz. También cuente las instancias donde el segundo \"6\" es en realidad un 7.");
        panelPrinp.add(new Label("Ingresa numeros 6 o 7, separados por comas (,)"));
        panelPrinp.add(array,null);
        panelPrinp.add(btnCalcular,null);
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String s = array.getText();
                String[] ar = s.split(",");
                int[] intar = new int[ar.length];
                for (int i = 0; i < ar.length; i++) {
                    intar[i] = Integer.parseInt(ar[i]);
                }
                JOptionPane.showMessageDialog(null,"Numero de veces que  se repite: "+array667Method(intar));
            }
        });
//        panelPrinp.add(btnCalcular,250,170);
    }
    public int array667Method(int[] num) {
        int cont = 0;
        for (int i=0; i < (num.length-1); i++) {
            if (num[i] == 6) {
                if (num[i+1] == 6 || num[i+1] == 7) {
                    cont++;
                }
            }
        }
        return cont;
    }
}

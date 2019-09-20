package com.codingbat.WarmUp2;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoTriples extends JDialog {
//    Dada una matriz de entradas, diremos que un triple es un valor que aparece 3 veces seguidas en la matriz. Devuelve verdadero si la matriz no contiene triples.
Panel panelPrinp = new Panel();
    JButton btnCalcular = new JButton("Calcular");
    JTextField date = new JTextField(8);
    JTextField array = new JTextField(8);
    public NoTriples(){
        setSize(300,100);
        panelPrinp.setBounds(0,0,300,100);
        panelPrinp.setLayout(new FlowLayout());
        setContentPane(panelPrinp);
        setLocationRelativeTo(null);
        init();
    }
    public void init(){
        JOptionPane.showMessageDialog(null, "Dada una matriz de entradas, diremos que un triple es un valor que aparece 3 veces seguidas en la matriz. Devuelve verdadero si la matriz no contiene triples.");
        panelPrinp.add(new Label("Ingresa numeros, separados por comas (,)"));
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
                if(noTriplesMethod(intar))
                    JOptionPane.showMessageDialog(null,"No contiene Triples");
                else JOptionPane.showMessageDialog(null, "Contiene Triples");
            }
        });
//        panelPrinp.add(btnCalcular,250,170);
    }
    public boolean noTriplesMethod(int[] nums) {
        for (int i=0; i < (nums.length-2); i++) {
            int first = nums[i];
            if (nums[i+1]==first && nums[i+2]==first)
                return false;
        }
        return true;
    }
}

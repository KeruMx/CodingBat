package com.codingbat.LogicTwo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoTeenSum extends JFrame
{
    private JFrame jframe;
    private JPanel panel,panelBotones,panelTextFields,panelTitulo;
    private BoxLayout mainLayout;
    private JTextField textFieldA,textFieldB,textFieldC;
    private JButton btnSalir,btnObtenerResultado;
    private JTextArea txtResultado;
    private JScrollPane scrollTxtResultado;
    private int a,b,c;

    public NoTeenSum (){
        super("NoTeenSum");
        this.createAndAddComponents();
        this.setUndecorated(true);
        this.setSize(500,300);
        this.setContentPane(panel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        jframe = this;
    }

    private void createAndAddComponents(){
        panel = new JPanel();
        panelTitulo = new JPanel();
        panelTitulo.setSize(400,150);
        panelBotones = new JPanel();
        panelTextFields = new JPanel();
        mainLayout = new BoxLayout(panel,BoxLayout.Y_AXIS);
        panel.setLayout(mainLayout);
        panel.setBorder(new EmptyBorder(new Insets(20,20,20,20)));

        FlowLayout layoutBtns_Text = new FlowLayout();
        panelBotones.setLayout(layoutBtns_Text);
        panelTextFields.setLayout(layoutBtns_Text);
        panelTitulo.setLayout(layoutBtns_Text);

        JLabel titulo = new JLabel("<html><body><h2>TwoAsOne</h2> " +
                "<p>Given 3 int values (a b c) return their sum. However, if any</p>" +
                "<p>of the values is a teen in the range 13..19 inclusive then</p>" +
                "<p>that value counts as 0, except 15 and 16 do not count as a teens</p></body></html>");//+

        titulo.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        textFieldA = new JTextField(8);
        textFieldB = new JTextField(8);
        textFieldC = new JTextField(8);

        btnObtenerResultado = new JButton("Caso Unitario");
        btnObtenerResultado.addActionListener(eventos);
        btnObtenerResultado.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSalir = new JButton("X");
        btnSalir.addActionListener(eventos);
        btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));

        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        scrollTxtResultado = new JScrollPane(txtResultado);
        scrollTxtResultado.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        panelBotones.add(btnObtenerResultado);
        panelBotones.add(btnSalir);
        panelTextFields.add(textFieldA);
        panelTextFields.add(textFieldB);
        panelTextFields.add(textFieldC);
        panelTitulo.add(titulo);

        panel.add(panelTitulo);
        panel.add(panelBotones);
        panel.add(panelTextFields);
        panel.add(panelBotones);
        panel.add(scrollTxtResultado);
        hacerCasosDePrueba();
    }

    private ActionListener eventos = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnObtenerResultado){;
                if (verificarEntrada())
                    txtResultado.append("noTeenSum("+a+","+b+","+c+") -> "+noTeenSum()+"\n");
            }if (e.getSource() == btnSalir){
                jframe.dispose();
            }
        }
    };

    private void hacerCasosDePrueba(){
        a=1;b=2;c=3;
        txtResultado.append("noTeenSum("+a+","+b+","+c+") -> "+noTeenSum()+"\n");
        a=3;b=1;c=2;
        txtResultado.append("noTeenSum("+a+","+b+","+c+") -> "+noTeenSum()+"\n");
        a=3;b=2;c=2;
        txtResultado.append("noTeenSum("+a+","+b+","+c+") -> "+noTeenSum()+"\n");
        a=2;b=3;c=1;
        txtResultado.append("noTeenSum("+a+","+b+","+c+") -> "+noTeenSum()+"\n");
        a=5;b=3;c=-2;
        txtResultado.append("noTeenSum("+a+","+b+","+c+") -> "+noTeenSum()+"\n");
        a=5;b=3;c=-3;
        txtResultado.append("noTeenSum("+a+","+b+","+c+") -> "+noTeenSum()+"\n");
        a=2;b=5;c=3;
        txtResultado.append("noTeenSum("+a+","+b+","+c+") -> "+noTeenSum()+"\n");
        a=9;b=5;c=5;
        txtResultado.append("noTeenSum("+a+","+b+","+c+") -> "+noTeenSum()+"\n");
        a=9;b=4;c=5;
        txtResultado.append("noTeenSum("+a+","+b+","+c+") -> "+noTeenSum()+"\n");
        a=5;b=4;c=9;
        txtResultado.append("noTeenSum("+a+","+b+","+c+") -> "+noTeenSum()+"\n");
        a=3;b=3;c=0;
        txtResultado.append("noTeenSum("+a+","+b+","+c+") -> "+noTeenSum()+"\n");
        a=3;b=3;c=2;
        txtResultado.append("noTeenSum("+a+","+b+","+c+") -> "+noTeenSum()+"\n");
        txtResultado.append("\n");
    }

    private int noTeenSum(){
        a = fixTeen(a);
        b = fixTeen(b);
        c = fixTeen(c);
        return (a+b+c);
    }
    private int fixTeen(int n){
        switch(n){
            case 13:
            case 14:
            case 17:
            case 18:
            case 19:
                n=0;
                break;
        }
        return n;
    }

    private boolean verificarEntrada(){
        try{
            a = Integer.parseInt(textFieldA.getText());
            b = Integer.parseInt(textFieldB.getText());
            c = Integer.parseInt(textFieldC.getText());
            return true;
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null,"El número que ingreso es incorrecto","Error",JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
}
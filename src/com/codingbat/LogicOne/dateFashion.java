package com.codingbat.LogicOne;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dateFashion extends JDialog{
    //    Usted y su cita están tratando de conseguir una mesa en un restaurante. El parámetro "usted" es el estilo de su ropa, en el rango 0..10, y "fecha" es el estilo de la ropa de su cita. El resultado de obtener la tabla se codifica como un valor int con 0 = no, 1 = quizás, 2 = sí. Si alguno de ustedes es muy elegante, 8 o más, entonces el resultado es 2 (sí). Con la excepción de que si alguno de ustedes tiene un estilo de 2 o menos, entonces el resultado es 0 (no). De lo contrario, el resultado es 1 (tal vez).
    Panel panelPrinp = new Panel();
    JButton btnCalcular = new JButton("Entrare");
    JTextField date = new JTextField(8);
    JTextField you = new JTextField(8);
    public dateFashion(){
        setSize(300,200);
        panelPrinp.setBounds(0,0,300,200);
        panelPrinp.setLayout(new FlowLayout());
        setContentPane(panelPrinp);
        setLocationRelativeTo(null);
        init();
    }
    public void init(){
        JOptionPane.showMessageDialog(null, "Usted y su cita están tratando  de conseguir una mesa en \n un restaurante. El parámetro  \"usted\" es el estilo de su ropa,\n en el rango 0..10, y \"fecha\" es el estilo de la ropa de su cita. El resultado de obtener la tabla\n se codifica como un valor int con  0 = no, 1 = quizás, 2 = sí. \n Si alguno de ustedes es muy elegante, 8 o más, entonces el resultado es 2 (sí).\nCon la excepción de que si alguno de ustedes tiene un estilo de 2 \no menos, entonces el resultado es 0 (no). De lo contrario, el resultado es 1 (tal vez).");
        panelPrinp.add(new Label("Puntuación  tuya"));
        panelPrinp.add(you,null);
        panelPrinp.add(new Label("Puntuación de tu cita"));
        panelPrinp.add(date,null);
        panelPrinp.add(btnCalcular,null);
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int you1 = Integer.parseInt(you.getText());
                int dat1 = Integer.parseInt(date.getText());
                switch (dateFashionMethod(you1,dat1)){
                    case 0:
                        JOptionPane.showMessageDialog(null,"No hay Mesa Para Uds.");
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null,"Quizá haya Mesa Para Uds.");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null,"Si hay Mesa Para Uds.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"No aplica");
                }
            }
        });
//        panelPrinp.add(btnCalcular,250,170);
    }
    public int dateFashionMethod(int you, int date) {

        if (you > 8 || date > 8) {
            if (you <= 2 || date <= 2)
                return 0;
            return 2;
        } else if (you > 2 || date > 2) {
            if (you <= 2 || date <= 2)
                return 0;
            return 1;
        }
        return 0;
    }

}


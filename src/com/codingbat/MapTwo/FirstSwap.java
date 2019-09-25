package com.codingbat.MapTwo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FirstSwap extends JFrame
{
    private JFrame jframe;
    private JPanel panel,panelBotones,panelTitulo;
    private BoxLayout mainLayout;
    private JButton btnSalir,btnObtenerResultado;
    private JTextArea txtResultado;
    private JScrollPane scrollTxtResultado;
    private Map<Character,Integer> map;
    private ArrayList<String> cadenas;
    private String nuevoArray[];

    public FirstSwap (){
        super("FirstSwap");
        this.createAndAddComponents();
        this.setUndecorated(true);
        this.setSize(550,300);
        this.setContentPane(panel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        jframe = this;
    }

    private void createAndAddComponents(){
        map = new HashMap<Character, Integer>();
        cadenas = new ArrayList<>();
        panel = new JPanel();
        panelTitulo = new JPanel();
        panelTitulo.setSize(400,150);
        panelBotones = new JPanel();
        mainLayout = new BoxLayout(panel,BoxLayout.Y_AXIS);
        panel.setLayout(mainLayout);
        panel.setBorder(new EmptyBorder(new Insets(20,20,20,20)));

        FlowLayout layoutBtns_Text = new FlowLayout();
        panelBotones.setLayout(layoutBtns_Text);
        panelTitulo.setLayout(layoutBtns_Text);

        JLabel titulo = new JLabel("<html><body><h2>FisrtSwap</h2> " +
                "<p>Well say that 2 strings match if they are non-empty and their first chars are the same.</p>" +
                "<p>Loop over and then return the given array of non-empty strings as follows: if a string</p>" +
                "<p>matches an earlier string in the array, swap the 2 strings in the array. A particular first</p>" +
                "<p>char can only cause 1 swap, so once a char caused a swap, its later swaps are" +
                "<p>disabled.</p>" +
                "</p></body></html>");

        titulo.setBorder(BorderFactory.createLineBorder(Color.BLACK));

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
        panelTitulo.add(titulo);

        panel.add(panelTitulo);
        panel.add(panelBotones);
        panel.add(panelBotones);
        panel.add(scrollTxtResultado);
        hacerCasosDePrueba();
    }

    private ActionListener eventos = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnObtenerResultado){
                String temp;
                map.clear();
                cadenas.clear();
                do{
                    temp = JOptionPane.showInputDialog("Teclea elemento de una cadena");
                    cadenas.add(temp);
                    if (temp == null)
                        break;
                }while(!temp.equals("") || temp==null);
                cadenas.remove(cadenas.size()-1);
                nuevoArray = firstSwap();
                plasmarCasoDePrueba();
            }if (e.getSource() == btnSalir){
                jframe.dispose();
            }
        }
    };

    private void hacerCasosDePrueba(){
        cadenas.clear();
        cadenas.add("ab"); cadenas.add("ac");
        nuevoArray = firstSwap();
        plasmarCasoDePrueba();
        cadenas.clear();
        cadenas.add("ax"); cadenas.add("bx"); cadenas.add("cx"); cadenas.add("cy"); cadenas.add("by"); cadenas.add("ay"); cadenas.add("aaa"); cadenas.add("azz");
        nuevoArray = firstSwap();
        plasmarCasoDePrueba();
        cadenas.clear();
        cadenas.add("ax"); cadenas.add("bx"); cadenas.add("ay"); cadenas.add("by"); cadenas.add("ai"); cadenas.add("aj"); cadenas.add("bx"); cadenas.add("by");
        nuevoArray = firstSwap();
        plasmarCasoDePrueba();
        cadenas.clear();
        cadenas.add("ax"); cadenas.add("bx"); cadenas.add("cx"); cadenas.add("ay"); cadenas.add("cy"); cadenas.add("aaa"); cadenas.add("abb");
        nuevoArray = firstSwap();
        plasmarCasoDePrueba();
        cadenas.clear();
        cadenas.add("easy"); cadenas.add("does"); cadenas.add("it"); cadenas.add("every"); cadenas.add("ice"); cadenas.add("eaten");
        nuevoArray = firstSwap();
        plasmarCasoDePrueba();
        cadenas.clear();
        cadenas.add("list"); cadenas.add("of"); cadenas.add("words"); cadenas.add("swims"); cadenas.add("over"); cadenas.add("lily"); cadenas.add("water"); cadenas.add("wait");
        nuevoArray = firstSwap();
        plasmarCasoDePrueba();
        cadenas.clear();
        cadenas.add("4"); cadenas.add("8"); cadenas.add("15"); cadenas.add("16"); cadenas.add("23"); cadenas.add("42");
        nuevoArray = firstSwap();
        plasmarCasoDePrueba();
        cadenas.clear();
        cadenas.add("aaa");
        nuevoArray = firstSwap();
        plasmarCasoDePrueba();
        cadenas.clear();
        nuevoArray = firstSwap();
        plasmarCasoDePrueba();
        cadenas.clear();
        cadenas.add("a"); cadenas.add("b"); cadenas.add("c"); cadenas.add("xx"); cadenas.add("yy"); cadenas.add("zz");
        nuevoArray = firstSwap();
        txtResultado.append("\n");
    }

    private void plasmarCasoDePrueba(){
        txtResultado.append("firstSwap([");
        for (int i=0 ; i<cadenas.size() ; i++){
            txtResultado.append("\""+cadenas.get(i)+"\",");
        }
        txtResultado.append("])  -->  [");
        for (int i=0 ; i<nuevoArray.length ; i++){
            txtResultado.append("\""+nuevoArray[i]+"\",");
        }
        txtResultado.append("]\n");
    }

    private String[] firstSwap() {
        String array[] = new String[cadenas.size()];
        int temp;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0 ; i<cadenas.size() ; i++){
            if(map.containsKey(cadenas.get(i).charAt(0))  &&  map.get(cadenas.get(i).charAt(0))!=-1){
                array[i] = cadenas.get(map.get(cadenas.get(i).charAt(0)));
                array[map.get(cadenas.get(i).charAt(0))] = cadenas.get(i);
                map.remove( cadenas.get(i).charAt(0) );
                map.put( cadenas.get(i).charAt(0), -1 );
            }else{
                array[i] = cadenas.get(i);
            }
            if(  !map.containsKey(cadenas.get(i).charAt(0))  ){
                map.put(cadenas.get(i).charAt(0),i);
            }
        }
        return array;
    }
}
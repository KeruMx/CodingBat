package com.codingbat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Cursor;

public class Index_View extends JFrame{
    private JPanel panelWrap;
    private JPanel panelTableContent;
    private JTable tableProgramsInfo;
    private JComboBox cmbFiltro;
    private JButton btnFiltro;
    private JPanel panelFiltro;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;
    JMenuBar mb = new JMenuBar();
//    JMenu logic;
    JMenu exit;
    JMenu about;
    private DefaultTableModel modelData;

    public Index_View(){
        setTitle("Parcial 1");
        setSize(WIDTH, HEIGHT);
        setContentPane(panelWrap);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 255, 255));
//        logic = new JMenu("Logic 1");
//        mb.add(logic);
        about = new JMenu("Acerca de");
        mb.add(about);
        exit = new JMenu("Salir");
        mb.add(exit);
        mb.setBackground(new Color(66, 66, 66));
//        logic.setForeground(new Color(255, 255 ,255));
        about.setForeground(new Color(255, 255 ,255));
        exit. setForeground(new Color(255, 255, 255));
        setJMenuBar(mb);

        btnFiltro.setBackground(Colors.Green800);
        btnFiltro.setForeground(Colors.White);
        styleButtons(btnFiltro);

        String x[][] = {};
        String columnas[] = {"Nombre", "Categoria", "Nivel de dificultad"};
        modelData = new DefaultTableModel(x, columnas);
        tableProgramsInfo.setModel(modelData);

        initListeners();
    }

    private void initListeners() {
//        logic.addMenuListener(new MenuListener() {
//            @Override
//            public void menuSelected(MenuEvent e) {
//
//            }
//
//            @Override
//            public void menuDeselected(MenuEvent e) {
//            }
//
//            @Override
//            public void menuCanceled(MenuEvent e) {
//            }
//        });

        about.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                JOptionPane.showMessageDialog(null, "Proyecto Ingenieria de software,\n Instituto Tecnológico de México en Celaya \n Copyright 2019");
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });

        exit.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                System.exit(0);
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });
    }

    private void styleButtons(JButton btn) {
        btn.setBorder(new EmptyBorder(5, 10, 5, 10));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public JButton getBtnFiltro() {
        return btnFiltro;
    }

    public JComboBox getCmbFiltro() {
        return cmbFiltro;
    }

    public JTable getTableProgramsInfo() {
        return tableProgramsInfo;
    }
}

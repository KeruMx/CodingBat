package com.codingbat;


//////// ---------------------- CONTROLLER ---------------------- /////////

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerIndex {
    private Index_View index_view;
    private JButton btnFiltro;
    private JComboBox cmbFiltro;
    static DefaultTableModel modelData;
    private JTable tableInfoPrograms;

    public ControllerIndex(){
        index_view = new Index_View();
        initComponents();
        initListeners();
    }

    public void show(){
        index_view.setVisible(true);
    }

    private void initComponents(){
        btnFiltro = index_view.getBtnFiltro();
        tableInfoPrograms = index_view.getTableProgramsInfo();
        modelData = (DefaultTableModel) tableInfoPrograms.getModel();

        cmbFiltro = index_view.getCmbFiltro();
        cmbFiltro.addItem("Logic 1");
        cmbFiltro.addItem("Logic 2");
    }

    private void initListeners(){
        btnFiltro.addActionListener(new BtnFiltroListener());
    }

    private class BtnFiltroListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JOptionPane.showMessageDialog(null, "Aquí va el método para filtrar");
        }
    }
}

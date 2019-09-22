package com.codingbat;


//////// ---------------------- CONTROLLER ---------------------- /////////

import com.codingbat.LogicOne.TwoAsOne;
import com.codingbat.LogicOne.dateFashion;
import com.codingbat.LogicTwo.NoTeenSum;
import com.codingbat.WarmUp2.Array667;
import com.codingbat.WarmUp2.NoTriples;
import javafx.application.Application;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
        cmbFiltro.addItem("Warmup-2");
        cmbFiltro.addItem("Logic 1");
        cmbFiltro.addItem("Logic 2");
        cmbFiltro.addItem("Map-2");
    }

    private void initListeners(){
        btnFiltro.addActionListener(new BtnFiltroListener());
        tableInfoPrograms.addMouseListener(new Eventos());

    }

    private class BtnFiltroListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            for (int i=tableInfoPrograms.getRowCount()-1; i>=0; i--) {
                modelData.removeRow(modelData.getRowCount()-1);
            }
            if (cmbFiltro.getSelectedIndex() == 0){
                modelData.addRow(new Object[]{"noTriples","Warmup-2","6 Estrellas (Cumplimiento)"});
                modelData.addRow(new Object[]{"array667","Warmup-2","6 Estrellas (Cumplimiento)"});
            }
            if (cmbFiltro.getSelectedIndex() == 1){
                modelData.addRow(new Object[]{"twoAsOne","Logic-1","8 Estrellas (Cumplimiento)"});
                modelData.addRow(new Object[]{"dateFashion","Logic-1","8 Estrellas (Cumplimiento)"});
                modelData.addRow(new Object[]{"inOrderEqual","Logic-1","8 Estrellas (Cumplimiento)"});
            }
            if (cmbFiltro.getSelectedIndex() == 2){
                modelData.addRow(new Object[]{"noTeenSum","Logic-2","3 Estrellas (Cumplimiento)"});
                modelData.addRow(new Object[]{"blackjack","Logic-2","3 Estrellas (Cumplimiento)"});
            }
            if (cmbFiltro.getSelectedIndex() == 3){
                modelData.addRow(new Object[]{"wordCount","Map-2","3 Estrellas (Cumplimiento)"});
                modelData.addRow(new Object[]{"firstSwap","Map-2","3 Estrellas (Cumplimiento)"});
            }
        }
    }

    public class Eventos implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (cmbFiltro.getSelectedIndex() == 0){
               if (tableInfoPrograms.getSelectedRow() == 0){
                   NoTriples noTriples = new NoTriples();
                   noTriples.setVisible(true);
               }else{
                   Array667 array667 = new Array667();
                   array667.setVisible(true);
               }
            }
            if (cmbFiltro.getSelectedIndex() == 1){
                if (tableInfoPrograms.getSelectedRow() == 0)
                    new TwoAsOne();
                if (tableInfoPrograms.getSelectedRow() == 1){
                    //DateFashion
                    dateFashion dateFashionrn = new dateFashion();
                    dateFashionrn.setVisible(true);
                }
                if (tableInfoPrograms.getSelectedRow() == 2){
                    //InOrderEqual
                    InOrderEqual inOrderEqual = new InOrderEqual();
                    inOrderEqual.setVisible(true);
                }
            }
            if (cmbFiltro.getSelectedIndex() == 2){
                if (tableInfoPrograms.getSelectedRow() == 0)
                    new NoTeenSum();
                else{
                    //BlackJack
                }
            }
            if (cmbFiltro.getSelectedIndex() == 3){
                if (tableInfoPrograms.getSelectedRow() == 0){
                    //WordCount
                }else{
                    //FirstSwap
                }
            }
            System.out.println(tableInfoPrograms.getSelectedRow()+"\t"+tableInfoPrograms.getSelectedRowCount());
        }

        @Override public void mousePressed(MouseEvent e) { }
        @Override public void mouseReleased(MouseEvent e) { }
        @Override public void mouseEntered(MouseEvent e) { }
        @Override public void mouseExited(MouseEvent e) { }
    }
}

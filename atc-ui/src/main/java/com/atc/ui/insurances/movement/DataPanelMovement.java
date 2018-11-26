package com.atc.ui.insurances.movement;
import com.atc.model.Movement;
import com.atc.model.Product;
import com.atc.service.InventoryService;
import com.atc.service.MovementService;
import com.atc.service.ProductService;
import com.atc.ui.abstractUI.DataPanelAbstract;
import com.atc.util.InputsVerifier;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataPanelMovement extends DataPanelAbstract<Movement> implements ActionListener {

    private JComboBox<Product> companyBox;
    private JDateChooser dateChooser;
    private JPanel headerPanel;
    private JComboBox<String> typeBox;
    private JCheckBox isUrbanCheck;
    private JButton calculateButton;
    private JTextField quantityField;
    private JTextField numerationField;
    private JTextField facVidaField;
    private JDateChooser payVidaField;
    private JTextField reciboField;
    private JTextField remRCEField;
    private JTextField facRCEField;
    private JDateChooser payRCEField;
    private JTextField remTransField;
    private JTextField facTransField;
    private JDateChooser payTransField;

    private JComboBox jcm;
    private JComboBox jcy;

    public DataPanelMovement(Movement movement) {
        super();
        if(movement == null) {
            data = new Movement();
        } else {
            data = movement;
            fillData();
        }
    }

    @Override
    protected void setLabelArray() {
        for(String str : StringsConstants.MOVEMENT_FIELDS) {
            labelArray.add(new JLabel(str));
        }
    }

    @Override
    protected void setComponentArray() {
        componentArray.add(companyBox);
        componentArray.add(dateChooser);
        componentArray.add(headerPanel);
        componentArray.add(calculateButton);
        componentArray.add(quantityField);
        componentArray.add(numerationField);
        componentArray.add(facVidaField);
        componentArray.add(payVidaField);
        componentArray.add(reciboField);
        componentArray.add(remRCEField);
        componentArray.add(facRCEField);
        componentArray.add(payRCEField);
        componentArray.add(remTransField);
        componentArray.add(facTransField);
        componentArray.add(payTransField);
    }

    @Override
    protected void setDataPanel() {
        quantityField = new JTextField(NumberConstants.MOVEMENT_FIELD);
        quantityField.setInputVerifier(InputsVerifier.INSTANCE.isNumberNull);
        ProductService productService = new ProductService();
        payTransField = new JDateChooser();
        payTransField.setDateFormatString("dd/MM/yyyy");
        facTransField = new JTextField(NumberConstants.MOVEMENT_FIELD);
        remTransField = new JTextField(NumberConstants.MOVEMENT_FIELD);
        payRCEField = new JDateChooser();
        payRCEField.setDateFormatString("dd/MM/yyyy");
        facRCEField = new JTextField(NumberConstants.MOVEMENT_FIELD);
        remRCEField = new JTextField(NumberConstants.MOVEMENT_FIELD);
        reciboField = new JTextField(NumberConstants.MOVEMENT_FIELD);
        payVidaField = new JDateChooser();
        payVidaField.setDateFormatString("dd/MM/yyyy");
        facVidaField = new JTextField(NumberConstants.MOVEMENT_FIELD);
        numerationField = new JTextField(NumberConstants.MOVEMENT_FIELD);
        numerationField.setEditable(false);
        isUrbanCheck = new JCheckBox(StringsConstants.IS_URBANO);
        isUrbanCheck.addActionListener(this);
        typeBox = new JComboBox<>(StringsConstants.TYPE_OPTIONS);
        calculateButton = new JButton(StringsConstants.CALCULATE_NUMERATION);
        calculateButton.addActionListener(this);
        headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());
        headerPanel.add(typeBox);
        headerPanel.add(isUrbanCheck);
        companyBox = new JComboBox(productService.getAllProducts());
        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy");
    }

    @Override
    public boolean saveData() {
        if(dateChooser.getDate() != null) {
            data.setDate(dateChooser.getDate());
            data.setProduct((Product) companyBox.getSelectedItem());
            if(isUrbanCheck.isSelected()) {
                selectMonth();
                data.setNumeration(
                        "URBANO - " + jcm.getSelectedItem() + "/" + jcy.getSelectedItem());
                data.setQuantity(0);
            } else if(!numerationField.getText().isEmpty() && !quantityField.getText().isEmpty()) {
                data.setNumeration(numerationField.getText());
                data.setQuantity(Integer.valueOf(quantityField.getText()));
            } else {
                JOptionPane.showMessageDialog(this, StringsConstants.INCOMPLETE_DATA_MESSAGE);
                numerationField.setBackground(Color.red);
                quantityField.setBackground(Color.red);
                return false;
            }
            data.setFactVida(facVidaField.getText());
            data.setRecibo(reciboField.getText());
            data.setPayVida(payVidaField.getDate());
            data.setRemRCE(remRCEField.getText());
            data.setFactRCE(facRCEField.getText());
            data.setPayRCE(payRCEField.getDate());
            data.setRemTransporte(remTransField.getText());
            data.setFactTransp(facTransField.getText());
            data.setPayTransporte(payTransField.getDate());
            MovementService.INSTANCE.update(data);
            return true;
        } else {
            JOptionPane.showMessageDialog(this, StringsConstants.INCOMPLETE_DATA_MESSAGE);
            dateChooser.setBackground(Color.red);
            return false;
        }
    }

    private void selectMonth() {
        String[] month = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        String[] year = {"2018", "2019", "2020"};
        jcm = new JComboBox(month);
        jcy = new JComboBox(year);
        jcm.setEditable(true);
        jcy.setEditable(true);
        //create a JOptionPane
        Object[] options = new Object[]{};
        JOptionPane jop = new JOptionPane("Please Select",
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.DEFAULT_OPTION,
                null, options, null);
        //add combos to JOptionPane
        jop.add(jcm);
        jop.add(jcy);
        //create a JDialog and add JOptionPane to it
        JDialog diag = new JDialog();
        diag.getContentPane().add(jop);
        diag.pack();
        diag.setVisible(true);
    }

    @Override
    public void fillData() {
    }

    private void validateField() {
        if(isUrbanCheck.isSelected()) {
            calculateButton.setEnabled(false);
            quantityField.setEnabled(false);
            remTransField.setEnabled(false);
            facTransField.setEnabled(false);
            payTransField.setEnabled(false);
        } else {
            calculateButton.setEnabled(true);
            quantityField.setEnabled(true);
            remTransField.setEnabled(true);
            facTransField.setEnabled(true);
            payTransField.setEnabled(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(isUrbanCheck)) {
            validateField();
        } else if(e.getSource().equals(calculateButton)) {
            calculateNumeration();
        }
    }

    private void calculateNumeration() {
        if(quantityField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, StringsConstants.ADD_MOVIMIENTO_INGRESE_NUMERO,
                    StringsConstants.APP_NAME, JOptionPane.ERROR_MESSAGE);
        } else {
            String st =
                    InventoryService.INSTANCE.calculateNumeration(typeBox.getSelectedItem(),
                            Integer.parseInt(quantityField.getText()));
            numerationField.setText(st);
        }
    }
}

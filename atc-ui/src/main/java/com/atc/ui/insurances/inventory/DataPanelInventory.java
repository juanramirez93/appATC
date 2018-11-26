package com.atc.ui.insurances.inventory;
import com.atc.model.Inventory;
import com.atc.service.InventoryService;
import com.atc.ui.abstractUI.DataPanelAbstract;
import com.atc.util.InputsVerifier;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class DataPanelInventory extends DataPanelAbstract<Inventory> {

    private JDateChooser dateChooser;
    private JComboBox<String> typeBox;
    private JComboBox<String> detailBox;
    private JTextField startField;
    private JTextField endField;

    public DataPanelInventory(Inventory inventory) {
        super();
        if(inventory == null) {
            data = new Inventory();
        } else {
            data = inventory;
            fillData();
        }
    }

    @Override
    protected void setLabelArray() {
        for(String str : StringsConstants.INVENTORY_FIELDS) {
            labelArray.add(new JLabel(str));
        }
    }

    @Override
    protected void setComponentArray() {
        componentArray.add(dateChooser);
        componentArray.add(typeBox);
        componentArray.add(detailBox);
        componentArray.add(startField);
        componentArray.add(endField);
    }

    @Override
    protected void setDataPanel() {
        dateChooser = new JDateChooser(new Date());
        dateChooser.setDateFormatString("dd/MM/yyyy");
        typeBox = new JComboBox<>(StringsConstants.TYPE_OPTIONS);
        detailBox = new JComboBox<>(StringsConstants.INVENTORY_OPTIONS);
        startField = new JTextField(NumberConstants.INVENTORY_FIELD);
        startField.setInputVerifier(InputsVerifier.INSTANCE.isNumberNull);
        endField = new JTextField(NumberConstants.INVENTORY_FIELD);
        endField.setInputVerifier(InputsVerifier.INSTANCE.isNumberNull);
    }

    @Override
    public boolean saveData() {
        if(!startField.getText().isEmpty() && !endField.getText().isEmpty()) {
            data.setDate(dateChooser.getDate());
            data.setProduct((String) typeBox.getSelectedItem());
            data.setDetail((String) detailBox.getSelectedItem());
            int start = Integer.valueOf(startField.getText());
            data.setStart(start);
            int end = Integer.valueOf(endField.getText());
            data.setEnd(end);
            data.setNext(start);
            data.setRemaining(end - start + 1);
            InventoryService.INSTANCE.update(data);
            return true;
        } else {
            JOptionPane.showMessageDialog(this, StringsConstants.INCOMPLETE_DATA_MESSAGE);
            startField.setBackground(Color.red);
            endField.setBackground(Color.red);
            return false;
        }
    }

    @Override
    public void fillData() {
    }
}

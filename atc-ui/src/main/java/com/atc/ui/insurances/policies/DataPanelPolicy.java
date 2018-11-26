package com.atc.ui.insurances.policies;
import com.atc.model.Policy;
import com.atc.service.PolicyService;
import com.atc.ui.abstractUI.DataPanelAbstract;
import com.atc.util.InputsVerifier;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;

public class DataPanelPolicy extends DataPanelAbstract<Policy> {

    private JTextField numberField;
    private JComboBox<String> branchField;
    private JTextField costField;
    private JTextField urbanCostField;
    private JDateChooser startField;
    private JDateChooser endField;
    private JTextField commissionField;
    private JTextField stateField;

    private PolicyService policyService;

    public DataPanelPolicy(Policy policy) {
        super();
        if(policy == null) {
            data = new Policy();
        } else {
            data = policy;
            fillData();
        }
    }

    @Override
    protected void setLabelArray() {
        for(String str : StringsConstants.POLICY_FIELDS) {
            labelArray.add(new JLabel(str));
        }
    }

    @Override
    protected void setComponentArray() {
        componentArray.add(numberField);
        componentArray.add(branchField);
        componentArray.add(costField);
        componentArray.add(urbanCostField);
        componentArray.add(startField);
        componentArray.add(endField);
        componentArray.add(commissionField);
        componentArray.add(stateField);
    }

    @Override
    protected void setDataPanel() {
        numberField = new JTextField(NumberConstants.POLICY_FIELD);
        numberField.setInputVerifier(InputsVerifier.INSTANCE.policyExistAndIsNumber);
        branchField = new JComboBox<>(StringsConstants.BRANCHES_ARRAY);
        costField = new JTextField(NumberConstants.POLICY_FIELD);
        costField.setInputVerifier(InputsVerifier.INSTANCE.isNumberNull);
        urbanCostField = new JTextField(NumberConstants.POLICY_FIELD);
        urbanCostField.setInputVerifier(InputsVerifier.INSTANCE.isNumberNull);
        startField = new JDateChooser();
        startField.setDateFormatString("dd/MM/yyyy");
        startField.setSize(costField.getSize());
        endField = new JDateChooser();
        endField.setDateFormatString("dd/MM/yyyy");
        endField.setSize(costField.getSize());
        commissionField = new JTextField(NumberConstants.POLICY_FIELD);
        commissionField.setInputVerifier(InputsVerifier.INSTANCE.isNumberNull);
        stateField = new JTextField(NumberConstants.POLICY_FIELD);
        stateField.setEnabled(false);

        policyService = new PolicyService();
    }

    @Override
    public boolean saveData() {
        if(!numberField.getText().isEmpty()) {
            data.setNumber(numberField.getText());
            data.setBranch((String) branchField.getSelectedItem());
            if(!costField.getText().isEmpty()) {
                data.setCost(Integer.valueOf(costField.getText()));
            }
            if(!urbanCostField.getText().isEmpty()) {
                data.setUrbanCost(Integer.valueOf(urbanCostField.getText()));
            }
            data.setStartValidity(startField.getDate());
            data.setEndValidity(endField.getDate());
            if(!commissionField.getText().isEmpty()) {
                data.setAtcCommission(Integer.valueOf(commissionField.getText()));
            }
            policyService.update(data);

            return true;
        } else {
            JOptionPane.showMessageDialog(this, StringsConstants.INCOMPLETE_DATA_MESSAGE);
            numberField.setBackground(Color.red);
            return false;
        }
    }

    @Override
    public void fillData() {

        numberField.setText(data.getNumber());
        numberField.setEnabled(false);

        branchField.setSelectedItem(data.getBranch());
        costField.setText(String.valueOf(data.getCost()));
        urbanCostField.setText(String.valueOf(data.getUrbanCost()));
        startField.setDate(data.getStartValidity());
        endField.setDate(data.getEndValidity());
        commissionField.setText(String.valueOf(data.getAtcCommission()));
        stateField.setText(data.getState());
    }

}

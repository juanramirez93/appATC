package com.atc.ui.insurances.product;
import com.atc.model.Empresa;
import com.atc.model.Policy;
import com.atc.model.Product;
import com.atc.service.PolicyService;
import com.atc.service.ProductService;
import com.atc.service.empresa.EmpresaService;
import com.atc.ui.abstractUI.DataPanelAbstract;
import com.atc.ui.empresa.AddEmpresa;
import com.atc.ui.insurances.policies.CEPolicy;
import com.atc.util.InputsVerifier;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;

import javax.swing.*;
import java.awt.*;

public class DataPanelProduct extends DataPanelAbstract<Product> {

    private JTextField NITField;
    private JTextField nameField;
    private JComboBox<String> modalityBox;
    private JTextField vidaField;
    private JTextField sellVidaField;
    private JTextField urbanVidaField;
    private JTextField sellUrbanVidaField;
    private JTextField RCEField;
    private JTextField urbanRCEField;
    private JTextField transporteField;

    public DataPanelProduct(Product product) {
        super();
        if(product == null) {
            data = new Product();
        } else {
            data = product;
            fillData();
        }
    }

    @Override
    protected void setLabelArray() {
        for(String str : StringsConstants.PRODUCT_FIELDS) {
            labelArray.add(new JLabel(str));
        }
    }

    @Override
    protected void setComponentArray() {
        componentArray.add(NITField);
        componentArray.add(nameField);
        componentArray.add(modalityBox);
        componentArray.add(vidaField);
        componentArray.add(sellVidaField);
        componentArray.add(urbanVidaField);
        componentArray.add(sellUrbanVidaField);
        componentArray.add(RCEField);
        componentArray.add(urbanRCEField);
        componentArray.add(transporteField);
    }

    @Override
    protected void setDataPanel() {
        EmpresaService empresaService = new EmpresaService();
        PolicyService policyService = new PolicyService();
        NITField = new JTextField(NumberConstants.PRODUCT_FIELD);
        AutoCompleteDecorator.decorate(NITField, empresaService.getNits(), false,
                ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
        nameField = new JTextField(NumberConstants.PRODUCT_FIELD);
        NITField.setInputVerifier(InputsVerifier.INSTANCE.existEmpresa(nameField,
                new AddEmpresa(null)));
        modalityBox = new JComboBox<>(StringsConstants.MODALITY_OPTIONS);
        vidaField = new JTextField(NumberConstants.PRODUCT_FIELD);
        AutoCompleteDecorator.decorate(vidaField, policyService.getAllVidaNumber(), false,
                ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
        vidaField.setInputVerifier(InputsVerifier.INSTANCE.existPolicy("Vida", new CEPolicy(null,
                null)));
        sellVidaField = new JTextField(NumberConstants.PRODUCT_FIELD);
        urbanVidaField = new JTextField(NumberConstants.PRODUCT_FIELD);
        sellUrbanVidaField = new JTextField(NumberConstants.PRODUCT_FIELD);
        RCEField = new JTextField(NumberConstants.PRODUCT_FIELD);
        AutoCompleteDecorator.decorate(vidaField, policyService.getAllRCENumber(), false,
                ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
        RCEField.setInputVerifier(InputsVerifier.INSTANCE.existPolicy("RCE", new CEPolicy(null,
                null)));
        urbanRCEField = new JTextField(NumberConstants.PRODUCT_FIELD);
        transporteField = new JTextField(NumberConstants.PRODUCT_FIELD);
        AutoCompleteDecorator.decorate(vidaField, policyService.getAllTransporteNumber(), false,
                ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
        transporteField.setInputVerifier(InputsVerifier.INSTANCE.existPolicy("Transporte",
                new CEPolicy(null, null)));
    }

    @Override
    public boolean saveData() {
        if(!NITField.getText().isEmpty()) {
            if(vidaField.getText().isEmpty() && RCEField.getText().isEmpty() &&
                    transporteField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, StringsConstants.SET_POLICY_MESSAGE);
                return false;
            } else {
                ProductService productService = new ProductService();
                EmpresaService empresaService = new EmpresaService();
                PolicyService policyService = new PolicyService();
                Empresa empresa = empresaService.findByNit(Long.valueOf(NITField.getText()));
                data.setEmpresa(empresa);
                data.setModality(String.valueOf(modalityBox.getSelectedItem()));
                data.addPolicy(policyService.getPolicyByNumber(vidaField.getText()));
                if(!sellVidaField.getText().isEmpty()) {
                    data.setSellVida(Integer.valueOf(sellVidaField.getText()));
                } else if(!vidaField.getText().isEmpty() && sellVidaField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, StringsConstants.INCOMPLETE_DATA_MESSAGE);
                    sellVidaField.setBackground(Color.red);
                    return false;
                }
                if(!urbanVidaField.getText().isEmpty()) {
                    data.setUrbanVida(Integer.valueOf(urbanVidaField.getText()));
                }
                if(!sellUrbanVidaField.getText().isEmpty()) {
                    data.setSellUrbVida(Integer.valueOf(urbanVidaField.getText()));
                }
                data.addPolicy(policyService.getPolicyByNumber(RCEField.getText()));
                if(!urbanRCEField.getText().isEmpty()) {
                    data.setUrbanRCE(Integer.valueOf(urbanRCEField.getText()));
                }
                data.addPolicy(policyService.getPolicyByNumber(transporteField.getText()));
                productService.update(data);
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(this, StringsConstants.INCOMPLETE_DATA_MESSAGE);
            NITField.setBackground(Color.red);
            return false;
        }
    }

    @Override
    public void fillData() {
        NITField.setText("" + data.getEmpresa().getNit());
        nameField.setText(data.getEmpresa().getNombre());
        modalityBox.setSelectedItem(data.getModality());
        for(Policy policy : data.getPolicies()) {
            switch(policy.getBranch()) {
                case "Vida":
                    vidaField.setText(policy.getNumber());
                    break;
                case "RCE":
                    RCEField.setText(policy.getNumber());
                    break;
                case "Transporte":
                    transporteField.setText(policy.getNumber());
                    break;
            }
        }
        sellVidaField.setText(String.valueOf(data.getSellVida()));
        urbanVidaField.setText(String.valueOf(data.getUrbanVida()));
        sellUrbanVidaField.setText(String.valueOf(data.getSellUrbVida()));
        RCEField.setText(String.valueOf(data.getRCE()));
        urbanRCEField.setText(String.valueOf(data.getUrbanRCE()));
        transporteField.setText(String.valueOf(data.getTransporte()));
    }
}

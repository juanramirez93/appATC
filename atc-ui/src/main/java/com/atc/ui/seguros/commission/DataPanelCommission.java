package com.atc.ui.seguros.commission;
import com.atc.model.ComisionSeguros;
import com.atc.model.Empleado;
import com.atc.model.Producto;
import com.atc.service.EmpleadoService;
import com.atc.service.ProductoService;
import com.atc.ui.abstractUI.DataPanelAbstract;
import com.atc.util.InputsVerifier;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.*;

public class DataPanelCommission extends DataPanelAbstract<ComisionSeguros> {

    private JComboBox<Empleado> empleadoBox;
    private JComboBox<String> branchBox;
    private JTextField commissionField;
    private Producto producto;

    public DataPanelCommission(ComisionSeguros comisionSeguros, MainCommission mainCommission) {
        super();
        this.producto = mainCommission.getProducto();
        if(comisionSeguros == null) {
            data = new ComisionSeguros();
        } else {
            data = comisionSeguros;
            fillData();
        }
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    protected void setLabelArray() {
        for(String str : StringsConstants.COMMISSION_FIELDS) {
            labelArray.add(new JLabel(str));
        }
    }

    @Override
    protected void setComponentArray() {
        componentArray.add(empleadoBox);
        componentArray.add(branchBox);
        componentArray.add(commissionField);
    }

    @Override
    protected void setDataPanel() {
        empleadoBox = new JComboBox<>(EmpleadoService.INSTANCE.getAllEmpleados());
        branchBox = new JComboBox<>(StringsConstants.BRANCHES_ARRAY);
        commissionField = new JTextField(NumberConstants.COMISSION_FIELD);
        commissionField.setInputVerifier(InputsVerifier.INSTANCE.isNumberNull);
    }

    @Override
    public boolean saveData() {
        if(!commissionField.getText().isEmpty()) {
            data.setAsesor((Empleado) empleadoBox.getSelectedItem());
            data.setRamo((String) branchBox.getSelectedItem());
            data.setComision(Integer.valueOf(commissionField.getText()));
            producto.addComision(data);
            ProductoService.INSTANCE.update(producto);
            return true;
        } else {
            JOptionPane.showMessageDialog(this, StringsConstants.INCOMPLETE_DATA_MESSAGE);
            commissionField.setBackground(Color.red);
            return false;
        }
    }

    @Override
    public void fillData() {
    }
}

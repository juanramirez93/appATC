package com.atc.ui.vehiculo;

import com.atc.model.Vehiculo;
import com.atc.ui.abstractUI.DataPanelAbstract;
import com.atc.util.InputsVerifier;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DataPanelVehiculos extends DataPanelAbstract<Vehiculo> {

    /**
     *
     */
    private static final long serialVersionUID = 5188551825416339748L;

    private ArrayList<JComponent> labelsArray;
    private ArrayList<JComponent> fieldsArray;

    private JLabel placaLabel;
    private JTextField placaField;

    private JLabel servicioLabel;
    private JComboBox<String> servicioField;

    private JLabel claseLabel;
    private JTextField claseField;

    private JLabel marcaLabel;
    private JTextField marcaField;

    private JLabel lineaLabel;
    private JTextField lineaField;

    private JLabel modeloLabel;
    private JTextField modeloField;



    public DataPanelVehiculos(Vehiculo vehiculo) {
        super();
        initializeVariables();
        initilizeLayout();
        insertLayout();
    }

    private void initializeVariables() {
        labelsArray = new ArrayList<>();
        fieldsArray = new ArrayList<>();

        placaLabel = new JLabel(StringsConstants.VEHICULO_PLACA);
        placaField = new JTextField(NumberConstants.VEHICULO_FIELD);
        placaField.setInputVerifier(InputsVerifier.INSTANCE.existVehicle);

        servicioLabel = new JLabel(StringsConstants.VEHICULO_SERVICIO);
        String[] servicioStr = {
                "Público",
                "Particular"
        };
        servicioField = new JComboBox<>(servicioStr);

        claseLabel = new JLabel(StringsConstants.VEHICULO_CLASE);
        claseField = new JTextField(NumberConstants.VEHICULO_FIELD);
        claseField.setInputVerifier(InputsVerifier.INSTANCE.toUpper);

        marcaLabel = new JLabel(StringsConstants.VEHICULO_MARCA);
        marcaField = new JTextField(NumberConstants.VEHICULO_FIELD);
        marcaField.setInputVerifier(InputsVerifier.INSTANCE.toUpper);

        lineaLabel = new JLabel(StringsConstants.VEHICULO_LINEA);
        lineaField = new JTextField(NumberConstants.VEHICULO_FIELD);

        modeloLabel = new JLabel(StringsConstants.VEHICULO_MODELO);
        modeloField = new JTextField(NumberConstants.VEHICULO_FIELD);
    }

    @Override
    protected void setLabelArray() {

    }

    @Override
    protected void setComponentArray() {

    }

    @Override
    protected void setDataPanel() {

    }

    @Override
    public boolean saveData() {
        return false;
    }

    @Override
    public void fillData() {

    }

    private void initilizeLayout() {
        labelsArray.add(placaLabel);
        fieldsArray.add(placaField);

        labelsArray.add(servicioLabel);
        fieldsArray.add(servicioField);

        labelsArray.add(claseLabel);
        fieldsArray.add(claseField);

        labelsArray.add(marcaLabel);
        fieldsArray.add(marcaField);

        labelsArray.add(lineaLabel);
        fieldsArray.add(lineaField);

        labelsArray.add(modeloLabel);
        fieldsArray.add(modeloField);
    }

    private void insertLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        Insets rightPadding = new Insets(0, 0, 0, 15);
        Insets noPadding = new Insets(0, 0, 0, 0);
        gc.gridy = 0;

        for (JComponent jL : labelsArray) {
            gc.weightx = 1;
            gc.weighty = 1;
            gc.fill = GridBagConstraints.NONE;

            gc.gridx = 0;
            gc.anchor = GridBagConstraints.EAST;
            gc.insets = rightPadding;
            add(jL, gc);
            gc.gridy++;
        }
        gc.gridy = 0;

        for (JComponent jTF : fieldsArray) {
            gc.weightx = 1;
            gc.weighty = 1;
            gc.fill = GridBagConstraints.NONE;

            gc.gridx = 1;
            gc.anchor = GridBagConstraints.WEST;
            gc.insets = noPadding;
            add(jTF, gc);

            gc.gridy++;
        }
        updateUI();

    }

}

package com.atc.ui.vehiculo;

import com.atc.app.JPanelAbstract;
import com.atc.service.vehiculo.VehiculoService;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DataPanelVehiculos extends JPanelAbstract {

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
	
	
	private InputVerifier exist;
	private VehiculoService service;

	public DataPanelVehiculos() {
		super();
		initializeVariables();
		initializeValidations();
		initilizeLayout();
		insertLayout();
	}

	private void initializeVariables() {
		labelsArray = new ArrayList<JComponent>();
		fieldsArray = new ArrayList<JComponent>();

		placaLabel = new JLabel(StringsConstants.VEHICULO_PLACA);
		placaField = new JTextField(NumberConstants.VEHICULO_FIELD);
		placaField.setInputVerifier(exist);
		
		servicioLabel = new JLabel(StringsConstants.VEHICULO_SERVICIO);
		String[] servicioStr = {
				"P�blico",
				"Particular"
				};
		servicioField = new JComboBox<String>(servicioStr);
		
		claseLabel = new JLabel(StringsConstants.VEHICULO_CLASE);
		claseField = new JTextField(NumberConstants.VEHICULO_FIELD);
		claseField.setInputVerifier(toUpper);
		
		marcaLabel = new JLabel(StringsConstants.VEHICULO_MARCA);
		marcaField = new JTextField(NumberConstants.VEHICULO_FIELD);
		marcaField.setInputVerifier(toUpper);
		
		lineaLabel = new JLabel(StringsConstants.VEHICULO_LINEA);
		lineaField = new JTextField(NumberConstants.VEHICULO_FIELD);
		
		modeloLabel = new JLabel(StringsConstants.VEHICULO_MODELO);
		modeloField = new JTextField(NumberConstants.VEHICULO_FIELD);
		
		
		service = new VehiculoService();
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

	@Override
	protected void initializeValidations() {
		super.initializeValidations();
		exist = new InputVerifier() {

			@Override
			public boolean verify(JComponent input) {
				JTextField tf = (JTextField) input;
				String cadena = tf.getText();
				if (cadena.isEmpty()) {
					if (service.existVehiculo(cadena)) {
						JOptionPane.showMessageDialog(null, StringsConstants.PLACA_ALREADY_EXIST,
								StringsConstants.APP_NAME, JOptionPane.ERROR_MESSAGE);
						return false;
					}
				}
				tf.setText(tf.getText().toUpperCase());
				return true;
			}
		};
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

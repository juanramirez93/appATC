package com.atc.ui.natural;

import com.atc.app.DialogAbstract;
import com.atc.model.Natural;
import com.atc.service.natural.EditNaturalService;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class EditNatural extends DialogAbstract implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8336420173700572247L;
	private JButton guardarButton;
	private JLabel cedulaLabel;
	private JLabel nombresLabel;
	private JLabel apellidoLabel;
	private JLabel emailLabel;
	private JLabel telefonoLabel;
	private JLabel otroTelLabel;
	private JLabel celularLabel;
	private JLabel direccionLabel;
	private JLabel ciudadLabel;
	private JLabel departamentoLabel;

	private JTextField cedulaField;
	private JTextField nombresField;
	private JTextField apellidosField;
	private JTextField emailField;
	private JTextField telefonoField;
	private JTextField otroTelefonoField;
	private JTextField celularField;
	private JTextField direccionField;
	private JTextField ciudadField;
	private JTextField departamentoField;
	private JPanel empresaPanel;
	private JPanel buttonPanel;

	private ArrayList<JLabel> jLabelArray;
	private ArrayList<JTextField> jTextFieldArray;

	private EditNaturalService service;

	private MainNatural parentM;

	private InputVerifier isNumber;
	private InputVerifier toUpper;
	private InputVerifier toLower;

	private Natural natural;

	public EditNatural(MainNatural parent, Natural natural) {
		super(parent, StringsConstants.AGREGAR_NATURAL);
		this.natural = natural;
		this.parentM = parent;
		initializeValidations();
		initializeVariables();
		setValues();
		initializeLayout();
		setSize(NumberConstants.ADDNATURAL_WIDTH, NumberConstants.ADDNATURAL_HEIGHT);
		setLocationRelativeTo(parent);
	}

	private void setValues() {
		cedulaField.setText(natural.getCedula() + "");
		cedulaField.setEnabled(false);
		nombresField.setText(natural.getNombres());
		apellidosField.setText(natural.getApellidos());
		emailField.setText(natural.getEmail());
		telefonoField.setText(natural.getTelefono());
		otroTelefonoField.setText(natural.getOtroTel());
		celularField.setText(natural.getCelular());
		direccionField.setText(natural.getDireccion());
		ciudadField.setText(natural.getCiudad());
		departamentoField.setText(natural.getDepartamento());
	}

	private void initializeValidations() {

		isNumber = new InputVerifier() {

			@Override
			public boolean verify(JComponent input) {
				boolean verificado;
				JTextField tf = (JTextField) input;
				String cadena = tf.getText();
				if (cadena.isEmpty() || NumberConstants.isNumber(cadena)) {
					verificado = true;
				} else {
					JOptionPane.showMessageDialog(null, StringsConstants.ONLY_NUMBERS, StringsConstants.APP_NAME,
							JOptionPane.ERROR_MESSAGE);
					verificado = false;
				}
				if (!verificado) {
					tf.setText("");
				}
				return verificado;
			}
		};

		toUpper = new InputVerifier() {

			@Override
			public boolean verify(JComponent input) {
				JTextField in = (JTextField) input;
				in.setText(in.getText().toUpperCase());
				return true;
			}
		};

		toLower = new InputVerifier() {

			@Override
			public boolean verify(JComponent input) {
				JTextField in = (JTextField) input;
				in.setText(in.getText().toLowerCase());
				return true;
			}
		};
	}

	private void initializeVariables() {
		service = new EditNaturalService();

		jLabelArray = new ArrayList<JLabel>();
		jTextFieldArray = new ArrayList<JTextField>();
		empresaPanel = new JPanel();
		buttonPanel = new JPanel();
		guardarButton = new JButton(StringsConstants.SAVE);

		cedulaLabel = new JLabel(StringsConstants.NATURAL_CEDULA);
		jLabelArray.add(cedulaLabel);
		cedulaField = new JTextField(NumberConstants.ADDNATURAL_FIELD);
		cedulaField.setInputVerifier(isNumber);
		jTextFieldArray.add(cedulaField);

		nombresLabel = new JLabel(StringsConstants.NATURAL_NOMBRES);
		jLabelArray.add(nombresLabel);
		nombresField = new JTextField(NumberConstants.ADDNATURAL_FIELD);
		nombresField.setInputVerifier(toUpper);
		jTextFieldArray.add(nombresField);

		apellidoLabel = new JLabel(StringsConstants.NATURAL_APELLIDOS);
		jLabelArray.add(apellidoLabel);
		apellidosField = new JTextField(NumberConstants.ADDNATURAL_FIELD);
		apellidosField.setInputVerifier(toUpper);
		jTextFieldArray.add(apellidosField);

		emailLabel = new JLabel(StringsConstants.NATURAL_EMAIL);
		jLabelArray.add(emailLabel);
		emailField = new JTextField(NumberConstants.ADDNATURAL_FIELD);
		emailField.setInputVerifier(toLower);
		jTextFieldArray.add(emailField);

		telefonoLabel = new JLabel(StringsConstants.NATURAL_TELEPHONE);
		jLabelArray.add(telefonoLabel);
		telefonoField = new JTextField(NumberConstants.ADDNATURAL_FIELD);
		jTextFieldArray.add(telefonoField);

		otroTelLabel = new JLabel(StringsConstants.NATURAL_TELEPHONE);
		jLabelArray.add(otroTelLabel);
		otroTelefonoField = new JTextField(NumberConstants.ADDNATURAL_FIELD);
		jTextFieldArray.add(otroTelefonoField);

		celularLabel = new JLabel(StringsConstants.NATURAL_CELLPHONE);
		jLabelArray.add(celularLabel);
		celularField = new JTextField(NumberConstants.ADDNATURAL_FIELD);
		jTextFieldArray.add(celularField);

		direccionLabel = new JLabel(StringsConstants.NATURAL_ADDRESS);
		jLabelArray.add(direccionLabel);
		direccionField = new JTextField(NumberConstants.ADDNATURAL_FIELD);
		direccionField.setInputVerifier(toUpper);
		jTextFieldArray.add(direccionField);

		ciudadLabel = new JLabel(StringsConstants.NATURAL_CITY);
		jLabelArray.add(ciudadLabel);
		ciudadField = new JTextField(NumberConstants.ADDNATURAL_FIELD);
		ciudadField.setInputVerifier(toUpper);
		jTextFieldArray.add(ciudadField);

		departamentoLabel = new JLabel(StringsConstants.NATURAL_DEPARTAMENTO);
		jLabelArray.add(departamentoLabel);
		departamentoField = new JTextField(NumberConstants.ADDNATURAL_FIELD);
		departamentoField.setInputVerifier(toUpper);
		jTextFieldArray.add(departamentoField);

	}

	private void initializeLayout() {
		empresaPanel.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		Insets rightPadding = new Insets(0, 0, 0, 15);
		Insets noPadding = new Insets(0, 0, 0, 0);
		gc.gridy = 0;

		for (JLabel jL : jLabelArray) {
			gc.weightx = 1;
			gc.weighty = 1;
			gc.fill = GridBagConstraints.NONE;

			gc.gridx = 0;
			gc.anchor = GridBagConstraints.EAST;
			gc.insets = rightPadding;
			empresaPanel.add(jL, gc);

			gc.gridy++;
		}

		gc.gridy = 0;
		for (JTextField jTF : jTextFieldArray) {
			gc.weightx = 1;
			gc.weighty = 1;
			gc.fill = GridBagConstraints.NONE;

			gc.gridx = 1;
			gc.anchor = GridBagConstraints.WEST;
			gc.insets = noPadding;
			empresaPanel.add(jTF, gc);

			gc.gridy++;
		}

		setLayout(new BorderLayout());
		add(empresaPanel, BorderLayout.CENTER);

		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(guardarButton);

		add(buttonPanel, BorderLayout.SOUTH);

		guardarButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();

		if (event == guardarButton) {
			guardarEmpresa();

		}
	}

	private void guardarEmpresa() {
		String apellidos = apellidosField.getText();
		String cedula = cedulaField.getText();
		String nombres = nombresField.getText();

		if (!apellidos.isEmpty() && !cedula.isEmpty() && !nombres.isEmpty()) {
			natural.setCedula(Long.valueOf(cedula));
			natural.setNombres(nombres);
			natural.setApellidos(apellidos);
			natural.setEmail(emailField.getText());
			natural.setTelefono(telefonoField.getText());
			natural.setOtroTel(otroTelefonoField.getText());
			natural.setCelular(celularField.getText());
			natural.setDireccion(direccionField.getText());
			natural.setCiudad(ciudadField.getText());
			natural.setDepartamento(departamentoField.getText());
			natural.setModificacion(new Date());
			natural.setResponsableModificacion(userSession.getUser());
			service.updateNatural(natural);
			if (parentM != null) {
				parentM.refreshTable();
			}

			clean();
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, StringsConstants.INCOMPLETE_DATA_MESSAGE);
		}
	}

	private void clean() {
		for (JTextField jtf : jTextFieldArray) {
			jtf.setText("");
		}
	}

}

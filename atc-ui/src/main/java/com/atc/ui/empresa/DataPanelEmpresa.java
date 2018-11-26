package com.atc.ui.empresa;

import com.atc.app.JPanelAbstract;
import com.atc.model.Contacto;
import com.atc.model.Empresa;
import com.atc.model.Representante;
import com.atc.service.empresa.EmpresaService;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;
import com.atc.util.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class DataPanelEmpresa extends JPanelAbstract implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2626912434555603082L;
	private JLabel nitLabel;
	private JLabel codigoLabel;
	private JLabel razonSocialLabel;
	private JLabel siglasLabel;
	private JLabel telefonoLabel;
	private JLabel otroTelLabel;
	private JLabel celularLabel;
	private JLabel direccionLabel;
	private JLabel ciudadLabel;

	private JTextField nit;
	private JTextField codigo;
	private JTextField razonSocial;
	private JTextField siglas;
	private JTextField telefono;
	private JTextField otroTelefono;
	private JTextField celular;
	private JTextField direccion;
	private JTextField ciudad;

	private JCheckBox addRte;
	private JLabel cedulaLabel;
	private JLabel nombresLabel;
	private JLabel apellidoLabel;
	private JLabel emailLabel;
	private JLabel telefonoRLabel;
	private JLabel otroTelRLabel;
	private JLabel celularRLabel;

	private JCheckBox addContacto;
	private JTextField cedulaField;
	private JTextField nombresField;
	private JTextField apellidosField;
	private JTextField emailField;
	private JTextField telefonoRField;
	private JTextField otroTelefonoRField;
	private JTextField celularRField;

	private JLabel cedulaCLabel;
	private JLabel nombresCLabel;
	private JLabel apellidoCLabel;
	private JLabel emailCLabel;
	private JLabel telefonoCLabel;
	private JLabel otroTelCLabel;
	private JLabel celularCLabel;

	private JTextField cedulaCField;
	private JTextField nombresCField;
	private JTextField apellidosCField;
	private JTextField emailCField;
	private JTextField telefonoCField;
	private JTextField otroTelefonoCField;
	private JTextField celularCField;

	private JPanel empresaPanel;
	private JPanel representantePanel;
	private JPanel contactoPanel;
	private JTabbedPane tabed;

	private EmpresaService service;

	private InputVerifier exist;

	private Empresa empresa;

	public DataPanelEmpresa() {
		super();
		empresa = new Empresa();
		initializeVariables();
		personalizeLayout();
		initializeValidations();
	}

	public DataPanelEmpresa(Empresa empresa) {
		super();
		this.empresa = empresa;
		initializeVariables();
		personalizeLayout();
		initializeValidations();
		setValues();
	}

	private void personalizeLayout() {
		Dimension dimensionData = new Dimension(200, 40 );
		setPreferredSize(dimensionData);
		setEmpresaPanel();
		tabed.add("Datos Empresa", empresaPanel);
		tabed.add("Datos Representante", representantePanel);
		tabed.add("Datos Contacto", contactoPanel);
		add(tabed, BorderLayout.CENTER);
	}

	private void initializeVariables() {
		service = new EmpresaService();
		nitLabel = new JLabel(StringsConstants.NIT);
		nit = new JTextField(NumberConstants.ADDCOMPANY_FIELD);
		nit.setInputVerifier(isNumber);
		nit.setInputVerifier(exist);
		codigoLabel = new JLabel(StringsConstants.EMPRESA_DIGITO);
		codigo = new JTextField(NumberConstants.ADDCOMPANY_FIELD);
		razonSocialLabel = new JLabel(StringsConstants.RAZON_SOCIAL);
		razonSocial = new JTextField(NumberConstants.ADDCOMPANY_FIELD);
		razonSocial.setInputVerifier(toUpper);
		siglasLabel = new JLabel(StringsConstants.EMPRESA_SIGLAS);
		siglas = new JTextField(NumberConstants.ADDCOMPANY_FIELD);
		siglas.setInputVerifier(toUpper);
		telefonoLabel = new JLabel(StringsConstants.EMPRESA_TELEPHONE);
		telefono = new JTextField(NumberConstants.ADDCOMPANY_FIELD);
		otroTelLabel = new JLabel(StringsConstants.EMPRESA_TELEPHONE);
		otroTelefono = new JTextField(NumberConstants.ADDCOMPANY_FIELD);
		celularLabel = new JLabel(StringsConstants.EMPRESA_CELLPHONE);
		celular = new JTextField(NumberConstants.ADDCOMPANY_FIELD);
		direccionLabel = new JLabel(StringsConstants.EMPRESA_ADDRESS);
		direccion = new JTextField(NumberConstants.ADDCOMPANY_FIELD);
		ciudadLabel = new JLabel(StringsConstants.EMPRESA_CITY);
		ciudad = new JTextField(NumberConstants.ADDCOMPANY_FIELD);

		addRte = new JCheckBox("Agregar representante legal");
		addRte.addActionListener(this);
		cedulaLabel = new JLabel(StringsConstants.NATURAL_CEDULA);
		cedulaField = new JTextField(NumberConstants.ADDCOMPANY_FIELD);
		nombresLabel = new JLabel(StringsConstants.NATURAL_NOMBRES);
		nombresField = new JTextField(NumberConstants.ADDCOMPANY_FIELD);
		apellidoLabel = new JLabel(StringsConstants.NATURAL_APELLIDOS);
		apellidosField = new JTextField(NumberConstants.ADDCOMPANY_FIELD);
		emailLabel = new JLabel(StringsConstants.NATURAL_EMAIL);
		emailField = new JTextField(NumberConstants.ADDCOMPANY_FIELD);
		telefonoRLabel = new JLabel(StringsConstants.NATURAL_TELEPHONE);
		telefonoRField = new JTextField(NumberConstants.ADDCOMPANY_FIELD);
		otroTelRLabel = new JLabel(StringsConstants.NATURAL_TELEPHONE);
		otroTelefonoRField = new JTextField(NumberConstants.ADDCOMPANY_FIELD);
		celularRLabel = new JLabel(StringsConstants.NATURAL_CELLPHONE);
		celularRField = new JTextField(NumberConstants.ADDCOMPANY_FIELD);

		addContacto = new JCheckBox("Agregar contacto");
		addContacto.addActionListener(this);
		cedulaCLabel = new JLabel(StringsConstants.NATURAL_CEDULA);
		cedulaCField = new JTextField(NumberConstants.ADDCOMPANY_FIELD);
		nombresCLabel = new JLabel(StringsConstants.NATURAL_NOMBRES);
		nombresCField = new JTextField(NumberConstants.ADDCOMPANY_FIELD);
		apellidoCLabel = new JLabel(StringsConstants.NATURAL_APELLIDOS);
		apellidosCField = new JTextField(NumberConstants.ADDCOMPANY_FIELD);
		emailCLabel = new JLabel(StringsConstants.NATURAL_EMAIL);
		emailCField = new JTextField(NumberConstants.ADDCOMPANY_FIELD);
		telefonoCLabel = new JLabel(StringsConstants.NATURAL_TELEPHONE);
		telefonoCField = new JTextField(NumberConstants.ADDCOMPANY_FIELD);
		otroTelCLabel = new JLabel(StringsConstants.NATURAL_TELEPHONE);
		otroTelefonoCField = new JTextField(NumberConstants.ADDCOMPANY_FIELD);
		celularCLabel = new JLabel(StringsConstants.NATURAL_CELLPHONE);
		celularCField = new JTextField(NumberConstants.ADDCOMPANY_FIELD);

		empresaPanel = new JPanel();
		representantePanel = new JPanel();
		contactoPanel = new JPanel();
		tabed = new JTabbedPane();
	}

	private void setRepresentantePanel() {
		ArrayList<JComponent> labels = new ArrayList<JComponent>();
		ArrayList<JComponent> fields = new ArrayList<JComponent>();
		labels.add(cedulaLabel);
		fields.add(cedulaField);
		labels.add(nombresLabel);
		fields.add(nombresField);
		labels.add(apellidoLabel);
		fields.add(apellidosField);
		labels.add(emailLabel);
		fields.add(emailField);
		labels.add(telefonoRLabel);
		fields.add(telefonoRField);
		labels.add(otroTelRLabel);
		fields.add(otroTelefonoRField);
		labels.add(celularRLabel);
		fields.add(celularRField);

		setPanel(representantePanel, labels, fields);

	}

	private void setContactoPanel() {
		ArrayList<JComponent> labels = new ArrayList<JComponent>();
		ArrayList<JComponent> fields = new ArrayList<JComponent>();
		labels.add(cedulaCLabel);
		fields.add(cedulaCField);
		labels.add(nombresCLabel);
		fields.add(nombresCField);
		labels.add(apellidoCLabel);
		fields.add(apellidosCField);
		labels.add(emailCLabel);
		fields.add(emailCField);
		labels.add(telefonoCLabel);
		fields.add(telefonoCField);
		labels.add(otroTelCLabel);
		fields.add(otroTelefonoCField);
		labels.add(celularCLabel);
		fields.add(celularCField);
		setPanel(contactoPanel, labels, fields);

	}

	private void setEmpresaPanel() {
		ArrayList<JComponent> labels = new ArrayList<JComponent>();
		ArrayList<JComponent> fields = new ArrayList<JComponent>();
		labels.add(nitLabel);
		fields.add(nit);
		labels.add(codigoLabel);
		fields.add(codigo);
		labels.add(razonSocialLabel);
		fields.add(razonSocial);
		labels.add(siglasLabel);
		fields.add(siglas);
		labels.add(telefonoLabel);
		fields.add(telefono);
		labels.add(otroTelLabel);
		fields.add(otroTelefono);
		labels.add(celularLabel);
		fields.add(celular);
		labels.add(direccionLabel);
		fields.add(direccion);
		labels.add(ciudadLabel);
		fields.add(ciudad);
		fields.add(addRte);
		fields.add(addContacto);

		setPanel(empresaPanel, labels, fields);

	}

	@Override
	public void initializeValidations() {
		super.initializeValidations();
		exist = new InputVerifier() {

			@Override
			public boolean verify(JComponent input) {
				boolean verificado;
				long nit = 0;
				JTextField tf = (JTextField) input;
				String cadena = tf.getText();
				if (NumberConstants.isNumber(cadena)) {
					nit = Long.valueOf(cadena);
					if (!service.existEmpresa(nit)) {
						verificado = true;
					} else {
						JOptionPane.showMessageDialog(null, StringsConstants.NIT_ALREADY_EXIST,
								StringsConstants.APP_NAME, JOptionPane.ERROR_MESSAGE);
						verificado = false;
					}
				} else {
					verificado = true;
				}
				if (!verificado) {
					tf.setText("");
				} else {
					codigo.setText(Utils.calcularDigitoVerificacion(nit));
				}
				return verificado;
			}
		};
	}

	public void actionPerformed(ActionEvent e) {
		JComponent event = (JComponent) e.getSource();
		if (event == addRte) {
			if (addRte.isSelected()) {
				setRepresentantePanel();
			} else {
				representantePanel.removeAll();
			}
		} else if (event == addContacto) {
			if (addContacto.isSelected()) {
				setContactoPanel();
			} else {
				contactoPanel.removeAll();
			}
		}

	}

	private void setPanel(JPanel panel, ArrayList<JComponent> labels, ArrayList<JComponent> fields) {
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		Insets rightPadding = new Insets(0, 0, 10, 15);
		Insets noPadding = new Insets(0, 0, 0, 0);
		gc.gridy = 0;

		for (JComponent jL : labels) {
			gc.weightx = 1;
			gc.weighty = 1;
			gc.fill = GridBagConstraints.NONE;

			gc.gridx = 0;
			gc.anchor = GridBagConstraints.EAST;
			gc.insets = rightPadding;
			panel.add(jL, gc);

			gc.gridy++;
		}

		gc.gridy = 0;
		for (JComponent jTF : fields) {
			gc.weightx = 1;
			gc.weighty = 1;
			gc.fill = GridBagConstraints.NONE;

			gc.gridx = 1;
			gc.anchor = GridBagConstraints.WEST;
			gc.insets = noPadding;
			panel.add(jTF, gc);

			gc.gridy++;
		}
	}

	public void guardarEmpresa() {
		String razon = razonSocial.getText();
		String nitStr = nit.getText();
		String codeStr = codigo.getText();
		String siglasStr = siglas.getText();

		if (!razon.isEmpty() && !nitStr.isEmpty() && !codeStr.isEmpty() && !siglasStr.isEmpty()) {

			empresa.setNit(Long.valueOf(nitStr));
			empresa.setDigito(Integer.valueOf(codeStr));
			empresa.setRazonSocial(razon);
			empresa.setSiglas(siglasStr);
			empresa.setTelefono(telefono.getText());
			empresa.setOtroTel(otroTelefono.getText());
			empresa.setCelular(celular.getText());
			empresa.setDireccion(direccion.getText());
			empresa.setCiudad(ciudad.getText());
			empresa.setCreacion(new Date());
			empresa.setResponsableCreacion(userSession.getUser());

			if (addRte.isSelected()) {
				Representante repr = new Representante();
				repr.setCedula(cedulaField.getText());
				repr.setNombres(nombresField.getText());
				repr.setApellidos(apellidosField.getText());
				repr.setTelefono(telefonoRField.getText());
				repr.setOtroTel(otroTelefonoRField.getText());
				repr.setEmail(emailField.getText());
				empresa.setRepresentante(repr);
			}

			if (addContacto.isSelected()) {
				Contacto cont = new Contacto();
				cont.setCedula(cedulaCField.getText());
				cont.setNombres(nombresCField.getText());
				cont.setApellidos(apellidosCField.getText());
				cont.setTelefono(telefonoCField.getText());
				cont.setOtroTel(otroTelefonoCField.getText());
				cont.setEmail(emailCField.getText());
				empresa.setContacto(cont);
			}
			service.addEmpresa(empresa);

		} else {
			JOptionPane.showMessageDialog(this, StringsConstants.INCOMPLETE_DATA_MESSAGE);
		}
	}

	private void setValues() {
		nit.setText(String.valueOf(empresa.getNit()));
		nit.setEnabled(false);
		codigo.setText(String.valueOf(empresa.getDigito()));
		codigo.setEnabled(false);
		razonSocial.setText(empresa.getRazonSocial());
		siglas.setText(empresa.getSiglas());
		telefono.setText(String.valueOf(empresa.getTelefono()));
		otroTelefono.setText(String.valueOf(empresa.getOtroTel()));
		celular.setText(String.valueOf(empresa.getCelular()));
		direccion.setText(empresa.getDireccion());
		ciudad.setText(empresa.getCiudad());

		if (empresa.getRepresentante() != null) {
			addRte.setSelected(true);
			setRepresentantePanel();
			Representante repr = empresa.getRepresentante();
			cedulaField.setText(repr.getCedula());
			nombresField.setText(repr.getNombres());
			apellidosField.setText(repr.getApellidos());
			emailField.setText(repr.getEmail());
			telefonoRField.setText(repr.getTelefono());
			otroTelefonoRField.setText(repr.getOtroTel());
			celularRField.setText(repr.getCelular());
		}

		if (empresa.getContacto() != null) {
			setEmpresaPanel();
			addContacto.setSelected(true);
			Contacto cont = empresa.getContacto();

			cedulaCField.setText(cont.getCedula());
			nombresCField.setText(cont.getNombres());
			apellidosCField.setText(cont.getApellidos());
			emailCField.setText(cont.getEmail());
			telefonoCField.setText(cont.getTelefono());
			otroTelefonoCField.setText(cont.getOtroTel());
			celularCField.setText(cont.getCelular());
		}
	}

}

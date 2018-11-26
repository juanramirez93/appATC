package com.atc.ui.seguros.stock;

import com.atc.app.DialogAbstract;
import com.atc.model.Stock;
import com.atc.service.stock.AddStockService;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class EditStock extends DialogAbstract implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3749317577844482032L;

	private JButton guardarButton;

	private JLabel fechaLabel;
	private JLabel productoLabel;
	private JLabel tipoLabel;
	private JLabel inicioLabel;
	private JLabel finLabel;

	private JDateChooser fechaField;
	private JComboBox<String> productoField;
	private JComboBox<String> detalleField;
	private JTextField inicioField;
	private JTextField finField;

	private JPanel cabezaPanel;
	private JPanel buttonPanel;
	private JPanel camposPanel;

	private ArrayList<JLabel> jLabelArray;
	private ArrayList<JComponent> jComponentArray;

	private AddStockService service;

	private MainStock parentM;

	private InputVerifier isNumber;

	private Stock stock;

	public EditStock(MainStock parent, Stock stock) {
		super(parent, StringsConstants.AGREGAR_STOCK);
		this.parentM = parent;
		this.stock = stock;
		initializeValidations();
		initializeVariables();
		initializeLayout();
		showCampos();
		setDatos();
		setSize(NumberConstants.ADDSTOCK_WIDTH, NumberConstants.ADDSTOCK_HEIGHT);
		setLocationRelativeTo(parent);
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
	}

	private void setDatos() {
		fechaField.setDate(stock.getFecha());
		productoField.setSelectedItem(stock.getProducto());
		detalleField.setSelectedItem(stock.getDetalle());
		inicioField.setText(String.valueOf(stock.getInicio()));
		finField.setText(String.valueOf(stock.getFin()));
	}
	
	private void initializeVariables() {
		service = new AddStockService();

		cabezaPanel = new JPanel();
		buttonPanel = new JPanel();
		camposPanel = new JPanel();

		guardarButton = new JButton(StringsConstants.SAVE);
		guardarButton.addActionListener(this);

		fechaLabel = new JLabel(StringsConstants.STOCK_FECHA);
		productoLabel = new JLabel(StringsConstants.STOCK_PRODUCTO);
		tipoLabel = new JLabel(StringsConstants.STOCK_TIPO);
		inicioLabel = new JLabel(StringsConstants.STOCK_INICIO);
		finLabel = new JLabel(StringsConstants.STOCK_FIN);

		fechaField = new JDateChooser(new Date());
		productoField = new JComboBox<String>(
				new String[] { "", "AAA", "INTEGRAL", "RCE Y TRANSPORTE", "CAMIONERA", "RCE" });
		detalleField = new JComboBox<String>(new String[] { "", "Asignación", "Devolución" });
		inicioField = new JTextField(NumberConstants.INVENTORY_FIELD);
		inicioField.setInputVerifier(isNumber);
		finField = new JTextField(NumberConstants.INVENTORY_FIELD);
		finField.setInputVerifier(isNumber);
	}

	private void initializeLayout() {

		setLayout(new BorderLayout());
		cabezaPanel.setLayout(new FlowLayout());
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(guardarButton);

		add(cabezaPanel, BorderLayout.NORTH);
		add(camposPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		setCampos();

	}

	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();

		if (event == guardarButton) {
			guardarMovimiento();
		}
	}

	private void setCampos() {

		jLabelArray = new ArrayList<JLabel>();
		jComponentArray = new ArrayList<JComponent>();
		camposPanel.removeAll();

		jLabelArray.add(fechaLabel);
		jLabelArray.add(productoLabel);
		jLabelArray.add(tipoLabel);
		jLabelArray.add(inicioLabel);
		jLabelArray.add(finLabel);

		jComponentArray.add(fechaField);
		jComponentArray.add(productoField);
		jComponentArray.add(detalleField);
		jComponentArray.add(inicioField);
		jComponentArray.add(finField);
	}

	private void guardarMovimiento() {
		Date fecha = fechaField.getDate();
		if (productoField.getSelectedIndex() == 0 || detalleField.getSelectedIndex() == 0
				|| inicioField.getText().isEmpty() || finField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, StringsConstants.INCOMPLETE_DATA_MESSAGE, StringsConstants.APP_NAME,
					JOptionPane.ERROR_MESSAGE);
		} else {
			stock.setFecha(fecha);
			stock.setProducto((String) productoField.getSelectedItem());
			stock.setDetalle((String) detalleField.getSelectedItem());
			stock.setInicio(Integer.parseInt(inicioField.getText()));
			stock.setFin(Integer.parseInt(finField.getText()));
			stock.setRestantes(stock.getFin() - stock.getProximo() + 1);
			service.updateStock(stock);
			if (parentM != null) {
				parentM.refreshTable();
			}
			this.setVisible(false);
		}
	}

	public void showCampos() {

		camposPanel.setLayout(new GridBagLayout());
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
			camposPanel.add(jL, gc);
			gc.gridy++;
		}
		gc.gridy = 0;

		for (JComponent jTF : jComponentArray) {
			gc.weightx = 1;
			gc.weighty = 1;
			gc.fill = GridBagConstraints.NONE;

			gc.gridx = 1;
			gc.anchor = GridBagConstraints.WEST;
			gc.insets = noPadding;
			camposPanel.add(jTF, gc);

			gc.gridy++;
		}
		camposPanel.updateUI();

	}

}

package com.atc.ui.afiliacion.afiliado.pagos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.atc.app.DialogAbstract;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

public class AddPagoAfiliacion extends DialogAbstract implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -690705027703226961L;

	private JButton guardarButton;

	private JPanel cabezaPanel;
	private JPanel buttonPanel;
	private DataPanelPagoAfiliacion camposPanel;

	private MainPagoAfiliacion parentM;

	public AddPagoAfiliacion(MainPagoAfiliacion parent) {
		super(parent, StringsConstants.AGREGAR_PAGOAFILIACION);
		this.parentM = parent;
		initializeValidations();
		initializeVariables();
		initializeLayout();
		setSize(NumberConstants.ADDPAGOAFILIACION_WIDTH, NumberConstants.ADDPAGOAFILIACION_HEIGHT);
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

	private void initializeVariables() {
		guardarButton = new JButton(StringsConstants.SAVE);
		guardarButton.addActionListener(this);
		camposPanel = new DataPanelPagoAfiliacion();
		cabezaPanel = new JPanel();
		buttonPanel = new JPanel();
	}

	private void initializeLayout() {

		setLayout(new BorderLayout());
		cabezaPanel.setLayout(new FlowLayout());
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(guardarButton);

		add(cabezaPanel, BorderLayout.NORTH);
		add(camposPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

	}

	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		if (event == guardarButton) {
			guardarAfiliacion();
		}

	}

	private void guardarAfiliacion() {

		if(camposPanel.guardarAfiliacion()) {
			if (parentM != null) {
				parentM.refreshTable();
			}
			this.dispose();
		}
		
	}

	

}

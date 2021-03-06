package com.atc.app;

import com.atc.connection.Session;
import com.atc.model.Usuario;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.text.DecimalFormat;

public class JPanelAbstract extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5902501858272460301L;
	protected InputVerifier isNumber;
	protected InputVerifier toUpper;
	protected InputVerifier toLower;
	protected DecimalFormat formatID = new DecimalFormat("#,###");
	protected Dimension dimensionData = new Dimension(120, 25);
	
	protected Usuario userSession;
	
	

	public JPanelAbstract() {
		super();
		initializeValidations();
		this.userSession = Session.INSTANCE.getUserSession();
	}

	protected void initializeValidations() {
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
				JTextComponent in = (JTextComponent) input;
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

}

package com.atc.ui.afiliacion.afiliado.pagos;

import com.atc.app.JPanelAbstract;
import com.atc.model.Afiliacion;
import com.atc.model.PagoAfiliado;
import com.atc.service.afiliacion.AddAfiliadoService;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DataPanelPagoAfiliacion extends JPanelAbstract{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7531332988617930902L;

	private ArrayList<JLabel> jLabelArray;

	private JLabel fechaPagoLabel;
	private JLabel fechaVencimientoLabel;
	private JLabel valorPagoLabel;
	private JLabel reciboLabel;
	private JLabel captadorLabel;
	private JLabel asesorLabel;

	private ArrayList<JComponent> jComponentArray;

	private JDateChooser fechaPagoField;
	private JDateChooser fechaVencimientoField;
	private JTextField valorField;
	private JTextField reciboField;
	private JComboBox<String> captadorField;
	private JComboBox<String> asesorField;

	private AddAfiliadoService service;
	
	Afiliacion afiliacion;
	PagoAfiliado pago;
	
	
	
	public DataPanelPagoAfiliacion() {
		super();
		initializeVariables();
		initializeLayout();
		personalizeLayout();
		afiliacion = new Afiliacion();
		
	}

	public DataPanelPagoAfiliacion(Afiliacion afiliacion, PagoAfiliado pagoAfiliado) {
		super();
		initializeVariables();
		initializeLayout();
		personalizeLayout();
		this.pago = pagoAfiliado;
		this.afiliacion = afiliacion;
		setValues(afiliacion);
		
		
	}

	private void setValues(Afiliacion afiliacion) {
		fechaPagoField.setDate(pago.getFecha());
		fechaVencimientoField.setDate(pago.getVencimiento());
		valorField.setText(String.valueOf(pago.getValor()));
		reciboField.setText(String.valueOf(pago.getReciboDeCaja()));
		captadorField.setSelectedItem(pago.getCaptador());
		asesorField.setSelectedItem(pago.getAsesor());
	}

	private void initializeLayout() {
		jLabelArray.add(fechaPagoLabel);
		jLabelArray.add(fechaVencimientoLabel);
		jLabelArray.add(valorPagoLabel);
		jLabelArray.add(reciboLabel);
		jLabelArray.add(captadorLabel);
		jLabelArray.add(asesorLabel);

		jComponentArray.add(fechaPagoField);
		jComponentArray.add(fechaVencimientoField);
		jComponentArray.add(valorField);
		jComponentArray.add(reciboField);
		jComponentArray.add(captadorField);
		jComponentArray.add(asesorField);
		
	}


	private void initializeVariables() {
		
		service = new AddAfiliadoService();
		
		jLabelArray = new ArrayList<JLabel>();

		fechaPagoLabel = new JLabel(StringsConstants.AFILIACION_FECHA_PAGO);
		fechaVencimientoLabel = new JLabel(StringsConstants.AFILIACION_FECHA_VENCIMIENTO);
		valorPagoLabel = new JLabel(StringsConstants.AFILIACION_VALOR);
		reciboLabel = new JLabel(StringsConstants.AFILIACION_RECIBO);
		captadorLabel = new JLabel(StringsConstants.AFILIACION_CAPTADOR);
		asesorLabel = new JLabel(StringsConstants.AFILIACION_ASESOR);
		
		jComponentArray = new ArrayList<JComponent>();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.YEAR, 1);
		fechaPagoField = new JDateChooser(new Date());
		fechaVencimientoField = new JDateChooser(calendar.getTime());
		valorField = new JTextField(NumberConstants.ADDPAGOAFILIADO_FIELD);
		valorField.setInputVerifier(isNumber);
		reciboField = new JTextField(NumberConstants.ADDPAGOAFILIADO_FIELD);
		reciboField.setInputVerifier(isNumber);
		captadorField = new JComboBox<String>(service.getEmpleado());
		captadorField.setSelectedItem("JENIFFER C");
		asesorField = new JComboBox<String>(service.getEmpleado());
		asesorField.setSelectedItem("JENIFFER C");
	}
	
	public boolean guardarAfiliacion() {

		if(afiliacion.getPagos().contains(pago)) {
			afiliacion.getPagos().remove(pago);
		}
		PagoAfiliado pago = new PagoAfiliado();
		pago.setFecha(fechaPagoField.getDate());
		pago.setVencimiento(fechaVencimientoField.getDate());
		if(!reciboField.getText().isEmpty() && reciboField.getText() != "0") {
			pago.setReciboDeCaja(Integer.parseInt(reciboField.getText()));
		}
		if (!valorField.getText().isEmpty()) {
			pago.setValor(Integer.parseInt(valorField.getText()));
		}
		pago.setCaptador((String) captadorField.getSelectedItem());
		pago.setAsesor((String) asesorField.getSelectedItem());
		afiliacion.addPago(pago);
		Date ultimo = afiliacion.getPagos().get(afiliacion.getPagos().size() - 1).getVencimiento();
		afiliacion.setUltimoPago(ultimo);
		service.update(afiliacion);
		return true;
	}
	
	private void personalizeLayout() {

		setLayout(new GridBagLayout());
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
			add(jL, gc);
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
			add(jTF, gc);

			gc.gridy++;
		}
		updateUI();

	}

}

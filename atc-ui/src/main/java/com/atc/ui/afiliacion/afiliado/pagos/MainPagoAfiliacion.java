package com.atc.ui.afiliacion.afiliado.pagos;

import com.atc.app.FrameAbstract;
import com.atc.model.Afiliacion;
import com.atc.model.PagoAfiliado;
import com.atc.service.afiliacion.MainAfiliadoService;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainPagoAfiliacion extends FrameAbstract implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -983152261048372067L;
	private TablePagoAfiliacion mainTable;
	private JPanel optionPanel;
	private JButton ingresarButton;
	private JButton atrasButton;
	private JButton editarButton;
	private JButton borrarButton;
	MainAfiliadoService service;

	Afiliacion afiliacion;

	public MainPagoAfiliacion(Afiliacion afiliacion) {
		super(StringsConstants.MAINPAGOAFILIADO_TITULO);
		this.afiliacion = afiliacion;
		initialize();
		initializeVariables();
		constructLayout();
		refreshTable();
		setVisible(true);
	}

	public void refreshTable() {
		List<PagoAfiliado> pagos = afiliacion.getPagos();
		this.mainTable.setTableModel(pagos);
		mainTable.updateTable();
	}

	private void constructLayout() {
		setLayout(new BorderLayout());
		optionPanel.setLayout(new FlowLayout());
		optionPanel.add(atrasButton);
		optionPanel.add(editarButton);
		optionPanel.add(ingresarButton);
		optionPanel.add(borrarButton);
		add(mainTable, BorderLayout.CENTER);
		add(optionPanel, BorderLayout.SOUTH);
	}

	private void initializeVariables() {

		this.service = new MainAfiliadoService();
		this.mainTable = new TablePagoAfiliacion();

		this.optionPanel = new JPanel();

		this.atrasButton = new JButton(StringsConstants.BACK);
		this.atrasButton.addActionListener(this);

		this.editarButton = new JButton(StringsConstants.EDITAR);
		this.editarButton.addActionListener(this);

		this.ingresarButton = new JButton(StringsConstants.AGREGAR_PAGOAFILIACION);
		this.ingresarButton.addActionListener(this);

		this.borrarButton = new JButton(StringsConstants.BORRAR_PAGOAFILIACION);
		this.borrarButton.addActionListener(this);

	}

	private void initialize() {
		setSize(NumberConstants.MAINPAGOSAFILIACIONES_WIDTH, NumberConstants.MAINPAGOSAFILIACIONES_HEIGHT);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.ingresarButton) {
			if (userSession.getPermisos().getAfiliacion() % AGREGAR == 0) {
				AddPagoAfiliacion addPagoAfiliacion = new AddPagoAfiliacion(this);
				addPagoAfiliacion.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, StringsConstants.NO_PERMISO);
			}
		} else if (event.getSource() == this.atrasButton) {
			setVisible(false);
		} else if (event.getSource() == this.editarButton) {
			if (userSession.getPermisos().getPagoAfiliacion() % EDITAR == 0) {
				PagoAfiliado pago = mainTable.getSelected();
				if (pago != null) {
					EditPagoAfiliacion edit = new EditPagoAfiliacion(this, pago);
					edit.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, StringsConstants.SELECT_REGISTER);
				}
			} else {
				JOptionPane.showMessageDialog(this, StringsConstants.NO_PERMISO);
			}
		} else if (event.getSource() == this.borrarButton) {
			if (userSession.getPermisos().getPagoAfiliacion() % AGREGAR == 0) {
				PagoAfiliado pago = mainTable.getSelected();
				if (pago != null) {
					int rta = JOptionPane.showConfirmDialog(this, StringsConstants.COMFIRMA_BORRAR);
					if (rta == 0) {
						borrarPago(pago);
					}

				} else {
					JOptionPane.showMessageDialog(this, StringsConstants.SELECT_REGISTER);
				}
			} else {
				JOptionPane.showMessageDialog(this, StringsConstants.NO_PERMISO);
			}
		}
	}

	private void borrarPago(PagoAfiliado pago) {
		afiliacion.removePago(pago);
		service.update(afiliacion);
		refreshTable();
	}
}

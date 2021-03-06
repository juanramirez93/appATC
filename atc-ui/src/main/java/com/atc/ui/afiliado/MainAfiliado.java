package com.atc.ui.afiliado;

import com.atc.app.FrameAbstract;
import com.atc.model.Afiliacion;
import com.atc.service.afiliacion.MainAfiliadoService;
import com.atc.util.Exportar;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class MainAfiliado extends FrameAbstract implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -983152261048372067L;
	private MainAfiliadoService mainFrameService;
	private TableAfiliado mainTable;
	private JPanel optionPanel;
	private SearchAfiliado searchPanel;
	private JButton ingresarButton;
	private JButton atrasButton;
	private JButton detallesButton;
	private JButton editarButton;
	private JButton proximosAVencerButton;
	private JButton exportarButton;
	private AddAfiliacion addAfiliacion = null;
	private DetailAfiliado detailAfiliacion = null;
	private EditAfiliacion editAfiliacion = null;

	public MainAfiliado() {
		super(StringsConstants.MAINAFILIADO_TITULO);
		initialize();
		initializeVariables();
		constructLayout();
		refreshTable();
		setVisible(true);
	}

	public void refreshTable() {
		List<Afiliacion> afiliaciones = this.mainFrameService.getAllAfiliaciones();
		this.mainTable.setTableModel(afiliaciones);
		mainTable.updateTable();
	}

	public void refreshTable(List<Afiliacion> afiliaciones) {
		this.mainTable.setTableModel(afiliaciones);
		mainTable.updateTable();
	}

	private void constructLayout() {
		setLayout(new BorderLayout());
		optionPanel.setLayout(new FlowLayout());
		optionPanel.add(atrasButton);
		optionPanel.add(detallesButton);
		optionPanel.add(editarButton);
		optionPanel.add(ingresarButton);
		optionPanel.add(proximosAVencerButton);
		optionPanel.add(exportarButton);
		add(mainTable, BorderLayout.CENTER);
		add(optionPanel, BorderLayout.SOUTH);
		add(searchPanel, BorderLayout.NORTH);
	}

	private void initializeVariables() {
		this.mainFrameService = new MainAfiliadoService();
		this.mainTable = new TableAfiliado();

		this.searchPanel = new SearchAfiliado(this);

		this.optionPanel = new JPanel();

		this.atrasButton = new JButton(StringsConstants.BACK);
		this.atrasButton.addActionListener(this);

		this.detallesButton = new JButton(StringsConstants.VER_DETALLE);
		this.detallesButton.addActionListener(this);

		this.editarButton = new JButton(StringsConstants.EDIT);
		this.editarButton.addActionListener(this);

		this.ingresarButton = new JButton(StringsConstants.AGREGAR_AFILIACION);
		this.ingresarButton.addActionListener(this);

		this.proximosAVencerButton = new JButton(StringsConstants.PROXIMOS_A_VENCER);
		this.proximosAVencerButton.addActionListener(this);

		this.exportarButton = new JButton(StringsConstants.EXPORT);
		this.exportarButton.addActionListener(this);
	}

	private void initialize() {
		setSize(NumberConstants.MAINAFILIACIONES_WIDTH, NumberConstants.MAINAFILIACIONES_HEIGHT);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.ingresarButton) {
			if (userSession.getPermisos().getAfiliacion() % AGREGAR == 0) {
				if (addAfiliacion == null) {
					addAfiliacion = new AddAfiliacion(this);
					addAfiliacion.setVisible(true);
				} else {
					addAfiliacion.dispose();
					addAfiliacion = new AddAfiliacion(this);
					addAfiliacion.setVisible(true);
				}
			} else {
				JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
			}
		} else if (event.getSource() == this.atrasButton) {
			setVisible(false);
		} else if (event.getSource() == this.detallesButton) {
			if (userSession.getPermisos().getAfiliacion() % DETALLE == 0) {
				Afiliacion afiliacion = mainTable.getSelected();
				if (afiliacion != null) {
					if (detailAfiliacion == null) {
						detailAfiliacion = new DetailAfiliado(this, afiliacion);
						detailAfiliacion.setVisible(true);
					} else {
						detailAfiliacion.dispose();
						detailAfiliacion = new DetailAfiliado(this, afiliacion);
						detailAfiliacion.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(this, StringsConstants.SELECT_REGISTER);
				}
			} else {
				JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
			}
		} else if (event.getSource() == this.editarButton) {
			if (userSession.getPermisos().getAfiliacion() % EDITAR == 0) {
				Afiliacion afiliacion = mainTable.getSelected();
				if (afiliacion != null) {
					if(editAfiliacion == null) {
						editAfiliacion = new EditAfiliacion(this, afiliacion);
						editAfiliacion.setVisible(true);
					}else {
						editAfiliacion.dispose();
						editAfiliacion = new EditAfiliacion(this, afiliacion);
						editAfiliacion.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(this, StringsConstants.SELECT_REGISTER);
				}
			} else {
				JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
			}
		} else if (event.getSource() == this.proximosAVencerButton) {
			if (userSession.getPermisos().getAfiliacion() % EDITAR == 0) {
				List<Afiliacion> afiliacions = mainFrameService.getProximosAVencer();
				refreshTable(afiliacions);
			} else {
				JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
			}
		} else if (event.getSource() == this.exportarButton) {
			try {
				Exportar exp = new Exportar();
				exp.afiliados(mainTable.getTableModel());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, StringsConstants.ERROR_EXPORT);
				e.printStackTrace();
			}
		}
	}

}
package com.atc.ui.documentos;

import com.atc.app.FrameAbstract;
import com.atc.model.Empleado;
import com.atc.reports.Reintegros;
import com.atc.service.seguros.reintegro.VerReintegroService;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;
import com.toedter.calendar.JDateChooser;
import net.sf.jasperreports.engine.JRException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReintegroGenerator extends FrameAbstract implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 6351022332250901379L;
    JLabel mesLabel;
    JLabel anioLabel;

    JComboBox<String> opcionField;
    JComboBox<Empleado> empleadoField;
    JDateChooser inicioField;
    JDateChooser finField;
    JPanel mainPanel;
    JButton verButton;

    VerReintegroService service;

    public ReintegroGenerator() {
        super(StringsConstants.VER_REINTEGRO);
        initializeVariables();
        initializeLayout();
        setVisible(true);
    }

    private void initializeLayout() {
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(opcionField);
        mainPanel.add(empleadoField);
        mainPanel.add(inicioField);
        mainPanel.add(finField);
        mainPanel.add(verButton);
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
        if (!userSession.getUser().equals("admin")) {
            empleadoField.setSelectedItem(userSession.getEmpleado());
            empleadoField.setEnabled(false);
        }
    }

    private void initializeVariables() {
        setSize(NumberConstants.DOC_WIDTH, NumberConstants.DOC_HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        service = new VerReintegroService();

        mainPanel = new JPanel();

        verButton = new JButton(StringsConstants.VER_REINTEGRO);
        verButton.addActionListener(this);

        mesLabel = new JLabel(StringsConstants.REINTEGRO_MES_REPORTE);
        anioLabel = new JLabel(StringsConstants.REINTEGRO_ANIO_REPORTE);

        String[] tipos = {"Afiliaciones", "Seguros Vida", "Seguros Vida Facturación", "Seguros RCE", "Seguros " +
                "Transporte", "Seguros RCE Facturación", "Seguros " +
                "Transporte Facturación", "Relación Vida"};
        opcionField = new JComboBox<>(tipos);
        empleadoField = new JComboBox<>(service.getAll());
        inicioField = new JDateChooser();
        finField = new JDateChooser();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == verButton) {
            if (opcionField.getSelectedItem().equals("Afiliaciones")) {
                try {
                    Reintegros.INSTANCE.reporteReintegroAfiliados((Empleado) empleadoField.getSelectedItem(),
                            inicioField.getDate(), finField.getDate());
                } catch (JRException e1) {
                    e1.printStackTrace();
                }
            } else if (opcionField.getSelectedItem().equals("Seguros Vida")) {
                try {
                    Reintegros.INSTANCE.reporteReintegroVida((Empleado) empleadoField.getSelectedItem(),
                            inicioField.getDate(),
                            finField.getDate());
                } catch (JRException e1) {
                    e1.printStackTrace();
                }
            } else if (opcionField.getSelectedItem().equals("Seguros Vida Facturación")) {
                try {
                    Reintegros.INSTANCE.reporteReintegroVidaFact((Empleado) empleadoField.getSelectedItem(),
                            inicioField.getDate(),
                            finField.getDate());
                } catch (JRException e1) {
                    e1.printStackTrace();
                }
            } else if (opcionField.getSelectedItem().equals("Seguros RCE")) {
                try {
                    Reintegros.INSTANCE.reporteReintegroRCE((Empleado) empleadoField.getSelectedItem(),
                            inicioField.getDate(),
                            finField.getDate());
                } catch (JRException e1) {
                    e1.printStackTrace();
                }
            } else if (opcionField.getSelectedItem().equals("Seguros Transporte")) {
                try {
                    Reintegros.INSTANCE.reporteReintegroTransporte((Empleado) empleadoField.getSelectedItem(),
                            inicioField.getDate(),
                            finField.getDate());
                } catch (JRException e1) {
                    e1.printStackTrace();
                }
            } else if (opcionField.getSelectedItem().equals("Seguros RCE Facturación")) {
                try {
                    Reintegros.INSTANCE.reporteReintegroRCEFact((Empleado) empleadoField.getSelectedItem(),
                            inicioField.getDate(),
                            finField.getDate());
                } catch (JRException e1) {
                    e1.printStackTrace();
                }
            } else if (opcionField.getSelectedItem().equals("Seguros Transporte Facturación")) {
                try {
                    Reintegros.INSTANCE.reporteReintegroTransporteFact((Empleado) empleadoField.getSelectedItem(),
                            inicioField.getDate(),
                            finField.getDate());
                } catch (JRException e1) {
                    e1.printStackTrace();
                }
            } else if (opcionField.getSelectedItem().equals("Relación Vida")) {
                try {
                    Reintegros.INSTANCE.reporteMovimientoVida(inicioField.getDate(), finField.getDate());
                } catch (JRException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

}

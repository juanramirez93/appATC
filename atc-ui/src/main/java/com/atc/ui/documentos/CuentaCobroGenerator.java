package com.atc.ui.documentos;

import com.atc.app.FrameAbstract;
import com.atc.model.Empleado;
import com.atc.reports.Reintegros;
import com.atc.service.seguros.reintegro.VerReintegroService;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import net.sf.jasperreports.engine.JRException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CuentaCobroGenerator extends FrameAbstract implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 6351022332250901379L;

    private JComboBox<String> opcionField;
    private JComboBox<Empleado> empleadoField;
    private JDateChooser fechaField;
    private JPanel mainPanel;
    private JButton verButton;
    private JLabel valorLabel;
    private JTextField valorField;
    private JLabel monthLabel;
    private JMonthChooser monthField;

    VerReintegroService service;

    public CuentaCobroGenerator() {
        super(StringsConstants.VER_REINTEGRO);
        initializeVariables();
        initializeLayout();
        setVisible(true);
    }

    private void initializeLayout() {
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(opcionField);
        mainPanel.add(empleadoField);
        mainPanel.add(monthLabel);
        mainPanel.add(monthField);
        mainPanel.add(fechaField);
        mainPanel.add(valorLabel);
        mainPanel.add(valorField);
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

        String[] tipos = {"Afiliaciones", "Seguros Vida", "Seguros Vida Facturación", "Seguros RCE", "Seguros " +
                "Transporte", "Seguros RCE Facturación", "Seguros Transporte Facturación", "RCE Particular",
                "Entidades Desintegradoras", "Normalización", "Asesoría Gremial Empresas", "Todo " +
                "Riesgo - Logiseguros","CCM"};
        opcionField = new JComboBox<>(tipos);
        empleadoField = new JComboBox<>(service.getAll());

        fechaField = new JDateChooser();
        valorField = new JTextField(10);
        valorLabel = new JLabel(StringsConstants.VALUE);

        monthField = new JMonthChooser();
        monthLabel = new JLabel(StringsConstants.MONTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == verButton) {

            try {
                Reintegros.INSTANCE.cuentaCobro((Empleado) empleadoField.getSelectedItem(),
                        StringsConstants.getMonth(monthField.getMonth() + 1), Integer.valueOf(valorField.getText()),
                        opcionField.getSelectedItem().toString(), fechaField.getDate());
            } catch (JRException e1) {
                e1.printStackTrace();
            }

        }
    }

}

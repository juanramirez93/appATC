package com.atc.ui.seguros.poliza;

import com.atc.app.DialogAbstract;
import com.atc.model.RCE;
import com.atc.model.Transporte;
import com.atc.model.Vida;
import com.atc.service.seguros.poliza.AddPolizaService;
import com.atc.util.InputsVerifier;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class AddPoliza extends DialogAbstract implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 980919711568169598L;

    private JButton guardarButton;

    private JLabel numeroLabel;
    private JLabel ramoLabel;
    private JLabel inicioLabel;
    private JLabel finLabel;
    private JLabel valorLabel;
    private JLabel valorUrbanosLabel;
    private JLabel comisionATCLabel;

    private JComboBox<String> ramo;

    private JTextField numero;
    private JDateChooser inicio;
    private JDateChooser fin;
    private JTextField costo;

    private JTextField valorUrbanos;
    private JTextField comisionATC;

    private JPanel cabezaPanel;
    private JPanel buttonPanel;
    private JPanel camposPanel;

    private ArrayList<JLabel> jLabelArray;
    private ArrayList<JComponent> jComponentArray;

    private AddPolizaService service;

    private MainPoliza parentM;

    public AddPoliza(MainPoliza parent) {
        super(parent, StringsConstants.ADD_NEW_POLIZA);
        this.parentM = parent;
        initializeVariables();
        initializeLayout();
        setSize(NumberConstants.ADDPOLIZA_WIDTH, NumberConstants.ADDPOLIZA_HEIGHT);
        setLocationRelativeTo(parent);
    }

    private void initializeVariables() {
        service = new AddPolizaService();
        cabezaPanel = new JPanel();
        buttonPanel = new JPanel();
        camposPanel = new JPanel();
        guardarButton = new JButton(StringsConstants.SAVE);
        guardarButton.addActionListener(this);
        ramoLabel = new JLabel(StringsConstants.BRANCH);
        ramo = new JComboBox<>(StringsConstants.BRANCHES_ARRAY);
        ramo.addActionListener(this);
        numeroLabel = new JLabel(StringsConstants.NUMBER_POLICY);
        numero = new JTextField(NumberConstants.POLICY_FIELD);
        numero.setInputVerifier(isNumber);
    }

    private void initializeLayout() {
        setLayout(new BorderLayout());
        cabezaPanel.setLayout(new FlowLayout());
        cabezaPanel.add(ramoLabel);
        cabezaPanel.add(ramo);
        cabezaPanel.add(numeroLabel);
        cabezaPanel.add(numero);
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(guardarButton);
        add(cabezaPanel, BorderLayout.NORTH);
        add(camposPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        if(event == guardarButton) {
            guardarPoliza();
        } else if(event == ramo) {
            setCampos();
        }
    }

    private void guardarPoliza() {
        String numeroStr = numero.getText();
        Date ini = inicio.getDate();
        Date fini = fin.getDate();
        String costoStr = costo.getText();
        if(!numeroStr.isEmpty() && !costoStr.isEmpty()) {
            if(ramo.getSelectedItem() == "RCE") {
                RCE rce = new RCE();
                rce.setNumero(Integer.valueOf(numeroStr));
                rce.setInicio(ini);
                rce.setFin(fini);
                rce.setValor(Integer.valueOf(costoStr));
                rce.setValorUrbanos(Integer.valueOf(valorUrbanos.getText()));
                rce.setComisionATC(Integer.valueOf(comisionATC.getText()));
                service.addPoliza(rce);
                if(parentM != null) {
                    parentM.refreshTable();
                }
                this.setVisible(false);
            } else if(ramo.getSelectedItem() == "Vida") {
                Vida vida = new Vida();
                vida.setNumero(Integer.valueOf(numeroStr));
                vida.setInicio(ini);
                vida.setFin(fini);
                vida.setValor(Integer.valueOf(costoStr));
                vida.setValorUrbanos(Integer.valueOf(valorUrbanos.getText()));
                service.addPoliza(vida);
                if(parentM != null) {
                    parentM.refreshTable();
                }
                this.setVisible(false);
            } else if(ramo.getSelectedItem() == "Transporte") {
                Transporte trans = new Transporte();
                trans.setNumero(Integer.valueOf(numeroStr));
                trans.setInicio(ini);
                trans.setFin(fini);
                trans.setValor(Integer.valueOf(costoStr));
                trans.setComisionATC(Integer.valueOf(comisionATC.getText()));
                service.addPoliza(trans);
                if(parentM != null) {
                    parentM.refreshTable();
                }
                this.setVisible(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, StringsConstants.INCOMPLETE_DATA_MESSAGE,
                    StringsConstants.APP_NAME,
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setCampos() {
        jLabelArray = new ArrayList<>();
        jComponentArray = new ArrayList<>();
        camposPanel.removeAll();
        if(ramo.getSelectedItem() == "RCE") {
            setRCE();
        } else if(ramo.getSelectedItem() == "Vida") {
            setVida();
        } else if(ramo.getSelectedItem() == "Transporte") {
            setTransporte();
        }
        showCampos();
    }

    private void setVida() {
        setNoSet();
        valorUrbanosLabel = new JLabel(StringsConstants.URBAN_COST);
        jLabelArray.add(valorUrbanosLabel);
        valorUrbanos = new JTextField(NumberConstants.POLICY_FIELD);
        valorUrbanos.setInputVerifier(isNumber);
        jComponentArray.add(valorUrbanos);
    }

    private void setRCE() {
        setNoSet();
        valorUrbanosLabel = new JLabel(StringsConstants.URBAN_COST);
        jLabelArray.add(valorUrbanosLabel);
        valorUrbanos = new JTextField(NumberConstants.POLICY_FIELD);
        valorUrbanos.setInputVerifier(isNumber);
        jComponentArray.add(valorUrbanos);
        comisionATCLabel = new JLabel(StringsConstants.COMMISSION);
        jLabelArray.add(comisionATCLabel);
        comisionATC = new JTextField(NumberConstants.POLICY_FIELD);
        comisionATC.setInputVerifier(InputsVerifier.INSTANCE.isNumberNull);
        jComponentArray.add(comisionATC);
    }

    private void setTransporte() {
        setNoSet();
        comisionATCLabel = new JLabel(StringsConstants.COMMISSION);
        jLabelArray.add(comisionATCLabel);
        comisionATC = new JTextField(NumberConstants.POLICY_FIELD);
        comisionATC.setInputVerifier(InputsVerifier.INSTANCE.isNumberNull);
        jComponentArray.add(comisionATC);
    }

    private void setNoSet() {
        inicioLabel = new JLabel(StringsConstants.START_VALIDITY);
        jLabelArray.add(inicioLabel);
        inicio = new JDateChooser(new Date());
        jComponentArray.add(inicio);
        finLabel = new JLabel(StringsConstants.END_VALIDITY);
        jLabelArray.add(finLabel);
        fin = new JDateChooser(new Date());
        jComponentArray.add(fin);
        valorLabel = new JLabel(StringsConstants.COST);
        jLabelArray.add(valorLabel);
        costo = new JTextField(NumberConstants.POLICY_FIELD);
        costo.setInputVerifier(isNumber);
        jComponentArray.add(costo);
    }

    public void showCampos() {
        camposPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        Insets rightPadding = new Insets(0, 0, 0, 15);
        Insets noPadding = new Insets(0, 0, 0, 0);
        gc.gridy = 0;
        for(JLabel jL : jLabelArray) {
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
        for(JComponent jTF : jComponentArray) {
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

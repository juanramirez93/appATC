package com.atc.ui;

import com.atc.ui.documentos.CuentaCobroGenerator;
import com.atc.ui.documentos.ReintegroGenerator;
import com.atc.ui.usuario.MainUsuario;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JPanel implements ActionListener {

    private JButton usuariosButton;
    private JButton prueba;
    private JButton reintegrosButton;
    private JButton cuentasCobrosButton;

    public AdminPanel() {
        super();
        initializeLayout();
    }

    private void initializeLayout() {
        setLayout(new FlowLayout());
        setBorder(BorderFactory.createTitledBorder(StringsConstants.ADMIN_PANEL));
        usuariosButton = new JButton(StringsConstants.USUARIOS_MENU);
        usuariosButton.addActionListener(this);
        add(usuariosButton);

        reintegrosButton = new JButton(StringsConstants.REINTEGRO_MENU);
        reintegrosButton.addActionListener(this);
        add(reintegrosButton);

        cuentasCobrosButton = new JButton(StringsConstants.CTA_COBRO_MENU);
        cuentasCobrosButton.addActionListener(this);
        add(cuentasCobrosButton);

        prueba = new JButton("Prueba");
        prueba.addActionListener(this);
        add(prueba);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == usuariosButton) {
            new MainUsuario();
        } else if (e.getSource() == prueba) {

        }else if (e.getSource() == reintegrosButton) {
            new ReintegroGenerator();
        }else if (e.getSource() == cuentasCobrosButton) {
            new CuentaCobroGenerator();
        }
    }
}

package com.atc.ui;
import com.atc.ui.afiliacion.MainAfiliacion;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfiliacionesPanel extends JPanel implements ActionListener {

    private MainFrame parent;
    private JButton afiliacionesButton;
    private MainAfiliacion mainAfiliacion;

    public AfiliacionesPanel(MainFrame parent) {
        super();
        initializeLayout();
        this.parent = parent;
    }

    private void initializeLayout() {
        setLayout(new FlowLayout());
        setBorder(BorderFactory.createTitledBorder(StringsConstants.AFILIACIONES));
        afiliacionesButton = new JButton(StringsConstants.AFILIACIONES);
        afiliacionesButton.addActionListener(this);
        this.add(afiliacionesButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(afiliacionesButton)) {
            if(mainAfiliacion != null) {
                mainAfiliacion.dispose();
            }
            mainAfiliacion = new MainAfiliacion();
            mainAfiliacion.setVisible(true);
        }
    }
}

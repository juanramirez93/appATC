package com.atc.ui.abstractUI;

import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetAbstract<T> extends JDialog implements ActionListener {

    protected JTextArea dataArea;
    protected JPanel dataPanel;
    protected JPanel buttonPanel;
    private JButton backButton;
    private JButton editButton;
    protected T t;
    protected MainAbstract mainAbstract;


    public DetAbstract(MainAbstract<T> mainAbstract, T t, String name) {
        super(mainAbstract, name, true);
        this.t = t;
        this.mainAbstract = mainAbstract;
        initializeVariables();
    }

    private void setDataPanel(String datos) {

        BorderLayout layout = new BorderLayout();

        dataPanel.setLayout(layout);
        dataPanel.setBorder(BorderFactory.createTitledBorder(StringsConstants.DATOS));

        dataArea.setText(datos);
        dataPanel.add(dataArea, BorderLayout.CENTER);
        add(dataPanel, BorderLayout.CENTER);
    }

    private void initializeVariables() {
        dataPanel = new JPanel();
        buttonPanel = new JPanel();
        dataArea = new JTextArea();
        dataArea.setEditable(false);
        backButton = new JButton(StringsConstants.BACK);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.backButton) {
            setVisible(false);
        }
    }
}

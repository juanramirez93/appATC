package com.atc.ui.abstractUI;

import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CUDAbstract<T> extends JDialog implements ActionListener {

    protected JButton saveButton;
    protected JPanel headPanel;
    protected JPanel buttonPanel;
    protected DataPanelAbstract dataPanel;
    protected T t;
    protected MainAbstract<T> parent;

    public CUDAbstract(MainAbstract parent, T t, String name) {
        super(parent, name, true);
        this.parent = parent;
        this.t = t;
        initializeVariables();
        initializeLayout();
    }

    private void initializeLayout() {
        setLayout(new BorderLayout());
        headPanel.setLayout(new FlowLayout());
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(saveButton);

        add(headPanel, BorderLayout.NORTH);
        add(dataPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void initializeVariables() {
        saveButton = new JButton(StringsConstants.SAVE);
        saveButton.addActionListener(this);
        headPanel = new JPanel();
        buttonPanel = new JPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        if(event == saveButton) {
            if(dataPanel.saveData()) {
                if(parent != null) {
                    parent.refreshTable(null);
                }
                this.setVisible(false);
            }
        }
    }
}


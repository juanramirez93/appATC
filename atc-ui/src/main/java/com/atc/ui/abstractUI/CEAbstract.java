package com.atc.ui.abstractUI;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class CEAbstract<T> extends JFrame implements ActionListener {
    protected JButton backButton;
    protected JButton saveButton;

    protected JPanel buttonPanel;

    protected DataPanelAbstract<T> dataPanel;

    @Override
    public MainAbstract<T> getParent() {
        return parent;
    }

    protected MainAbstract<T> parent;

    public T getT() {
        return t;
    }

    protected T t;

    public CEAbstract(MainAbstract<T> parent, String title, T t) {
        super("Agregar " + title);
        this.parent = parent;
        this.t = t;
        initialize();
        initializeLayout();
    }

    private void initializeLayout() {
        this.setLayout(new BorderLayout());
        this.add(dataPanel, BorderLayout.CENTER);
        buttonPanel.add(backButton);
        buttonPanel.add(saveButton);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void initialize() {
        buttonPanel = new JPanel();
        saveButton = new JButton(StringsConstants.SAVE);
        saveButton.addActionListener(this);
        backButton = new JButton(StringsConstants.BACK);
        backButton.addActionListener(this);
        setDataPanel();
    }

    public abstract void setDataPanel();

    public abstract void save();

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(backButton)) {
            setVisible(false);
        } else if(e.getSource().equals(saveButton)) {
            save();
        }
    }
}

package com.atc.ui.abstractUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class DataPanelAbstract<T> extends JPanel {

    protected ArrayList<JLabel> labelArray;
    protected ArrayList<JComponent> componentArray;
    protected T data;

    public DataPanelAbstract() {
        super();
        setDataPanel();
        initializeVariables();
        setLabelArray();
        setComponentArray();
        printLayout();
    }

    private void initializeVariables() {
        labelArray = new ArrayList<>();
        componentArray = new ArrayList<>();
    }

    private void printLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        Insets rightPadding = new Insets(0, 0, 0, 15);
        Insets noPadding = new Insets(0, 0, 0, 0);
        gc.gridy = 0;

        for(JLabel jL : labelArray) {
            gc.weightx = 1;
            gc.weighty = 1;
            gc.fill = GridBagConstraints.NONE;

            gc.gridx = 0;
            gc.anchor = GridBagConstraints.EAST;
            gc.insets = rightPadding;
            add(jL, gc);
            gc.gridy++;
        }
        gc.gridy = 0;

        for(JComponent jTF : componentArray) {
            gc.weightx = 1;
            gc.weighty = 1;
            gc.fill = GridBagConstraints.NONE;

            gc.gridx = 1;
            gc.anchor = GridBagConstraints.WEST;
            gc.insets = noPadding;
            add(jTF, gc);

            gc.gridy++;
        }
        updateUI();
    }

    protected abstract void setLabelArray();

    protected abstract void setComponentArray();

    protected abstract void setDataPanel();

    public abstract boolean saveData();

    public abstract void fillData();

}

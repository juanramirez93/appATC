package com.atc.ui.abstractUI;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public abstract class DetailAbstract<T> extends JFrame implements ActionListener {

    protected JButton backButton;
    protected JButton editButton;

    protected JPanel buttonPanel;
    protected JPanel dataPanel;

    protected JTextArea dataArea;

    protected String[] labelArray;
    protected ArrayList<String> componentArray;
    protected T data;

    protected SimpleDateFormat formatDate = new SimpleDateFormat("dd-MMM-yyyy");
    protected DecimalFormat formatMoney = new DecimalFormat("$#,###");

    protected MainAbstract<T> parent;

    public DetailAbstract(MainAbstract<T> parent, String title) {
        super("Detalles " + title);
        this.parent = parent;
        initialize();
        initializeLayout();

    }

    private void initializeLayout() {
        BorderLayout layout = new BorderLayout();

        buttonPanel.add(backButton);
        buttonPanel.add(editButton);

        this.setLayout(layout);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    public abstract void setLabelArray();

    public abstract void setComponentArray();

    public abstract void edit();

    public void setDataPanel() {
        String datosStr = "";
        for(int i = 0; i < labelArray.length; i++) {
            datosStr += labelArray[i] + ": " + componentArray.get(i) + "\n";
        }
        dataArea.setText(datosStr);
        dataPanel.add(dataArea);
        this.add(dataPanel, BorderLayout.CENTER);
    }

    protected void initialize() {
        componentArray = new ArrayList<>();

        buttonPanel = new JPanel();
        editButton = new JButton(StringsConstants.EDIT);
        editButton.addActionListener(this);
        backButton = new JButton(StringsConstants.BACK);
        backButton.addActionListener(this);

        dataPanel = new JPanel();

        dataArea = new JTextArea();
        dataArea.setEditable(false);

    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == this.backButton) {
            setVisible(false);
        } else if(event.getSource() == this.editButton) {
            edit();
        }
    }
}

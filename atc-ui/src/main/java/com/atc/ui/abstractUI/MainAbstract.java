package com.atc.ui.abstractUI;

import com.atc.connection.Session;
import com.atc.model.Usuario;
import com.atc.ui.HeaderPanel;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public abstract class MainAbstract<T> extends JFrame implements ActionListener {

    protected JButton addButton;
    protected JButton backButton;
    protected JButton detailButton;
    protected JButton editButton;
    protected Usuario userSession = Session.INSTANCE.getUserSession();

    protected CEAbstract<T> ceFrame;
    protected DetailAbstract<T> detailFrame;

    protected JPanel panel;
    protected HeaderPanel headerPanel;
    protected JPanel buttonPanel;
    protected TableAbstract<T> table;
    protected SearchAbstract<T> search;

    public static final int LISTADO = 3;
    public static final int DETAILS = 5;
    public static final int EDIT = 7;
    public static final int ADD = 11;

    private String name;

    public MainAbstract(String name) {
        super(name);
        this.name = name;
        initializeVariables();
        setTable();
        setSearch();
        initializeLayout();
    }

    private void initializeLayout() {
        setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(backButton);
        buttonPanel.add(detailButton);
        buttonPanel.add(editButton);
        buttonPanel.add(addButton);
        panel.add(table, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        if(search != null) {
            panel.add(search, BorderLayout.NORTH);
        }
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
    }

    protected abstract void setTable();

    protected abstract void setSearch();

    protected void initializeVariables() {
        addButton = new JButton(StringsConstants.ADD);
        addButton.addActionListener(this);
        backButton = new JButton(StringsConstants.BACK);
        backButton.addActionListener(this);
        detailButton = new JButton(StringsConstants.VER_DETALLE);
        detailButton.addActionListener(this);
        editButton = new JButton(StringsConstants.EDIT);
        editButton.addActionListener(this);
        buttonPanel = new JPanel();
        panel = new JPanel();
        headerPanel = new HeaderPanel(name);
    }

    public abstract void refreshTable(List<T> t);
}

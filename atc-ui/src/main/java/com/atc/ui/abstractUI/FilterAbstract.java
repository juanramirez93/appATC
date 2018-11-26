package com.atc.ui.abstractUI;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public abstract class FilterAbstract<T> extends JPanel implements ActionListener {

    private JLabel filtrarLabel;

    protected ArrayList<JCheckBox> checkBoxes;
    protected SearchAbstract<T> mainParent;
    protected JPanel panelOptions;

    public FilterAbstract(SearchAbstract<T> mainParent) {
        super();
        this.mainParent = mainParent;
        this.checkBoxes = new ArrayList<>();
        filtrarLabel = new JLabel(StringsConstants.FILTRAR);
        setCheckBoxes();
        setLayout();
    }

    public ArrayList<JCheckBox> getCheckBoxes() {
        return checkBoxes;
    }

    protected abstract void setCheckBoxes();

    private void setLayout() {
        panelOptions = new JPanel();
        for(JCheckBox checkBox : checkBoxes) {
            checkBox.addActionListener(this);
            panelOptions.add(checkBox);
        }

        setLayout(new FlowLayout());
        this.add(filtrarLabel);
        this.add(panelOptions);
    }

}

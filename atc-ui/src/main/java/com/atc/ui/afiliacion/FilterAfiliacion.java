package com.atc.ui.afiliacion;
import com.atc.model.Afiliacion;
import com.atc.ui.abstractUI.FilterAbstract;
import com.atc.ui.abstractUI.SearchAbstract;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FilterAfiliacion extends FilterAbstract<Afiliacion> {

    public FilterAfiliacion(SearchAbstract<Afiliacion> mainParent) {
        super(mainParent);
    }

    @Override
    protected void setCheckBoxes() {
        for(String option : StringsConstants.FILTER_OPTIONS_AFILIACION) {
            JCheckBox checkBox = new JCheckBox(option);
            checkBox.setSelected(true);
            checkBoxes.add(checkBox);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainParent.search();
    }
}

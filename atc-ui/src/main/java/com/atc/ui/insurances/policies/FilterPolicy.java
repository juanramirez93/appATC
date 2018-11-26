package com.atc.ui.insurances.policies;
import com.atc.model.Policy;
import com.atc.service.PolicyService;
import com.atc.ui.abstractUI.FilterAbstract;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FilterPolicy extends FilterAbstract<Policy> {
    private PolicyService policyService;

    public FilterPolicy(SearchPolicy mainParent) {
        super(mainParent);
        policyService = new PolicyService();
    }

    @Override
    protected void setCheckBoxes() {
        for(String option : StringsConstants.FILTER_OPTIONS_POLICY) {
            JCheckBox checkBox = new JCheckBox(option);
            checkBox.setSelected(true);
            checkBoxes.add(checkBox);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainParent.filter(policyService.getAll());
    }
}

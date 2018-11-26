package com.atc.ui.insurances.policies;
import com.atc.model.Policy;
import com.atc.service.PolicyService;
import com.atc.ui.abstractUI.MainAbstract;
import com.atc.ui.abstractUI.SearchAbstract;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SearchPolicy extends SearchAbstract<Policy> {

    private PolicyService policyService;

    public SearchPolicy(MainAbstract<Policy> parent) {
        super(parent);
        policyService = new PolicyService();
    }

    @Override
    public void search() {
        List<Policy> policies;
        if(searchField.getText().equals("") || searchField.getText().isEmpty()) {
            policies = policyService.getAll();
        } else {
            String str = searchField.getText();
            policies = policyService.search(str);

        }
        if(filterPanel != null) {

            policies = filter(policies);
        }
        parent.refreshTable(policies);
    }

    public List<Policy> filter(List<Policy> policies) {
        List<Policy> newPolicies = new ArrayList<>();
        for(JCheckBox checkBox : filterPanel.getCheckBoxes()) {
            if(checkBox.isSelected()) {
                for(Policy policy : policies) {
                    if(policy.getState().equals(checkBox.getText())) {
                        newPolicies.add(policy);
                    }
                }
            }
        }
        return newPolicies;
    }

    @Override
    protected void setFilterPanel() {
        filterPanel = new FilterPolicy(this);
    }

}

package com.atc.ui.insurances.policies;
import com.atc.model.Policy;
import com.atc.service.PolicyService;
import com.atc.ui.abstractUI.MainAbstract;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MainPolicy extends MainAbstract<Policy> {

    private PolicyService policyService;

    public MainPolicy() {
        super(StringsConstants.POLICY_MENU);
        initialize();
    }

    protected void initialize() {
        this.policyService = new PolicyService();
        refreshTable(policyService.getAll());
        setSize(NumberConstants.MAINPOLICY_WIDH, NumberConstants.MAINPOLICY_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    protected void setTable() {
        this.table = new TablePolicy();
    }

    @Override
    protected void setSearch() {
        this.search = new SearchPolicy(this);
    }

    @Override
    public void refreshTable(List<Policy> t) {
        this.table.setList(t);
        this.table.updateTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(addButton)) {
            if(userSession.getPermisos().getPoliza() % ADD == 0) {
                ceFrame = new CEPolicy(this, null);
                ceFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
            }
        } else if(e.getSource().equals(detailButton)) {
            if(userSession.getPermisos().getPoliza() % DETAILS == 0) {
                if(table.getSelected() == null) {
                    JOptionPane.showMessageDialog(this, StringsConstants.SELECT_REGISTER);
                } else {
                    detailFrame = new DetailPolicy(this, table.getSelected());
                    detailFrame.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
            }
        } else if(e.getSource().equals(editButton)) {
            if(userSession.getPermisos().getPoliza() % EDIT == 0) {
                if(table.getSelected() == null) {
                    JOptionPane.showMessageDialog(this, StringsConstants.SELECT_REGISTER);
                } else {
                    ceFrame = new CEPolicy(this, table.getSelected());
                    ceFrame.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
            }
        } else if(e.getSource().equals(backButton)) {
            this.setVisible(false);
        }
    }
}

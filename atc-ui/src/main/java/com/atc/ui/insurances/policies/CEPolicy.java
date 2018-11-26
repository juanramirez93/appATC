package com.atc.ui.insurances.policies;
import com.atc.model.Policy;
import com.atc.service.PolicyService;
import com.atc.ui.abstractUI.CEAbstract;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

public class CEPolicy extends CEAbstract<Policy> {

    private PolicyService policyService;

    public CEPolicy(MainPolicy mainPolicy, Policy policy) {
        super(mainPolicy, StringsConstants.POLICY_MENU, policy);
        policyService = new PolicyService();
        setSize(NumberConstants.VECPOLICY_WIDTH, NumberConstants.VECPOLICY_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    public void setDataPanel() {
        dataPanel = new DataPanelPolicy(t);
    }

    @Override
    public void save() {
        if(dataPanel.saveData()) {
            if(parent != null) {
                parent.refreshTable(policyService.getAll());
            }
            this.setVisible(false);
        }
    }
}

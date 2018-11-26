package com.atc.ui.insurances.policies;
import com.atc.model.Policy;
import com.atc.ui.abstractUI.DetailAbstract;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

public class DetailPolicy extends DetailAbstract<Policy> {

    public DetailPolicy(MainPolicy mainPolicy, Policy policy) {
        super(mainPolicy, StringsConstants.POLICY_MENU);
        setSize(NumberConstants.DETAILPOLICY_WIDTH, NumberConstants.DETAILPOLIZA_HEIGHT);
        setLocationRelativeTo(null);
        data = policy;
        setLabelArray();
        setComponentArray();
        setDataPanel();
    }

    @Override
    public void setLabelArray() {
        labelArray = StringsConstants.POLICY_FIELDS;
    }

    @Override
    public void setComponentArray() {
        componentArray.add(data.getNumber());
        componentArray.add(data.getBranch());
        componentArray.add(formatMoney.format(data.getCost()));
        componentArray.add(formatMoney.format(data.getUrbanCost()));
        if(data.getStartValidity() != null) {
            componentArray.add(formatDate.format(data.getStartValidity()));
        } else {
            componentArray.add("");
        }
        if(data.getEndValidity() != null) {
            componentArray.add(formatDate.format(data.getEndValidity()));
        } else {
            componentArray.add("");
        }
        componentArray.add(String.valueOf(data.getAtcCommission()));
        componentArray.add(data.getState());
    }

    @Override
    public void edit() {
        CEPolicy cePolicy = new CEPolicy(null, data);
        cePolicy.setVisible(true);
        this.dispose();
    }
}

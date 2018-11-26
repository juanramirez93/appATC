package com.atc.ui.insurances.policies;
import com.atc.model.Policy;
import com.atc.ui.abstractUI.TableAbstract;
import com.atc.util.StringsConstants;

import java.util.List;

public class TablePolicy extends TableAbstract<Policy> {

    @Override
    protected void setModel() {
        model = new TableModelPolicies(StringsConstants.POLICIES_TABLE_FIELDS);
        table.setModel(model);
    }

    @Override
    public void setList(List<Policy> policies) {
        model.setList(policies);
    }

    @Override
    protected void setColumnLayout() {
    }
}

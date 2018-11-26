package com.atc.ui.insurances.policies;
import com.atc.model.Policy;
import com.atc.ui.abstractUI.TableModelAbstract;

import java.util.List;

public class TableModelPolicies extends TableModelAbstract<Policy> {
    public TableModelPolicies(String[] columns) {
        super(columns);
    }

    @Override
    public void setList(List<Policy> policies) {
        tList = policies;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Policy policy = tList.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return policy.getNumber();
            case 1:
                return policy.getBranch();
            case 2:
                return policy.getCost();
            case 3:
                return policy.getUrbanCost();
            case 4:
                return policy.getState();
        }
        return null;
    }
}

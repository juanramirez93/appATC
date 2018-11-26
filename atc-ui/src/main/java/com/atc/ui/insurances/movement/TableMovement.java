package com.atc.ui.insurances.movement;
import com.atc.model.Movement;
import com.atc.ui.abstractUI.TableAbstract;
import com.atc.util.StringsConstants;

import javax.swing.table.TableColumnModel;
import java.util.List;

public class TableMovement extends TableAbstract<Movement> {

    @Override
    protected void setModel() {
        model = new TableModelMovement(StringsConstants.MOVEMENT_TABLE_FIELDS);
        table.setModel(model);
    }

    @Override
    public void setList(List<Movement> movements) {
        model.setList(movements);
    }

    @Override
    protected void setColumnLayout() {
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(190);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(15);
        columnModel.getColumn(4).setPreferredWidth(15);
        columnModel.getColumn(5).setPreferredWidth(15);
    }
}

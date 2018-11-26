package com.atc.ui.insurances.movement;
import com.atc.model.Movement;
import com.atc.ui.abstractUI.TableModelAbstract;

import java.util.List;

public class TableModelMovement extends TableModelAbstract<Movement> {
    public TableModelMovement(String[] columns) {
        super(columns);
    }

    @Override
    public void setList(List<Movement> movements) {
        tList = movements;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Movement movement = tList.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return movement.getDate();
            case 1:
                return movement.getProduct().getEmpresa().getNombre();
            case 2:
                return movement.getType();
            case 3:
                return movement.getQuantity();
            case 4:
                return movement.getFactVida();
            case 5:
                return movement.getRemRCE();
            case 6:
                return movement.getRemTransporte();
        }
        return null;
    }
}

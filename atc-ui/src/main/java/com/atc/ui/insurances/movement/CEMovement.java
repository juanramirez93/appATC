package com.atc.ui.insurances.movement;
import com.atc.model.Movement;
import com.atc.ui.abstractUI.CEAbstract;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

public class CEMovement extends CEAbstract<Movement> {
    public CEMovement(MainMovement mainMovement, Movement movement) {
        super(mainMovement, StringsConstants.MOVEMENT_MENU, movement);
        setSize(NumberConstants.CEMOVEMENT_WIDTH, NumberConstants.CEMOVEMENT_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    public void setDataPanel() {
        dataPanel = new DataPanelMovement(t);
    }

    @Override
    public void save() {
    }
}

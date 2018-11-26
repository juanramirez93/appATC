package com.atc.ui.insurances.movement;
import com.atc.model.Movement;
import com.atc.service.MovementService;
import com.atc.ui.abstractUI.MainAbstract;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MainMovement extends MainAbstract<Movement> {
    MovementService movementService = MovementService.INSTANCE;

    public MainMovement() {
        super(StringsConstants.MOVEMENT_TITLE);
        initialize();
    }

    private void initialize() {
        refreshTable(movementService.getAll());
        setSize(NumberConstants.MAINMOVEMENT_WIDTH, NumberConstants.MAINMOVEMENT_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    protected void setTable() {
        table = new TableMovement();
    }

    @Override
    protected void setSearch() {
        search = new SearchMovement(this);
    }

    @Override
    public void refreshTable(List<Movement> t) {
        table.setList(t);
        table.updateTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(addButton)) {
            if(userSession.getPermisos().getMovimiento() % ADD == 0) {
                ceFrame = new CEMovement(this, null);
                ceFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
            }
        }
    }
}

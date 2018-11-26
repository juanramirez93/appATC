package com.atc.ui.insurances.movement;
import com.atc.model.Movement;
import com.atc.service.MovementService;
import com.atc.ui.abstractUI.MainAbstract;
import com.atc.ui.abstractUI.SearchAbstract;

import java.util.List;

public class SearchMovement extends SearchAbstract<Movement> {

    MovementService movementService = MovementService.INSTANCE;

    public SearchMovement(MainAbstract<Movement> parent) {
        super(parent);
    }

    @Override
    public void search() {
        List<Movement> movements;
        if(searchField.getText().equals("") || searchField.getText().isEmpty()) {
            movements = movementService.getAll();
        } else {
            String str = searchField.getText();
            movements = movementService.search(str);
        }
        if(filterPanel != null) {
            movements = filter(movements);
        }
        parent.refreshTable(movements);
    }

    @Override
    protected void setFilterPanel() {
    }

    @Override
    public List<Movement> filter(List<Movement> movements) {
        return null;
    }
}

package com.atc.service;
import com.atc.connection.MovementEM;
import com.atc.model.Movement;

import java.util.List;

public enum MovementService {
    INSTANCE;

    private MovementEM movementEM = new MovementEM();

    public List<Movement> getAll() {
        return movementEM.getAll();
    }

    public List<Movement> search(String str) {
        return search(str);
    }

    public void update(Movement data) {
        movementEM.update(data);
    }
}

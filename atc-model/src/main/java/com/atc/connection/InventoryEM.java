package com.atc.connection;
import com.atc.model.Inventory;

import javax.persistence.TypedQuery;
import java.util.List;

public class InventoryEM extends EM implements AbstractEntityManager<Inventory> {
    @Override
    public List<Inventory> getAll() {
        return null;
    }

    @Override
    public List<Inventory> search(String str) {
        return null;
    }

    @Override
    public void save(Inventory o) {
    }

    @Override
    public void update(Inventory o) {
    }

    public String getNumeration(String tipo, int cantidad) {
        open();
        TypedQuery<Inventory> query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery(
                "SELECT i FROM Inventory i WHERE i.product = '" + tipo +
                        "' AND i.remaining > 0 ORDER BY i.start ASC",
                Inventory.class);
        List<Inventory> inventory = query.getResultList();
        if(inventory.isEmpty()) {
            return "No hay existencia";
        }
        int restantes = cantidad;
        int i = 0;
        String numeracion = "";
        while(restantes > 0 && i < inventory.size()) {
            Inventory st = inventory.get(i);
            int existencia = st.getRemaining();
            if(existencia >= restantes) {
                numeracion += st.getNext() + " - " + (st.getNext() + restantes - 1);
                restantes = 0;
            } else {
                numeracion += st.getNext() + " - " + st.getEnd() + "// ";
                restantes = restantes - st.getRemaining();
            }
            i++;
        }
        if(restantes == 0) {
            return numeracion;
        } else {
            return "No hay existencia";
        }
    }
}

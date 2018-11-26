package com.atc.connection;
import com.atc.model.Movement;

import javax.persistence.TypedQuery;
import java.util.List;

public class MovementEM extends EM implements AbstractEntityManager<Movement> {
    @Override
    public List<Movement> getAll() {
        open();
        TypedQuery<Movement> query = EntityManagerHandler.INSTANCE.getEntityManager()
                .createQuery("SELECT m FROM Movement m ORDER BY m.date DESC",
                        Movement.class);
        return query.getResultList();
    }

    @Override
    public List<Movement> search(String str) {
        open();
        TypedQuery<Movement> query = EntityManagerHandler.INSTANCE.getEntityManager()
                .createQuery(
                        "SELECT m FROM Movement m where m.product.empresa.siglas like '%" + str
                                + "%' OR m.product.empresa.razonSocial like '%" + str +
                                "%' OR m.product.empresa.nit like '%"
                                + str + "%' OR m.numeration like '%" + str +
                                "%' OR m.remRCE like '%" + str
                                + "%' OR m.remTransporte like '%" + str +
                                "%' OR m.factVida like '%" + str
                                + "%' OR m.factRCE like '%" + str +
                                "%' OR m.factTransp like '%" + str
                                + "%' OR m.recibo like '%" + str + "%'", Movement.class);
        return query.getResultList();
    }

    @Override
    public void save(Movement o) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(o);
        EntityManagerHandler.INSTANCE.getEntityManager().getTransaction().commit();
    }

    @Override
    public void update(Movement o) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().merge(o);
        EntityManagerHandler.INSTANCE.getEntityManager().getTransaction().commit();
    }
}

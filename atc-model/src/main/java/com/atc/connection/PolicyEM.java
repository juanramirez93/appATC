package com.atc.connection;

import com.atc.model.Policy;

import javax.persistence.TypedQuery;
import java.util.List;

public class PolicyEM extends EM implements AbstractEntityManager<Policy> {

    public List<Policy> getAll() {
        open();
        TypedQuery<Policy> query = EntityManagerHandler.INSTANCE.getEntityManager()
                .createQuery("SELECT p FROM Policy p ORDER BY p.number ASC", Policy.class);
        List<Policy> policies = query.getResultList();
        return policies;
    }

    public List<Policy> getAllVida() {
        open();
        TypedQuery<Policy> query = EntityManagerHandler.INSTANCE.getEntityManager()
                .createQuery("SELECT p FROM Policy p WHERE p.branch = 'Vida' ORDER BY p.number ASC",
                        Policy.class);
        List<Policy> policies = query.getResultList();
        return policies;
    }

    public void save(Policy o) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(o);
        EntityManagerHandler.INSTANCE.getEntityManager().getTransaction().commit();
    }

    public boolean exist(String number) {
        for(Policy policy : getAll()) {
            if(policy.getNumber().equals(number)) {
                return true;
            }
        }
        return false;
    }

    public List<Policy> search(String str) {
        open();
        TypedQuery<Policy> query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery(
                "SELECT p FROM Policy p where p.number like '%" + str + "%' OR p.branch like '%" +
                        str + "%'",
                Policy.class);
        return query.getResultList();
    }

    public Policy getPolicyByNumber(String number) {
        for(Policy policy : getAll()) {
            if(policy.getNumber().equals(number)) {
                return policy;
            }
        }
        return null;
    }

    public void update(Policy o) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(o);
        EntityManagerHandler.INSTANCE.getEntityManager().getTransaction().commit();
    }

    public List<Policy> getAllRCE() {
        open();
        TypedQuery<Policy> query = EntityManagerHandler.INSTANCE.getEntityManager()
                .createQuery("SELECT p FROM Policy p WHERE p.branch = 'RCE' ORDER BY p.number ASC",
                        Policy.class);
        return query.getResultList();
    }

    public List<Policy> getAllTransporte() {
        open();
        TypedQuery<Policy> query = EntityManagerHandler.INSTANCE.getEntityManager()
                .createQuery("SELECT p FROM Policy p WHERE p.branch = 'Transporte' ORDER BY p" +
                                ".number ASC",
                        Policy.class);
        return query.getResultList();
    }
}

package com.atc.connection;
import com.atc.model.Product;

import javax.persistence.TypedQuery;
import java.util.List;

public class ProductEM extends EM {
    public List<Product> getAll() {
        open();
        TypedQuery<Product> query = EntityManagerHandler.INSTANCE.getEntityManager()
                .createQuery("SELECT p FROM Product p ORDER BY p.empresa.nombre ASC",
                        Product.class);
        List<Product> products = query.getResultList();
        return products;
    }

    public void save(Product product) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(product);
        EntityManagerHandler.INSTANCE.getEntityManager().getTransaction().commit();
    }

    public List<Product> search(String str) {
        open();
        TypedQuery<Product> query = EntityManagerHandler.INSTANCE.getEntityManager()
                .createQuery(
                        "SELECT p FROM Product p where p.empresa.nit like '%" + str
                                + "%' OR p.empresa.razonSocial like '%" + str +
                                "%' OR p.empresa.siglas like '%" + str
                                + "%' OR p.modality like '%" + str + "%'",
                        Product.class);
        List<Product> products = query.getResultList();
        return products;
    }

    public void update(Product o) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().merge(o);
        EntityManagerHandler.INSTANCE.getEntityManager().getTransaction().commit();
    }
}

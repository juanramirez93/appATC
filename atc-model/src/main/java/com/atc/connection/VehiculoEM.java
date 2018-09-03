package com.atc.connection;

import com.atc.model.Vehiculo;

import javax.persistence.TypedQuery;
import java.util.List;

public class VehiculoEM extends EM implements AbstractEntityManager<Vehiculo> {

	public List<Vehiculo> getAll() {
		open();
		TypedQuery<Vehiculo> query = EntityManagerHandler.INSTANCE.getEntityManager()
				.createQuery("SELECT v FROM Vehiculo v ORDER BY placa ASC", Vehiculo.class);
		List<Vehiculo> vehiculos = query.getResultList();
		return vehiculos;
	}

	public List<Vehiculo> search(String str) {
		open();
		TypedQuery<Vehiculo> query = EntityManagerHandler.INSTANCE.getEntityManager()
				.createQuery("SELECT v FROM Vehiculo v WHERE v.placa '%" + str + "%' ORDER BY placa ASC ", Vehiculo.class);
		List<Vehiculo> vehiculos = query.getResultList();
		return vehiculos;
	}

	public void save(Vehiculo o) {
		open();
		EntityManagerHandler.INSTANCE.getEntityManager().persist(o);
		EntityManagerHandler.INSTANCE.getEntityManager().getTransaction().commit();
	}

	public void update(Vehiculo o) {
		open();
		EntityManagerHandler.INSTANCE.getEntityManager().merge(o);
		EntityManagerHandler.INSTANCE.getEntityManager().getTransaction().commit();
	}

}

package com.atc.connection;

import com.atc.model.Persona;

import javax.persistence.TypedQuery;
import java.util.List;

public class PersonaEM extends EM implements AbstractEntityManager<Persona> {

	public List<Persona> getAll() {
		open();
		TypedQuery<Persona> query = EntityManagerHandler.INSTANCE.getEntityManager()
				.createQuery("SELECT p FROM Persona p ORDER BY identificacion ASC", Persona.class);
		List<Persona> resultList = query.getResultList();
		return resultList;
	}

		public Persona getNaturalByIdentificaicion(long identificacion) {
		for (Persona persona : getAll()) {
			if (persona.getIdentificacion() == identificacion) {
				return persona;
			}
		}
		return null;
	}

		public List<Persona> search(String str) {
			// TODO Auto-generated method stub
			return null;
		}

		public void save(Persona o) {
			// TODO Auto-generated method stub
			
		}

		public void update(Persona o) {
			// TODO Auto-generated method stub
			
		}

}

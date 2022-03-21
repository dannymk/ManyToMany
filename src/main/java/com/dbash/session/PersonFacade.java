package com.dbash.session;

import com.dbash.entities.Person;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Daniel Maldonado
 */
@Stateless
public class PersonFacade extends AbstractFacade<Person> {

	@PersistenceContext(unitName = "backenddb")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public PersonFacade() {
		super(Person.class);
	}

}

package com.dbash.session;

import com.dbash.entities.OrganizationPerson;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Daniel Maldonado
 */
@Stateless
public class OrganizationPersonFacade extends AbstractFacade<OrganizationPerson> {

	@PersistenceContext(unitName = "backenddb")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public OrganizationPersonFacade() {
		super(OrganizationPerson.class);
	}

}

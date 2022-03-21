package com.dbash.session;

import com.dbash.entities.Organization;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Daniel Maldonado
 */
@Stateless
public class OrganizationFacade extends AbstractFacade<Organization> {

	@PersistenceContext(unitName = "backenddb")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public OrganizationFacade() {
		super(Organization.class);
	}

}

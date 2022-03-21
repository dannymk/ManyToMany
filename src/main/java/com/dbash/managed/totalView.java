package com.dbash.managed;

import com.dbash.entities.Organization;
import com.dbash.entities.OrganizationPerson;
import com.dbash.entities.Person;
import com.dbash.session.OrganizationFacade;
import com.dbash.session.OrganizationPersonFacade;
import com.dbash.session.PersonFacade;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Daniel Maldonado
 */
@Named("tester")
@RequestScoped
public class totalView {
	@Inject  
	PersonFacade peopleManager;
	@Inject
	OrganizationFacade organizationManager;
	@Inject
	OrganizationPersonFacade membershipManager;
	
	public void create(){
		// Create the person entity - this works fine: check the database
		Person person = new Person();
		person.setFirstName("John");
		person.setLastName("Doe");
		peopleManager.create(person);
		
		// Create the organization entity - this works fine: check the database
		Organization organization = new Organization();
		organization.setAcronym("TMP");
		organization.setName("Testing Multiple Points");
		organization.setNotes("Just your average Organization");
		organizationManager.create(organization);

		// ********* THIS FAILS!!!!		
		// Create the membership - Person is a member via OrganizationPerson 
		OrganizationPerson membership = new OrganizationPerson(organization, person);
		membershipManager.create(membership);
		person.getOrganizations().add(membership);
		organization.getPeople().add(membership);
		
		
	}
	
	
	
}

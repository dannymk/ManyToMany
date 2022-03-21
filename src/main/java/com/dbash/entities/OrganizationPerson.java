package com.dbash.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daniel Maldonado
 * 
 * *****************   SEE:  https://www.baeldung.com/jpa-many-to-many
 * 
 */
@Entity
@Table(name="memberships")
public class OrganizationPerson implements Serializable {

   @EmbeddedId
	private OrganizationPersonId id;
	
   @ManyToOne
	@MapsId("organizationId")
   @JoinColumn(name="organization_fk")
   private Organization organization;
	
   @ManyToOne
	@MapsId("personId")
   @JoinColumn(name="person_fk")
   private Person person;
	
	@Column(nullable = false)
   @Temporal(TemporalType.DATE)
   private Date requested;	
	@Column(nullable = true)
   @Temporal(TemporalType.DATE)
   private Date registered;
	@Column(nullable = false)
   @Temporal(TemporalType.DATE)
   private Date expires;
	private String memberId;	
	
	public OrganizationPerson(){
	}
	
	/***
	 * 
	 * @param organization
	 * @param person 
	 */
	public OrganizationPerson(Organization organization, Person person){
		this.organization = organization;
		this.person = person;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		OrganizationPerson other = (OrganizationPerson) obj;
		return Objects.equals(this.getOrganization(), other.getOrganization()) && Objects.equals(this.getPerson(), other.getPerson());
	}

	@Override
	public int hashCode() {
		return (int)(this.getPerson().getId() + this.getOrganization().getId());
	}

	@Override
	public String toString() {
		return "OrganizationPerson[ id=" + this.getMemberId() + " ]";
	}

	/**
	 * @return the organization
	 */
	public Organization getOrganization() {
		return organization;
	}

	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * @return the registered
	 */
	public Date getRegistered() {
		return registered;
	}

	/**
	 * @param registered the registered to set
	 */
	public void setRegistered(Date registered) {
		this.registered = registered;
	}

	/**
	 * @return the expires
	 */
	public Date getExpires() {
		return expires;
	}

	/**
	 * @param expires the expires to set
	 */
	public void setExpires(Date expires) {
		this.expires = expires;
	}

	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the requested
	 */
	public Date getRequested() {
		return requested;
	}

	/**
	 * @param requested the requested to set
	 */
	public void setRequested(Date requested) {
		this.requested = requested;
	}

	/**
	 * @return the id
	 */
	public OrganizationPersonId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(OrganizationPersonId id) {
		this.id = id;
	}

}

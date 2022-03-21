package com.dbash.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Daniel Maldonado
 */
@Embeddable
public class OrganizationPersonId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="customer_cpk")
	private Long personId;
	@Column(name="organization_cpk")
	private Long organizationId;

	public OrganizationPersonId() {

	}

	public OrganizationPersonId(Long organizationId, Long personId) {
		this.organizationId = organizationId;
		this.personId = personId;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				  + ((organizationId == null) ? 0 : organizationId.hashCode());
		result = prime * result
				  + ((personId == null) ? 0 : personId.hashCode());
		return result;
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
		OrganizationPersonId other = (OrganizationPersonId) obj;
		return Objects.equals(this.getOrganizationId(), other.getOrganizationId()) && Objects.equals(this.getPersonId(), other.getPersonId());
	}

	@Override
	public String toString() {
		return "OrganizationPersionId[ id=" + this.getPersonId() + "->" + this.getPersonId() + " ]";
	}

	/**
	 * @return the personId
	 */
	public Long getPersonId() {
		return personId;
	}

	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	/**
	 * @return the organizationId
	 */
	public Long getOrganizationId() {
		return organizationId;
	}

	/**
	 * @param organizationId the organizationId to set
	 */
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

}

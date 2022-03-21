package com.dbash.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Daniel Maldonado
 */
@Entity
@Table(name = "organizations")
public class Organization implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   @Column(nullable = false)   
   private String name;
   @Column(nullable = false)   
   private String acronym;
   private String notes;
	
	@OneToMany(mappedBy = "organization")
   private Set<OrganizationPerson> people = new HashSet();
		
	public Organization(){
	}
	
   @Override
   public int hashCode() {
      int hash = 0;
      hash += (id != null ? id.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      if (!(object instanceof Organization)) {
         return false;
      }
      Organization other = (Organization) object;
      return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
   }

   @Override
   public String toString() {
      return "Organization[ id=" + id + " ]";
   }
	
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   /**
    * @return the name
    */
   public String getName() {
      return name;
   }

   /**
    * @param name the name to set
    */
   public void setName(String name) {
      this.name = name;
   }

   /**
    * @return the notes
    */
   public String getNotes() {
      return notes;
   }

   /**
    * @param notes the notes to set
    */
   public void setNotes(String notes) {
      this.notes = notes;
   }

   /**
    * @return the acronym
    */
   public String getAcronym() {
      return acronym;
   }

   /**
    * @param acronym the acronym to set
    */
   public void setAcronym(String acronym) {
      this.acronym = acronym;
   }

	/**
	 * @return the people
	 */
	public Set<OrganizationPerson> getPeople() {
		return people;
	}

	/**
	 * @param people the people to set
	 */
	public void setPeople(Set<OrganizationPerson> people) {
		this.people = people;
	}

}

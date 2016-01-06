/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Nuno
 */

@Entity
@Table(name="userprofile")
public class UserProfile {
    

    private int id;

    private String designation;
    /*
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="USERPROFILE_PROFILE_ID")
    private User user;
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROFILE_ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotEmpty
    @Size(min=3,max=20)
    @Column(name = "PROFILE_DESIGNATION", nullable = false)
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    

/*
    public void addUser(User user) {
        user.setUserProfile(this);
        users.add(user);
    }
  */  
       @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UserProfile))
			return false;
		UserProfile other = (UserProfile) obj;
		if (id != other.id)
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", description=" + designation + "]";
	}
    
}

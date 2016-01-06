/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Nuno
 */

@Entity
@Table(name="user")
public class User {
    

    private int id;
    private String name;
    private String password;
    private String email;
    private String address;
    private long telephone;
    private long nif;
    private UserProfile userProfile;
    
       /*
    @ManyToOne
    @JoinColumn(name = "USERPROFILE_PROFILE_ID", nullable = false)
    private UserProfile userProfile;
   */
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotEmpty
    @Size(min=3, max=50)
    @Column(name = "USER_NAME", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotEmpty
    @Size(min=3, max=100)
    @Column(name = "USER_PASSWORD", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        
    @Size(min=3, max=50)
    @Column(name = "USER_EMAIL", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        
    @Size(min=3, max=200)
    @Column(name = "USER_ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    //@Size(min=9, max=9)
    @Column(name = "USER_TELEPHONE", nullable = false)
    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }
    
    //@Size(min=9, max=9)
    @Column(name = "USER_NIF", nullable = false)
    public long getNif() {
        return nif;
    }

    public void setNif(long nif) {
        this.nif = nif;
    } 

    @ManyToOne(cascade = CascadeType.ALL)
    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }


    
    
    	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;

		return true;
	}
        
        

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" +password+ ", email=" +email+ ", telephone="+telephone+ ",nif="+nif+ ",address="+address+"]";
	}
    
}

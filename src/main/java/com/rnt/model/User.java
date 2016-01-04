/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Nuno
 */

@Entity
@Table(name="USER")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotEmpty
    @Size(min=3, max=50)
    @Column(name = "USER_NAME", nullable = false)
    private String name;
    
    @NotEmpty
    @Size(min=3, max=100)
    @Column(name = "USER_PASSWORD", nullable = false)
    private String password;
    
    @Size(min=3, max=50)
    @Column(name = "USER_EMAIL", nullable = false)
    private String email;
    
    @Size(min=3, max=200)
    @Column(name = "USER_ADDRESS")
    private String address;
    
    //@Size(min=9, max=9)
    @Column(name = "USER_TELEPHONE", nullable = false)
    private long telephone;
    
    //@Size(min=9, max=9)
    @Column(name = "USER_NIF", nullable = false)
    private long nif;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_profile_id", nullable = false)
    private UserProfile userProfile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public long getNif() {
        return nif;
    }

    public void setNif(long nif) {
        this.nif = nif;
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

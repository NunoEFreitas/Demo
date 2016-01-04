/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.service;

import com.rnt.model.User;
import java.util.List;

/**
 *
 * @author Nuno
 */
public interface UserService {
    
    	User findById(int id);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserByNif(long nif);

	List<User> findAllUsers(); 
	
	User findUserByNif(long nif);

        List<User> findUserByName(String name);
        
        void deleteUserById(int id);
    
}

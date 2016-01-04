/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.service;

import com.rnt.dao.UserDao;
import com.rnt.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nuno
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserDao dao;

    public User findById(int id) {
        return dao.findById(id);
    }

    public void saveUser(User user) {
        dao.saveUser(user);
    }
    
    /*
    In the future when the connection many to one is implemented, will have to change the update
    */
    public void updateUser(User user) {
        User entity = dao.findById(user.getId());
	if(entity!=null){
            entity.setAddress(user.getAddress());
            entity.setEmail(user.getEmail());
            entity.setName(user.getName());
            entity.setNif(user.getNif());
            entity.setPassword(user.getPassword());
            entity.setTelephone(user.getTelephone());
	}
    }

    public void deleteUserByNif(long nif) {
        dao.deleteUserByNif(nif);
    }

    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }

    public User findUserByNif(long nif) {
        return dao.findUserByNif(nif);
    }

    public List<User> findUserByName(String name) {
        return dao.fingUserByName(name);
    }
    
    
    
}

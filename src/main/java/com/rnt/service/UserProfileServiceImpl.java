/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.service;

import com.rnt.dao.UserProfileDao;
import com.rnt.model.UserProfile;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nuno
 */
@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService{
    
    @Autowired
    private UserProfileDao dao;

    public UserProfile findById(int id) {
        return dao.findById(id);
    }

    public void saveUserProfile(UserProfile userProfile) {
        dao.saveUserProfile(userProfile);
    }

    public void deleteUserProfileById(int id) {
        dao.deleteUserProfileById(id);
    }

    public List<UserProfile> listUserProfiles() {
        return dao.listUserProfiles();
    }

    public void updateUserProfile(UserProfile userProfile) {
        UserProfile entity = dao.findById(userProfile.getId());
        if(entity!=null){
            entity.setDesignation(userProfile.getDesignation());
        }
        
    }
    
}

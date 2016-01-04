/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.service;

import com.rnt.model.UserProfile;
import java.util.List;

/**
 *
 * @author Nuno
 */
public interface UserProfileService {
    
    UserProfile findById(int id);
    
    void saveUserProfile(UserProfile userProfile);
    
    void deleteUserProfileById(int id);
    
    List<UserProfile> listUserProfiles();
    
    void updateUserProfile(UserProfile userProfile);
    
}

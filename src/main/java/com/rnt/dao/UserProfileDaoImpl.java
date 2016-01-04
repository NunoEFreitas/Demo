/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.dao;

import com.rnt.model.UserProfile;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nuno
 */
@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, UserProfile> implements UserProfileDao{

    public UserProfile findById(int id) {
        return getByKey(id);
    }

    public void saveUserProfile(UserProfile userProfile) {
        persist(userProfile);
    }

    public void deleteUserProfileById(int id) {
        Query query = getSession().createSQLQuery("delete from UserProfile where profile_id = :id");
	query.setString("id", Integer.toString(id));
        query.executeUpdate();
    }

    public List<UserProfile> listUserProfiles() {
        Criteria criteria = createEntityCriteria();
        return (List<UserProfile>) criteria.list();
    }
    
}

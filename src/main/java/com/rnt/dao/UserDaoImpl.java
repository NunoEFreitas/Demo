/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.dao;

import com.rnt.model.Employee;
import com.rnt.model.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nuno
 */

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{
    

    public User findById(int id) {
        return getByKey(id);
    }

    public void saveUser(User user) {
        persist(user);
    }

    public void deleteUserByNif(int nif) {
        Query query = getSession().createSQLQuery("delete from User where user_nif = :nif");
	query.setString("nif", Integer.toString(nif));
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }

    public User findUserByNif(int nif) {
        Criteria criteria = createEntityCriteria();
	criteria.add(Restrictions.eq("nif", nif));
	return (User) criteria.uniqueResult();
    }

    public List<User> fingUserByName(String name) {
          Criteria criteria = getSession().createCriteria(User.class);
          criteria.add(Restrictions.eq("name", name));
          return (List<User>) criteria.list();
          /*
          Query query = getSession().createSQLQuery("select from User where user_name = :name");
          query.setString("name", name);
          return query.list();
          */
    }

    public void deleteUserById(int id) {
        Query query = getSession().createSQLQuery("delete from User where user_id = :id");
	query.setString("id", Integer.toString(id));
        query.executeUpdate();
        
    }

    public User findUserByEmail(String email) {
        Criteria criteria = createEntityCriteria();
	criteria.add(Restrictions.eq("email",email));
	return (User) criteria.uniqueResult();
    }
    
    
    
}

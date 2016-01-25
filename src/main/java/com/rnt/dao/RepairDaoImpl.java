/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.dao;

import com.rnt.model.Material;
import com.rnt.model.Repair;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nuno
 */
@Repository("repairDao")
public class RepairDaoImpl extends AbstractDao<Integer, Repair> implements RepairDao{

    public Repair findById(int id) {
         return getByKey(id);
    }

    public void saveRepair(Repair repair) {
        persist(repair);
    }

    public void deleteRepairById(int id) {
        Query query = getSession().createSQLQuery("delete from repair where repair_id = :id");
	query.setString("id", Integer.toString(id));
        query.executeUpdate();
    }

    public List<Repair> findAllRepairs() {
        Criteria criteria = createEntityCriteria();
        return (List<Repair>) criteria.list();
    }

    public List<Repair> findRepairsByUser(int userId) {
        Criteria criteria = getSession().createCriteria(Repair.class);
        criteria.add(Restrictions.eq("user_user_id", userId));
        return (List<Repair>) criteria.uniqueResult();
    }

    public List<Repair> findRepairsByClient(int clientId) {
        Criteria criteria = getSession().createCriteria(Repair.class);
        criteria.add(Restrictions.eq("client_client_id", clientId));
        return (List<Repair>) criteria.uniqueResult();
    }

    public List<Repair> findRepairsByStatus(int statusId) {
        Criteria criteria = getSession().createCriteria(Repair.class);
        criteria.add(Restrictions.eq("repair_status_status_id", statusId));
        return (List<Repair>) criteria.uniqueResult();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.dao;

import com.rnt.model.RepairStatus;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nuno
 */
@Repository("repairStatusDao")
public class RepairStatusDaoImpl extends AbstractDao<Integer, RepairStatus> implements RepairStatusDao{

    public RepairStatus findById(int id) {
        return getByKey(id);
    }

    public void saveRepairStatus(RepairStatus repairStatus) {
        persist(repairStatus);
    }

    public void deleteRepairStatusById(int id) {
        Query query = getSession().createSQLQuery("delete from RepairStatus where status_id = :id");
	query.setString("id", Integer.toString(id));
        query.executeUpdate();
    }

    public List<RepairStatus> listRepairStatus() {
        Criteria criteria = createEntityCriteria();
        return (List<RepairStatus>) criteria.list();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.service;

import com.rnt.dao.RepairDao;
import com.rnt.model.Repair;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nuno
 */
@Service("repairService")
@Transactional
public class RepairServiceImpl implements RepairService{
    
    @Autowired
    private RepairDao dao;

    public Repair findById(int id) {
        return dao.findById(id);
    }

    public void saveRepair(Repair repair) {
        dao.saveRepair(repair);
    }

    public void deleteRepairById(int id) {
        dao.deleteRepairById(id);
    }

    public List<Repair> findAllRepairs() {
        return dao.findAllRepairs();
    }

    public List<Repair> findRepairsByUser(int userId) {
        return dao.findRepairsByUser(userId);
    }

    public List<Repair> findRepairsByClient(int clientId) {
        return dao.findRepairsByClient(clientId);
    }

    public List<Repair> findRepairsByStatus(int statusId) {
        return dao.findRepairsByStatus(statusId);
    }

    public void updateRepair(Repair repair) {
        Repair entity = dao.findById(repair.getId());
	if(entity!=null){
            entity.setClient(repair.getClient());
            entity.setEndDate(repair.getEndDate());
            entity.setHoursSpend(repair.getHoursSpend());
            entity.setObservation(repair.getObservation());
            entity.setPrice(repair.getPrice());
            entity.setSerialNumber(repair.getSerialNumber());
            entity.setStatus(repair.getStatus());
            entity.setStartDate(repair.getStartDate());
            entity.setUser(repair.getUser());
	}
    }
    
}

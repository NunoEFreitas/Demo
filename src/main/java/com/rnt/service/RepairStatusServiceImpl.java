/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.service;

import com.rnt.dao.RepairStatusDao;
import com.rnt.model.RepairStatus;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nuno
 */
@Service("repairStatusService")
@Transactional
public class RepairStatusServiceImpl implements RepairStatusService{
    
    @Autowired
    private RepairStatusDao dao;

    public RepairStatus findById(int id) {
        return dao.findById(id);
    }

    public void saveRepairStatus(RepairStatus repairStatus) {
        dao.saveRepairStatus(repairStatus);
    }

    public void deleteRepairStatusById(int id) {
        dao.deleteRepairStatusById(id);
    }

    public List<RepairStatus> listRepairStatus() {
        return dao.listRepairStatus();
    }

    public void updateRepairStatus(RepairStatus repairStatus) {
        RepairStatus entity = dao.findById(repairStatus.getId());
        if(entity!=null){
            entity.setDesignation(repairStatus.getDesignation());
        }
    }
    
}

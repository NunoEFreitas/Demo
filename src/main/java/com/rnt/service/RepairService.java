/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.service;

import com.rnt.model.Repair;
import java.util.List;

/**
 *
 * @author Nuno
 */
public interface RepairService {
    
        Repair findById(int id);

	void saveRepair(Repair repair);
        
        void deleteRepairById(int id);
	
	List<Repair> findAllRepairs();

	List<Repair> findRepairsByUser(int userId);
        
        List<Repair> findRepairsByClient(int clientId);
        
        List<Repair> findRepairsByStatus(int statusId);
        
        void updateRepair(Repair repair);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.dao;

import com.rnt.model.Repair;
import java.util.List;

/**
 *
 * @author Nuno
 */
public interface RepairDao {
    
        Repair findById(int id);

	void saveRepair(Repair repair);
        
        void deleteRepairById(int id);
	
	List<Repair> findAllRepairs();

	List<Repair> findRepairsByUser(int user);
        
        List<Repair> findRepairsByClient(int client);
        
        List<Repair> findRepairsByStatus(int status);
        
    
}

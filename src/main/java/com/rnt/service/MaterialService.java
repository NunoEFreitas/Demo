/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.service;

import com.rnt.model.Material;
import java.util.List;

/**
 *
 * @author Nuno
 */
public interface MaterialService {
    
        Material findById(int id);
	
	void saveMaterial(Material material);
	
	void updateMaterial(Material material);

	List<Material> findAllMaterials(); 

        Material findMaterialByDesignation(String designation);
        
        void deleteMaterialById(int id);
    
}

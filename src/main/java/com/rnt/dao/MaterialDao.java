/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.dao;

import com.rnt.model.Material;
import java.util.List;

/**
 *
 * @author Nuno
 */
public interface MaterialDao {
    
    Material findById(int id);
    
    void saveMaterial(Material material);
    
    void deleteMaterialById(int id);
    
    List<Material> listAllMaterials();
    
    Material listMaterialByDesignation(String designation);
    
}

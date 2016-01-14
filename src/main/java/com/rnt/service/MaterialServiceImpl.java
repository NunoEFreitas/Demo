/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.service;

import com.rnt.dao.MaterialDao;
import com.rnt.model.Material;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nuno
 */
@Service("materialService")
@Transactional
public class MaterialServiceImpl implements MaterialService{
    
    @Autowired
    private MaterialDao dao;

    public Material findById(int id) {
       return dao.findById(id);
    }

    public void saveMaterial(Material material) {
        dao.saveMaterial(material);
    }

    public void updateMaterial(Material material) {
        Material entity = dao.findById(material.getId());
	if(entity!=null){
            entity.setDesignation(material.getDesignation());
            entity.setBuyPrice(material.getBuyPrice());
            entity.setSellPrice(material.getSellPrice());
	}
    }

    public List<Material> findAllMaterials() {
        return dao.listAllMaterials();
    }

    public List<Material> findMaterialByDesignation(String designation) {
        return dao.listMaterialByDesignation(designation);
    }

    public void deleteMaterialById(int id) {
        dao.deleteMaterialById(id);
    }
    
}

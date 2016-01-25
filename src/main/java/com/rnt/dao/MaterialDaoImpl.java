/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.dao;

import com.rnt.model.Material;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nuno
 */
@Repository("materialDao")
public class MaterialDaoImpl extends AbstractDao<Integer, Material> implements MaterialDao{

    public Material findById(int id) {
        return getByKey(id);
    }

    public void saveMaterial(Material material) {
        persist(material);
    }

    public void deleteMaterialById(int id) {
        Query query = getSession().createSQLQuery("delete from material where material_id = :id");
	query.setString("id", Integer.toString(id));
        query.executeUpdate();
    }

    public List<Material> listAllMaterials() {
        Criteria criteria = createEntityCriteria();
        return (List<Material>) criteria.list();
    }

    public Material listMaterialByDesignation(String designation) {
        Criteria criteria = getSession().createCriteria(Material.class);
          criteria.add(Restrictions.eq("designation", designation));
          return (Material) criteria.uniqueResult();
    }
    
}

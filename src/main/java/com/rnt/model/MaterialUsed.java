/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Nuno
 */

//@Entity
//@Table(name="MATERIALUSED")
public class MaterialUsed {
    /*
    private Material materialId;
    private Repair repairId;
    private int quantity;

    
    @Id
    @ManyToOne()
    @JoinColumn(name="MATERIAL_MATERIAL_ID")
    public Material getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Material materialId) {
        this.materialId = materialId;
    }

    
    @Id
    @ManyToOne()
    @JoinColumn(name="REPAIR_REPAIR_ID")
    public Repair getRepairId() {
        return repairId;
    }

    public void setRepairId(Repair repairId) {
        this.repairId = repairId;
    }

    @NotEmpty
    @Column(name = "QUANTITY", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    */
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.controller;

import com.rnt.model.Material;
import com.rnt.service.MaterialService;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Nuno
 */
@Controller
@RequestMapping("/")
public class MaterialController {
    
    @Autowired
    MaterialService materialService;
    
    @Autowired
    HttpSession session;
    
        @RequestMapping(value = {"/newmaterial"}, method = RequestMethod.GET)
	public String newMaterial(ModelMap model,HttpSession session) {
                Material material = new Material();
		model.addAttribute("material", material);
                model.addAttribute("edit", false);
		return "newmaterial";
	}
        
        @RequestMapping(value = {"/newmaterial"}, method = RequestMethod.POST)
	public String saveMaterial(@Valid Material material,BindingResult result,ModelMap model,HttpSession session) {
                if (result.hasErrors()) {
			return "newmaterial";
		}
                if(materialService.findMaterialByDesignation(material.getDesignation())!=null){
                    model.addAttribute("error", "Material already registered with " +material.getId() + " ID");
                    return "newmaterial";
                }
                materialService.saveMaterial(material);
		model.addAttribute("message", "Material " + material.getDesignation() + " registered successfully");
                String destiny;
                if(session.getAttribute("role").equals("admin")){
                    destiny = "mainadmin";
                } else {
                    destiny = "mainrepairer";
                }
		return destiny;
	}
        
        @RequestMapping(value = { "/edit-{id}-material" }, method = RequestMethod.GET)
	public String editMaterial(@PathVariable int id, ModelMap model,HttpSession session) {
                Material material = materialService.findById(id);
		model.addAttribute("material", material);
		model.addAttribute("edit", true);
		return "newmaterial";
	}
        
        @RequestMapping(value = { "/edit-{id}-material" }, method = RequestMethod.POST)
	public String updateMaterial(@Valid Material material,BindingResult result,ModelMap model, @PathVariable int id,HttpSession session) {
                if (result.hasErrors()) {
			return "newmaterial";
		}
                materialService.updateMaterial(material);
                model.addAttribute("message", "Material " + material.getDesignation() + " updated successfully");
		                String destiny;
                if(session.getAttribute("role").equals("admin")){
                    destiny = "mainadmin";
                } else {
                    destiny = "mainrepairer";
                }
		return destiny;
	}
        
        @RequestMapping(value = { "/delete-{id}-material" }, method = RequestMethod.GET)
	public String deleteMaterial(@PathVariable int id,HttpSession session) {
            materialService.deleteMaterialById(id);
            return "redirect:/listmaterials";
	}
        
        @RequestMapping(value = {"/listmaterials"}, method = RequestMethod.GET)
	public String listMaterials(ModelMap model,HttpSession session) {
                List<Material> material = materialService.findAllMaterials();
		model.addAttribute("material", material);
		return "listmaterials";
	}
    
}

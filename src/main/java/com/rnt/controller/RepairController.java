/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.controller;

import com.rnt.model.RepairStatus;
import com.rnt.service.RepairStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Nuno
 */
@Controller
@RequestMapping("/")
public class RepairController {
    
    @Autowired
    RepairStatusService repairService;
    
        @RequestMapping(value = {"/listrepairstatus"}, method = RequestMethod.GET)
	public String listStatus(ModelMap model) {
                List<RepairStatus> profiles = repairService.listRepairStatus();
		model.addAttribute("profiles", profiles);
		return "listprofiles";
	}
        
                @RequestMapping(value = {"/newrepairstatus"}, method = RequestMethod.GET)
	public String newStatus(ModelMap model) {
                RepairStatus repairStatus = new RepairStatus();
                model.addAttribute("userProfile", userProfile);
                model.addAttribute("edit", false);
		return "newprofile";
	}
        
        @RequestMapping(value = {"/newrepairstatus"}, method = RequestMethod.POST)
	public String saveStatus(@Valid UserProfile userProfile,BindingResult result,ModelMap model) {
            if (result.hasErrors()) {
                return "newprofile";
            }
               userProfileService.saveUserProfile(userProfile);
               model.addAttribute("message", "User Profile " + userProfile.getDesignation() + " registered successfully");
               return "mainadmin";
	}
        
        @RequestMapping(value = { "/edit-{id}-status" }, method = RequestMethod.GET)
	public String editStatus(@PathVariable int id, ModelMap model) {
                UserProfile userProfile = userProfileService.findById(id);
                model.addAttribute("userProfile",userProfile);
		model.addAttribute("edit", true);
		return "newprofile";
	}
        
        // edit works, but user always have to select a profile, issue to be solved
        @RequestMapping(value = { "/edit-{id}-status" }, method = RequestMethod.POST)
	public String updateStatus(@Valid UserProfile userProfile,BindingResult result,ModelMap model, @PathVariable int id) {
                if (result.hasErrors()) {
			return "newprofile";
		}
                userProfileService.updateUserProfile(userProfile);
                model.addAttribute("message", "User " + userProfile.getDesignation() + " updated successfully");
		return "mainadmin";
	}
        
        @RequestMapping(value = { "/delete-{id}-status" }, method = RequestMethod.GET)
	public String deleteStatus(@PathVariable int id) {
                userProfileService.deleteUserProfileById(id);
		return "redirect:/listrepairstatus";
	}
    
}

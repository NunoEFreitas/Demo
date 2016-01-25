/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.controller;

import com.rnt.model.Client;
import com.rnt.model.Repair;
import com.rnt.model.RepairStatus;
import com.rnt.model.User;
import com.rnt.service.ClientService;
import com.rnt.service.RepairService;
import com.rnt.service.RepairStatusService;
import com.rnt.service.UserService;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
public class RepairController {
    
    @Autowired
    RepairStatusService repairStatusService;
    
    @Autowired
    RepairService repairService;
    
    @Autowired
    ClientService clientService;
    
    @Autowired
    UserService userService;
        
    @Autowired
    HttpSession session;
    
        @RequestMapping(value = {"/listrepairstatus"}, method = RequestMethod.GET)
	public String listRepairStatus(ModelMap model) {
                List<RepairStatus> profiles = repairStatusService.listRepairStatus();
		model.addAttribute("profiles", profiles);
		return "listrepairstatus";
	}
        
        @RequestMapping(value = {"/newrepairstatus"}, method = RequestMethod.GET)
	public String newRepairStatus(ModelMap model) {
                RepairStatus repairStatus = new RepairStatus();
                model.addAttribute("repairStatus", repairStatus);
                model.addAttribute("edit", false);
		return "newrepairstatus";
	}
        
        @RequestMapping(value = {"/newrepairstatus"}, method = RequestMethod.POST)
	public String saveRepairStatus(@Valid RepairStatus repairStatus,BindingResult result,ModelMap model) {
            if (result.hasErrors()) {
                return "newrepairstatus";
            }
            repairStatusService.saveRepairStatus(repairStatus);
               model.addAttribute("message", "Repair Status " + repairStatus.getDesignation() + " registered successfully");
               return "mainadmin";
	}
        
        @RequestMapping(value = { "/edit-{id}-status" }, method = RequestMethod.GET)
	public String editRepairStatus(@PathVariable int id, ModelMap model) {
                RepairStatus repairStatus = repairStatusService.findById(id);
                model.addAttribute("repairStatus",repairStatus);
		model.addAttribute("edit", true);
		return "newrepairstatus";
	}
        
        // edit works, but user always have to select a profile, issue to be solved
        @RequestMapping(value = { "/edit-{id}-status" }, method = RequestMethod.POST)
	public String updateRepairStatus(@Valid RepairStatus repairStatus,BindingResult result,ModelMap model, @PathVariable int id) {
                if (result.hasErrors()) {
			return "newrepairstatus";
		}
                repairStatusService.updateRepairStatus(repairStatus);
                model.addAttribute("message", "Repair Status " + repairStatus.getDesignation() + " updated successfully");
		return "mainadmin";
	}
        
        @RequestMapping(value = { "/delete-{id}-status" }, method = RequestMethod.GET)
	public String deleteRepairStatus(@PathVariable int id) {
            repairStatusService.deleteRepairStatusById(id);
		return "redirect:/listrepairstatus";
	}
        
        @RequestMapping(value = {"/newrepair"}, method = RequestMethod.GET)
	public String newRepair(ModelMap model, HttpSession session) {
                Repair repair = new Repair();
                RepairStatus repairStatus = new RepairStatus();
                Client client = new Client();
                User user = userService.findById((Integer)session.getAttribute("userId"));
                model.addAttribute("client", client);
                model.addAttribute("repair", repair);
                model.addAttribute("user", user);
                model.addAttribute("repairStatus", repairStatus);
                model.addAttribute("edit", false);
		return "newrepair";
	}
    
}

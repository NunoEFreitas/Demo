/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.controller;

import com.rnt.model.Client;
import com.rnt.model.UserProfile;
import com.rnt.service.ClientService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Nuno
 */
@Controller
@RequestMapping("/")
public class ClientController {
    
    @Autowired
    ClientService clienteService;
    
        @RequestMapping(value = {"/newclient"}, method = RequestMethod.GET)
	public String listProfiles(ModelMap model) {
                Client client = new Client();
		model.addAttribute("client", client);
		return "newclient";
	}
        
        @RequestMapping(value = {"/newclient"}, method = RequestMethod.POST)
	public String saveUser(@Valid Client client,BindingResult result,ModelMap model) {
                if (result.hasErrors()) {
			return "newclient";
		}
                if(clienteService.findClientByEmail(client.getEmail())!=null || clienteService.findClientByTelephone(client.getTelephone())!=null){
                    model.addAttribute("error", "Client email ou telephone already registered with " +client.getId() + " ID");
                    return "newclient";
                }
                clienteService.saveClient(client);
		model.addAttribute("message", "Client " + client.getName() + " registered successfully");
                String destiny;
                if(model.get("role").equals("logista")){
                    destiny = "mainstore";
                } else {
                    destiny = "mainrepairer";
                }
		return destiny;
	}
    
}

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
public class ClientController {
    
    @Autowired
    ClientService clienteService;
    
    @Autowired
    HttpSession session;
    
        @RequestMapping(value = {"/newclient"}, method = RequestMethod.GET)
	public String newClient(ModelMap model,HttpSession session) {
                Client client = new Client();
		model.addAttribute("client", client);
                model.addAttribute("edit", false);
		return "newclient";
	}
        
        @RequestMapping(value = {"/newclient"}, method = RequestMethod.POST)
	public String saveClient(@Valid Client client,BindingResult result,ModelMap model,HttpSession session) {
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
                if(session.getAttribute("role").equals("logista")){
                    destiny = "mainstore";
                } else {
                    destiny = "mainrepairer";
                }
		return destiny;
	}
        
        @RequestMapping(value = { "/edit-{id}-client" }, method = RequestMethod.GET)
	public String editClient(@PathVariable int id, ModelMap model,HttpSession session) {
                Client client = clienteService.findById(id);
		model.addAttribute("client", client);
		model.addAttribute("edit", true);
		return "newclient";
	}
        
        @RequestMapping(value = { "/edit-{id}-client" }, method = RequestMethod.POST)
	public String updateClient(@Valid Client client,BindingResult result,ModelMap model, @PathVariable int id,HttpSession session) {
                if (result.hasErrors()) {
			return "newclient";
		}
                clienteService.updateClient(client);
                model.addAttribute("message", "Client " + client.getName() + " updated successfully");
		                String destiny;
                if(session.getAttribute("role").equals("logista")){
                    destiny = "mainstore";
                } else {
                    destiny = "mainrepairer";
                }
		return destiny;
	}
        
        @RequestMapping(value = { "/delete-{id}-client" }, method = RequestMethod.GET)
	public String deleteClient(@PathVariable int id,HttpSession session) {
            clienteService.deleteClientById(id);
            return "redirect:/listclients";
	}
        
        @RequestMapping(value = {"/listclients"}, method = RequestMethod.GET)
	public String listClients(ModelMap model,HttpSession session) {
                List<Client> client = clienteService.findAllClients();
		model.addAttribute("client", client);
		return "listclients";
	}
        
    
}

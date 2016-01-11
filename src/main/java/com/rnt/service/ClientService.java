/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.service;

import com.rnt.model.Client;
import java.util.List;

/**
 *
 * @author Nuno
 */
public interface ClientService {
    
        Client findById(int id);
	
	void saveClient(Client client);
	
	void updateClient(Client client);

	List<Client> findAllClients(); 
	
	Client findClientByTelephone(int telephone);

        List<Client> findClientByName(String name);
        
        void deleteClientById(int id);
        
        Client findClientByEmail(String email);
    
}

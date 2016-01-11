/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.dao;

import com.rnt.model.Client;
import java.util.List;

/**
 *
 * @author Nuno
 */
public interface ClientDao {
    
        Client findById(int id);

	void saveClient(Client client);
        
        void deleteClientById(int id);
	
	List<Client> findAllClients();

	Client findUserByTelephone(int telephone);
        
        List<Client> fingClientByName(String name);
        
        Client findClientByEmail(String email);
    
}

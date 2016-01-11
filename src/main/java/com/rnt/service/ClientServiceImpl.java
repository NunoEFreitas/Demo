/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.service;

import com.rnt.dao.ClientDao;
import com.rnt.model.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nuno
 */

@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService{
    
    @Autowired
    private ClientDao dao;

    public Client findById(int id) {
        return dao.findById(id);
    }

    public void saveClient(Client client) {
        dao.saveClient(client);
    }

    public void updateClient(Client client) {
        Client entity = dao.findById(client.getId());
	if(entity!=null){
            entity.setAddress(client.getAddress());
            entity.setEmail(client.getEmail());
            entity.setName(client.getName());
            entity.setTelephone(client.getTelephone());
	}
    }

    public List<Client> findAllClients() {
        return dao.findAllClients();
    }

    public Client findClientByTelephone(int telephone) {
        return dao.findUserByTelephone(telephone);
    }

    public List<Client> findClientByName(String name) {
        return dao.fingClientByName(name);
    }

    public void deleteClientById(int id) {
        dao.deleteClientById(id);
    }

    public Client findClientByEmail(String email) {
        return dao.findClientByEmail(email);
    }
    
    
}

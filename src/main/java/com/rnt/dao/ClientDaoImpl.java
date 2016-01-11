/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.dao;

import com.rnt.model.Client;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nuno
 */
@Repository("clientDao")
public class ClientDaoImpl extends AbstractDao<Integer, Client> implements ClientDao {

    public Client findById(int id) {
        return getByKey(id);
    }

    public void saveClient(Client client) {
        persist(client);
    }

    public void deleteClientById(int id) {
        Query query = getSession().createSQLQuery("delete from Client where client_id = :id");
	query.setString("id", Integer.toString(id));
        query.executeUpdate();
    }

    public List<Client> findAllClients() {
        Criteria criteria = createEntityCriteria();
        return (List<Client>) criteria.list();
    }

    public Client findUserByTelephone(int telephone) {
        Criteria criteria = createEntityCriteria();
	criteria.add(Restrictions.eq("telephone",telephone));
	return (Client) criteria.uniqueResult();
    }

    public List<Client> fingClientByName(String name) {
          Criteria criteria = getSession().createCriteria(Client.class);
          criteria.add(Restrictions.eq("name", name));
          return (List<Client>) criteria.list();
    }

    public Client findClientByEmail(String email) {
        Criteria criteria = createEntityCriteria();
	criteria.add(Restrictions.eq("email",email));
	return (Client) criteria.uniqueResult();
    }
    
}

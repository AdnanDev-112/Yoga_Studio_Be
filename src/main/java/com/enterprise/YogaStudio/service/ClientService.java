package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.model.Client;
import com.enterprise.YogaStudio.model.Instructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {



    public List<Client> getClientList();

    void addClient(Client client);
    public Client getClientById(Integer id);

    Client updateClient(Integer id, Client client);

    void deleteClient(Integer id);
}

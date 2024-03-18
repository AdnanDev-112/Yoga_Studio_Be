package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.model.Client;
import com.enterprise.YogaStudio.repository.ClientRepository;
import com.enterprise.YogaStudio.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClientList() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }


    @Override
    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void addClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client updateClient(Integer id, Client clientdetails) {
        return clientRepository.findById(id)
                .map(client -> {
                    client.setClientName(clientdetails.getClientName());
                    client.setEmail(clientdetails.getEmail());
                    client.setAddress(clientdetails.getAddress());
                    client.setTelnum(clientdetails.getTelnum());
                    client.setDob(clientdetails.getDob());
                    return clientRepository.save(client);
                })
                .orElse(null);
    }



}

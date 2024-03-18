package com.enterprise.YogaStudio.controller;

import com.enterprise.YogaStudio.model.Client;
import com.enterprise.YogaStudio.model.Studio;
import com.enterprise.YogaStudio.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "http://localhost:3000")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/getclientlist")
    public List<Client> getClientList() {
        return clientService.getClientList();
    }
    @GetMapping("/getclient/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Integer id) {
        Client client = clientService.getClientById(id);
        if (client != null) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addclient")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        Studio std = new Studio();
        std.setId(1);
        client.setStudio(std);
        clientService.addClient(client);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateclient/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Integer id, @RequestBody Client client) {
        Client updatedClient = clientService.updateClient(id, client);
        if (updatedClient != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteclient/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Integer id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}

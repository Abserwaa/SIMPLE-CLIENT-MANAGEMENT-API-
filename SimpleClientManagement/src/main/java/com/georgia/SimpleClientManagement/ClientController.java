package com.georgia.SimpleClientManagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/clients")
public class ClientController {

     @Autowired
     private ClientService clientService;

     // Get all clients
     @GetMapping
     public List<Client> getAllClients() {
          return clientService.getAllClients();
     }

     // Get a client by ID
     @GetMapping("/{id}")
     public Client getClient(@PathVariable Long id) {
         return clientService.getClient(id);
          
     }

     //Create a new client profile
     @PostMapping
     public String createClient(@RequestBody Client client) {
          clientService.createClient(client);
          return "Client profile created successfully";
      }
     
      //Update a client's Profile
     @PutMapping("/{id}")
     public String updateClient(@PathVariable Long id, @RequestBody Client client) {
          clientService.updateClient(id,client);
          return "Client profile updated successfully";
     }
      
     //Delete a client's Profile by ID
     @DeleteMapping("/{id}")
     public String deleteClient(@PathVariable Long id) {
          clientService.deleteClient(id);
          return "Client profile deleted successfully";
     }
}

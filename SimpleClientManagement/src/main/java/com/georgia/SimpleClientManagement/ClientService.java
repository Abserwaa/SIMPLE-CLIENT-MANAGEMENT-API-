package com.georgia.SimpleClientManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.georgia.SimpleClientManagement.Exception.ClientNotFoundException;

@Service
public class ClientService {
   @Autowired
   private ClientRepository clientRepository;

   public ClientService (ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
   }

     
    public List<Client> getAllClients() {
        return clientRepository.findAll();

}

public Client getClient(Long clientId) {
    if(clientRepository.findById(clientId).isEmpty())
        throw new ClientNotFoundException("Requested Client Profile does not exist");
    return clientRepository.findById(clientId).get();
    }

    public String createClient(Client client) {
        clientRepository.save(client);
        return "Success";
    }
    public String updateClient(Long id, Client updatedClient) {
        // Check if the client exists
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client not found with ID: " + id));

        // Update the fields
        existingClient.setName(updatedClient.getName());
        existingClient.setAddress(updatedClient.getAddress());
        existingClient.setAge(updatedClient.getAge());
        existingClient.setMedicalCondition(updatedClient.getMedicalCondition());

        // Save the updated client
        clientRepository.save(existingClient);
        return "Client profile updated successfully";
   

    }

    // Delete an Client by its ID
    public void deleteClient(Long id) {
    clientRepository.deleteById(id);
    }
}

   
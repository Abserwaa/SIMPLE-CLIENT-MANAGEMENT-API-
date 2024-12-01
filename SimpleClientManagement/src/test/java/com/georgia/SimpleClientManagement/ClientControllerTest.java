package com.georgia.SimpleClientManagement;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ClientService clientService;

    private Client testClient;

    @BeforeEach
    void setUp() {
        testClient = new Client("John Doe", 38, "3 Pheasant Way", "Dementia");
    }

    @Test
    public void testGetAllClients() throws Exception {
        List<Client> clients = Arrays.asList(testClient);
        when(clientService.getAllClients()).thenReturn(clients);

        mockMvc.perform(get("/api/clients"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("John Doe"));
    }

    @Test
    public void testGetClient() throws Exception {
        when(clientService.getClient(anyLong())).thenReturn(testClient);

        mockMvc.perform(get("/api/clients/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("John Doe"));
    }

    @Test
    public void testCreateClient() throws Exception {
        String clientJson = "{\"name\":\"John Doe\"}";

        mockMvc.perform(post("/api/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .content(clientJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Client profile created successfully"));

        verify(clientService, times(1)).createClient(any(Client.class));
    }

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testUpdateClient() throws Exception {
        Long clientId = 1L;
        Client updatedClient = new Client("Jane Doe Updated", 31, "456 Main St", "None");
        String updatedClientJson = objectMapper.writeValueAsString(updatedClient);

        when(clientService.updateClient(eq(clientId), any(Client.class)))
                .thenReturn("Client profile updated successfully");

        mockMvc.perform(put("/api/clients/{id}", clientId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedClientJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Client profile updated successfully"));

        verify(clientService, times(1)).updateClient(eq(clientId), any(Client.class));
    }

    @Test
    public void testDeleteClient() throws Exception {
        mockMvc.perform(delete("/api/clients/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Client profile deleted successfully"));

        verify(clientService, times(1)).deleteClient(anyLong());
    }
}
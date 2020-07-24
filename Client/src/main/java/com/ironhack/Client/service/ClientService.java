package com.ironhack.Client.service;

import com.ironhack.Client.exceptions.ClientNotFoundException;
import com.ironhack.Client.model.Client;
import com.ironhack.Client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll(){ return clientRepository.findAll(); }
    public Client findById(Integer id) { return clientRepository.findById(id).orElseThrow(()-> new ClientNotFoundException("Client not found")); }
    public Client create(Client client) { return clientRepository.save(client); }
}

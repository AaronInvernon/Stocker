package com.inronhack.Employee.service;

import com.inronhack.Employee.exception.ClientNotFoundException;
import com.inronhack.Employee.exception.EmployeeNotFoundException;
import com.inronhack.Employee.model.Client;
import com.inronhack.Employee.model.Employee;
import com.inronhack.Employee.repository.ClientRepository;
import com.inronhack.Employee.repository.EmployeeRepository;
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

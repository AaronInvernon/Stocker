package com.ironhack.EdgeService.service;

import com.ironhack.EdgeService.client.BillClient;
import com.ironhack.EdgeService.exceptions.BillServiceDownException;
import com.ironhack.EdgeService.model.Bill.Bill;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillClient billClient;

    @HystrixCommand(fallbackMethod = "errorFindAll")
    public List<Bill> findAll(){ return billClient.findAll(); }

    public List<Bill> errorFindAll() {
        throw new BillServiceDownException("Bill Service Down Exception. Method: findAll. ");
    }

    @HystrixCommand(fallbackMethod = "errorFindById")
    public Bill findById(Integer id){ return billClient.findById(id); }

    public Bill errorFindById() {
        throw new BillServiceDownException("Bill Service Down Exception. Method: findById. ");
    }

    @HystrixCommand(fallbackMethod = "errorCreate")
    public Bill create(Bill order){ return billClient.create(order); }

    public Bill errorCreate() {
        throw new BillServiceDownException("Bill Service Down Exception. Method: create. ");
    }

    @HystrixCommand(fallbackMethod = "errorFindByClientId")
    public List<Bill> findByClientId(Integer clientId){ return billClient.findByClientId(clientId); }

    public Bill errorFindByClientId() {
        throw new BillServiceDownException("Bill Service Down Exception. Method: findByClientId. ");
    }
}

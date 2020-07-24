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

    public Bill errorFindById(Integer id) {
        throw new BillServiceDownException("Bill Service Down Exception. Method: findById. ");
    }

    @HystrixCommand(fallbackMethod = "errorCreate")
    public Bill create(Bill bill){ return billClient.create(bill); }

    public Bill errorCreate(Bill bill) {
        throw new BillServiceDownException("Bill Service Down Exception. Method: create. ");
    }

    @HystrixCommand(fallbackMethod = "errorFindByClientId")
    public List<Bill> findByClientId(Integer clientId){ return billClient.findByClientId(clientId); }

    public List<Bill> errorFindByClientId(Integer clientId) {
        throw new BillServiceDownException("Bill Service Down Exception. Method: findByClientId. ");
    }
}

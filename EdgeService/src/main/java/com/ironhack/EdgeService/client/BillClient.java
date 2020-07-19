package com.ironhack.EdgeService.client;

import com.ironhack.EdgeService.model.Bill.Bill;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "bill-service")
public interface BillClient {

    @PostMapping("/bills")
    public Bill create(@RequestBody Bill bill);

    @GetMapping("/bills")
    public List<Bill> findAll();

    @GetMapping("/bills/{id}")
    public Bill findById(@PathVariable Integer id);

    @GetMapping("/bills/client/{id}")
    public List<Bill> findByClientId(@PathVariable(name = "id") Integer clientId);
}

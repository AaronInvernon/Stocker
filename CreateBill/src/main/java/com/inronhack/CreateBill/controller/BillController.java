package com.inronhack.CreateBill.controller;

import com.inronhack.CreateBill.model.Bill;
import com.inronhack.CreateBill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillController {
    @Autowired
    private BillService billService;

    @PostMapping("/bills")
    @ResponseStatus(HttpStatus.CREATED)
    public Bill create(@RequestBody Bill bill){ return billService.create(bill); }

    @GetMapping("/bills")
    @ResponseStatus(HttpStatus.OK)
    public List<Bill> findAll(){ return billService.findAll(); }

    @GetMapping("/bills/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Bill findById(@PathVariable Integer id){ return billService.findById(id); }

    @GetMapping("/bills/client/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Bill> findByClientId(@PathVariable(name = "id") Integer clientId){ return billService.findByClientId(clientId); }
}

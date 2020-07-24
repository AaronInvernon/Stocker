package com.inronhack.CreateBill.service;

import com.inronhack.CreateBill.exceptions.BillNotFoundException;
import com.inronhack.CreateBill.model.Bill;
import com.inronhack.CreateBill.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    @Autowired
    private BillRepository billRepository;

    public Bill create(Bill bill){ return billRepository.save(bill); }
    public List<Bill> findAll(){ return billRepository.findAll(); }
    public Bill findById(Integer id){ return billRepository.findById(id).orElseThrow(()-> new BillNotFoundException("Bill not found")); }
    public List<Bill> findByClientId(Integer clientId){ return billRepository.findByClientId(clientId); }
}

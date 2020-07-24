package com.inronhack.CreateBill.service;

import com.inronhack.CreateBill.model.Bill;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BillServiceTest {
    @Autowired
    private BillService billService;

    @Test
    void create() {
        Bill bill2 = new Bill(1, 1, new BigDecimal("110"));
        billService.create(bill2);
        assertEquals(1, bill2.getClientId());
    }
}
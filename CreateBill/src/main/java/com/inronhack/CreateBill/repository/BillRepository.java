package com.inronhack.CreateBill.repository;

import com.inronhack.CreateBill.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    @Query("SELECT b FROM Bill b WHERE clientId=:clientID")
    public List<Bill>findByClientId(@Param(value = "clientId") Integer clientId);
}

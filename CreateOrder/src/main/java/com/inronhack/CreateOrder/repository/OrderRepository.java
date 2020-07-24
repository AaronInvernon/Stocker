package com.inronhack.CreateOrder.repository;

import com.inronhack.CreateOrder.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT o FROM Order o WHERE clientId=:clientId")
    public List<Order> findByClientId(@Param(value="clientId") Integer clientId);

    @Query("SELECT o FROM Order o WHERE employeeId=:employeeId")
    public List<Order> findByEmployeeId(@Param(value="employeeId") Integer employeeId);
}

package com.rft.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rft.entities.OrderStatusChange;


public interface OrderStatusChangeRepository extends JpaRepository<OrderStatusChange, Long>{
	List<OrderStatusChange> findByOrderid(String orderid);
	List<OrderStatusChange> findByOrderstatusid(long orderstatusid);
	List<OrderStatusChange> findAll();
}

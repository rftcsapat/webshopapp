package com.rft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rft.entities.OrderStatus;

public interface OrderStatusRepository  extends JpaRepository<OrderStatus, Long>{

	OrderStatus findByOrderstatusid(String orderstatusid);
	List<OrderStatus> findAll();
}

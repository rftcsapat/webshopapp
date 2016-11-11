package com.rft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rft.entities.Orders;

public interface OrdersRepository  extends JpaRepository<Orders, Long>{
	Orders findByOrderrowid(long orderrowid);
	List<Orders> findByOrderid(long orderid);
	List<Orders> findByItemid(long itemid);
	List<Orders> findAll();
}




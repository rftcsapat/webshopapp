package com.rft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rft.entities.OrderHead;


public interface OrderHeadRepository extends JpaRepository<OrderHead, Long>{
	OrderHead findByOrderid(String orderid);
	List<OrderHead> findByUserid(long userid);
	List<OrderHead> findAll();
}

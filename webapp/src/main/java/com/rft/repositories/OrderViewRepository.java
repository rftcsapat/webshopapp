package com.rft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rft.entities.OrderView;

public interface OrderViewRepository extends JpaRepository<OrderView, Long> {
	OrderView findByOrderid(long orderid);
	List<OrderView> findByUserid(long userid);
	List<OrderView> findByItemid(long itemid);
	List<OrderView> findByOrderstatusid(long orderstatusid);
	List<OrderView> findDistinctOrderViewsByUseridAndOrderstatusid(Long userid, Long orderstatusid);
	List<OrderView> findByUseridAndOrderstatusid(Long userid, Long orderstatusid);
	List<OrderView> findAll();
}


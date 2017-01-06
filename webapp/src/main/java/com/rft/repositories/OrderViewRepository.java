package com.rft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rft.entities.OrderView;

public interface OrderViewRepository extends JpaRepository<OrderView, Long> {
	OrderView findByOrderid(long orderid);
	List<OrderView> findByUserid(long userid);
	List<OrderView> findByItemid(long itemid);
	List<OrderView> findByOrderstatusid(long orderstatusid);
	List<OrderView> findDistinctOrderViewsByUseridAndOrderstatusid(Long userid, Long orderstatusid);
	List<OrderView> findByUseridAndOrderstatusid(Long userid, Long orderstatusid);
	List<OrderView> findAll();
	 @Query("select  count(distinct o.orderid) from OrderView o where o.statusdate=:nap and o.orderstatusid=2")
	 Long find(@Param("nap")  String nap);
	 
	 @Query("select max(o.orderprice) from OrderView o " +
			"where :start<=o.statusdate and :end>=o.statusdate " +
			"and o.orderstatusid=2 group by o.orderid")
	 List<Long> find(@Param("start") String start,@Param("end")  String end);
		 
}


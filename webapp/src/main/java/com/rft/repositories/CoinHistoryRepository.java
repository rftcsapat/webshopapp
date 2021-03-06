package com.rft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rft.entities.CoinHistory;

public interface CoinHistoryRepository  extends JpaRepository<CoinHistory, Long>{
	CoinHistory findByCoinhistoryid(Long coinshistoryid);
	List<CoinHistory> findByUserid(Long userid);
	List<CoinHistory> findAll();
}


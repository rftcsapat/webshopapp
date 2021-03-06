package com.rft.repositories;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rft.entities.SearchInStock;
import com.rft.entities.Stock;


public interface SearchInStockRepository extends CrudRepository<SearchInStock,Long> {
//    @Procedure(procedureName = "SearchItems")
//    Page<Stock> SearchItemsInStock(
//    		Pageable pageable,
//    		@Param("itemname") String itemname,
//    		@Param("manufacturerid") Long manufacturerid,
//    		@Param("categoryid") Long categoryid,
//    		@Param("minprice") Long minprice,
//    		@Param("maxprice") Long maxprice);
    
    @Procedure(procedureName = "SearchItems")
    List<Object> SearchItemsInStock(
    		@Param("itemname") String itemname,
    		@Param("manufacturerid") Long manufacturerid,
    		@Param("categoryid") Long categoryid,
    		@Param("minprice") Long minprice,
    		@Param("maxprice") Long maxprice);    
}
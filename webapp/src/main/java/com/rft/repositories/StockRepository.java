package com.rft.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rft.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock findByItemname(String itemname);
    Stock findByItemid(long itemid);
    List<Stock> findByCategoryname(String categoryname);
    Page<Stock> findByCategoryname(Pageable pageable, String categoryname);
    List<Stock> findByCategoryid(String categoryid);
    List<Stock> findByManufacturername(String manufacturername);
    List<Stock> findByManufacturerid(String manufacturerid);
//    @Query(value = "SELECT * from Stock s where 'itemname'='' or s.itemname like ('%'+'itemname'+'%')) and ('manufacturerid'=-1 or 'manufacturerid'=s.manufacturerid) and ('categoryid'=-1 or 'categoryid'=s.categoryid)",
//            nativeQuery=true
//    )
//    public List<Stock> findAll(String itemname, Long manufacturerid, Long categoryid);
    
    @Query("SELECT e FROM Stock e WHERE " +
    	      "(:itemname='' or e.itemname like ('%'+:itemname+'%')) and"  +
    	      "(:manufacturerid=-1 or :manufacturerid=e.manufacturerid) and" + 
    	      "(:categoryid=-1 or :categoryid=e.categoryid) and" +
    	      "(:minprice=-1 or :minprice<=e.price) and" +
    	      "(:maxprice=-1 or :maxprice>=e.price)" )
    List<Stock> find(
    		   @Param("itemname")       String itemname,
               @Param("manufacturerid") Integer manufacturerid,
               @Param("categoryid")     Integer categoryid,
               @Param("minprice")       Integer minprice,
               @Param("maxprice")       Integer maxprice);
    
    @Query("SELECT e FROM Stock e WHERE " +
  	      "(:itemname='' or e.itemname like ('%'+:itemname+'%')) and"  +
  	      "(:manufacturerid=-1 or :manufacturerid=e.manufacturerid) and" + 
  	      "(:categoryid=-1 or :categoryid=e.categoryid) and" +
  	      "(:minprice=-1 or :minprice<=e.price) and" +
  	      "(:maxprice=-1 or :maxprice>=e.price)" )
    Page<Stock> find(
  			 Pageable pagable,
  		     @Param("itemname")       String itemname,
             @Param("manufacturerid") Integer manufacturerid,
             @Param("categoryid")     Integer categoryid,
             @Param("minprice")       Integer minprice,
             @Param("maxprice")       Integer maxprice);
    
    List<Stock> findAll();
}
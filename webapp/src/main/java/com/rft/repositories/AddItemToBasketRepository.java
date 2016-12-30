package com.rft.repositories;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rft.entities.AddItemToBasket;;

public interface AddItemToBasketRepository extends CrudRepository<AddItemToBasket,Long> {
    @Procedure(procedureName = "addItem", outputParameterName = "ret")
   // void inOnlyTest(Long userid,Long itemid,Long quantity,Long ret);
    void addToBasket(@Param("userid") Long userid, @Param("itemid") Long itemid, @Param("quantity") Long quantity, @Param("ret") Long ret);
//    AddItemToBasket addToBasket(@Param("userid") Long userid, @Param("itemid") Long itemid, @Param("quantity") Long quantity, @Param("ret") Long ret);
}

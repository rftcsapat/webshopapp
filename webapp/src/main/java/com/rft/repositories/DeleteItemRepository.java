package com.rft.repositories;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rft.entities.DeleteItem;

public interface DeleteItemRepository extends CrudRepository<DeleteItem,Long> {
    @Procedure(procedureName = "deleteitem", outputParameterName = "ret")
    void DeleteItem(@Param("itemid") Long itemid, @Param("ret") Long ret);
    //Csak olyan itemet lehet törölni amiből nincs rendelés.

}

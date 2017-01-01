package com.rft.repositories;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rft.entities.ItemUpload;

public interface ItemUploadRepository extends CrudRepository<ItemUpload,Long> {
	 @Procedure(procedureName = "itemupload", outputParameterName = "ret")
	 void ItemUpload(
			 @Param("itemid") Long itemid,
			 @Param("itemname") String itemname,
			 @Param("description") String description,
			 @Param("picture") Byte[] picture,
			 @Param("price") Long price,
			 @Param("itemquantity") Long itemquantity,
			 @Param("unit") String unit,
			 @Param("largedesc") String largedesc,
			 @Param("manufacturerid") Long manufacturerid,
			 @Param("categoryid") Long categoryid,
			 @Param("quantity") Long email,
			 @Param("ret") Long ret);
}


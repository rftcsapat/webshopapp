package com.rft.repositories;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rft.entities.CoinUpload;
public interface CoinUploadRepository extends CrudRepository<CoinUpload,Long>{
	@Procedure(procedureName = "coinChange")
	void coinUpload(@Param("userid") Long userid, @Param("cash") Long cash, @Param("coins") Long coins);

}

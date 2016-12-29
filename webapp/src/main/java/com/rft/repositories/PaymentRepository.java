package com.rft.repositories;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rft.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment,Long>{
	@Procedure(procedureName = "payment")
	void Payment(@Param("userid") Long userid);

}

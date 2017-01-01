package com.rft.repositories;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rft.entities.InviteUser;

public interface InviteUserRepository extends CrudRepository<InviteUser,Long> {
	 @Procedure(procedureName = "invite", outputParameterName = "ret")
	 void inviteUser(@Param("userid") Long userid, @Param("email") String email, @Param("ret") Long ret);
}

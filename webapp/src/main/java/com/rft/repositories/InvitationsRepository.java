package com.rft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rft.entities.Invitations;


public interface InvitationsRepository extends JpaRepository<Invitations, Long> {
	Invitations findByEmail(String email);
	Invitations findByUserid(long userid);
	List<Invitations> findAll();
}

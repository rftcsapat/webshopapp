package com.rft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rft.entities.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long> {
	Roles findByRoleid(long roleid);
	List<Roles> findAll();
}

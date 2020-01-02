package org.neurobrain.tlozbotw.dao;

import java.util.Optional;

import org.neurobrain.tlozbotw.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDAO extends JpaRepository<Role, Long> {
	
	public Optional<Role> findByName(String name);
	public Optional<Role> findById(Long id);
	
}

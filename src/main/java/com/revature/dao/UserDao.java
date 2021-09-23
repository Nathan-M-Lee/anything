package com.revature.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.User;

@Repository
@Transactional
public interface UserDao extends JpaRepository<User, Integer>{
	
	public User findByLastName(String lastName);
	
	public Optional<User> findByUsername(String username);
	
	public User findByFirstNameIgnoreCase(String firstName);
	
	@Query(value="FROM User WHERE email LIKE %:substring")
	public User findByEmailContains(String substring);
	
}

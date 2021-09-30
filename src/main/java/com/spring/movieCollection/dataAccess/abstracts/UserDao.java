package com.spring.movieCollection.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.movieCollection.model.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	User findById(int id);
	
	

}

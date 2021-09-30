package com.spring.movieCollection.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "users_id",updatable = false)
	private int userId;
	
	@Column(name = "user_first_name",nullable = false)
	private String userFirstName;
	
	@Column(name = "user_last_name",nullable = false)
	private String userLastName;
	
	@Column(name = "username",nullable = false)
	private String username;
	
	@Column(name = "password",nullable = false)
	private String password;

}

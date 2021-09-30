package com.spring.movieCollection.model.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.spring.movieCollection.model.Dto.ActorDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "actors")
@NoArgsConstructor
public class Actor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "actor_id",updatable = false)
	private int actorId;
	
	@Column(name = "name",nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "actors",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MovieActor> movieActors = new ArrayList<>();
	

	public Actor (String name) {
		this.name = name;
	}
	
	public static Actor from(ActorDto actorDto) {
	    Actor actor = new Actor();
	    actor.setName(actorDto.getName());
	    return actor;
	  }

	  public static List<Actor> from(List<ActorDto> actorDto) {
		  return actorDto.stream().map(Actor::from).collect(Collectors.toList());
	  }
}

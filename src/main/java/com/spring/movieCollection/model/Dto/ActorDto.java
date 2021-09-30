package com.spring.movieCollection.model.Dto;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.movieCollection.model.entity.Actor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorDto {
	
	private int actorId;
	private String name;
	
	
	public static ActorDto from(Actor actor) {
		ActorDto actorDto = new ActorDto();
		actorDto.setActorId(actor.getActorId());
		actorDto.setName(actor.getName());
		
		return actorDto;
	
	}

	  
	  public static List<ActorDto> from(List<Actor> actors) {
	    
		  return actors.stream().map(ActorDto::from).collect(Collectors.toList());
	  }
	 
}

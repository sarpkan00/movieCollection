package com.spring.movieCollection.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MovieActorId implements Serializable{
	

	@Column(name = "movie_id")
	private int movieId;
	
	@Column(name = "actor_id")
	private int actorId;
	
	
	  @Override
	  public int hashCode() {
	    return Objects.hash(movieId, actorId);
	  }

	  @Override
	  public boolean equals(Object obj) {
	    if (this == obj) {
	      return true;
	    }
	    
	    if (obj == null || getClass() != obj.getClass()) {
	      return false;
	    }
	    
	    MovieActorId movieActorId = (MovieActorId) obj;
	    return Objects.equals(movieId, movieActorId.getMovieId()) &&
	        Objects.equals(actorId, movieActorId.getActorId());
	  }
	
	
	
}

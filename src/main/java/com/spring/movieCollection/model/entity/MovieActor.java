package com.spring.movieCollection.model.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "movie_actors")
public class MovieActor {
	
	@EmbeddedId
	private MovieActorId movieActorId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("movieId")
	@JoinColumn(name = "actor_id", foreignKey = @ForeignKey(name = "movie_actor_movie_id_fk"))
	private Movie movie;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("actorId")
	@JoinColumn(name = "actor_id",foreignKey = @ForeignKey(name = "movie_actor_actor_id_fk"))
	private Actor actor;
	
	@Column(name = "actor_role")
	private String actorRole;
	
	
	public MovieActor(Movie movie, Actor actor, String actorRole) {
	    this.movie = movie;
	    this.actor = actor;
	    this.actorRole = actorRole;
	    this.movieActorId = new MovieActorId(movie.getMovieId(), actor.getActorId());
	  
	}
	
	
}


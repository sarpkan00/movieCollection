package com.spring.movieCollection.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.movieCollection.model.Dto.ActorDto;
import com.spring.movieCollection.model.entity.Actor;

public interface ActorDao extends JpaRepository<Actor, Integer>{
	
	 @Query("update Actor a set a.name = :name where a.actorId = :Id")
	 void updateById(int performerId,String fullname);

	@Query("select new com.spring.movieCollection.model.Dto.ActorDto(a.actorId, a.name) from Actor a left outer join a.movieActors ma left outer join ma.movie m where m.movieId = :id")
	List<ActorDto> findAllByMovieId(int id);
}

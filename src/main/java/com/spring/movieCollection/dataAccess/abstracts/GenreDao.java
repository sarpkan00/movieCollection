package com.spring.movieCollection.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.movieCollection.model.entity.Genre;

@Repository
public interface GenreDao extends JpaRepository<Genre, Integer> {

	List<Genre> findAllByMoviesMovieId(int movieId);
	
	
	@Query("update Genre g set g.genreName = :name where g.genreId = :genreId")
	void updateById(int genreId, String name);
}

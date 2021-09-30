package com.spring.movieCollection.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.spring.movieCollection.model.entity.Movie;

@Repository
public interface MovieDao extends JpaRepository<Movie, Integer> {
	
	Movie getById(int id);
	
	
	@Query(value = "delete from movie_genre where movie_id = :movieId and genre_id = :genreId", nativeQuery = true)
	void deleteMovieGenre(int movieId, int genreId);

	
	@Query(value = "delete from movie_language where movie_id = :movieId and language_id = :languageId", nativeQuery = true)
	void deleteMovieLanguage(int movieId, int languageId);


}

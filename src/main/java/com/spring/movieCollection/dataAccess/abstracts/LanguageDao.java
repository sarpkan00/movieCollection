package com.spring.movieCollection.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.movieCollection.model.entity.Language;

@Repository
public interface LanguageDao extends JpaRepository<Language, Integer>{

	List<Language> findAllByMoviesMovieId(int movieId);
}

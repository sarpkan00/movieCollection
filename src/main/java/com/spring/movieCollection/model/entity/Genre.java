package com.spring.movieCollection.model.entity;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.spring.movieCollection.model.Dto.GenreDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "genres")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "genre_id",updatable = false)
	private int genreId;
	
	@Column(name = "genre_name",nullable = false)
	private String genreName;
	
	@ManyToMany(mappedBy = "genres")
	private List<Movie> movies;
	
	public Genre(String genreName) {
	    this.genreName = genreName;
	  
	}
	
	
	public static Genre from(GenreDto genreDto) {
	    Genre genre = new Genre();
	    genre.setGenreName(genreDto.getGenreName());
	    return genre;
	 
	}
	

	  public static List<Genre> from(List<GenreDto> genreDtos) {
		  return genreDtos.stream().map(Genre::from).collect(Collectors.toList());
	  
	  }

	
	

}

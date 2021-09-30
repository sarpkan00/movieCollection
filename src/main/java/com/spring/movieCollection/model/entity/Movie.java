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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.spring.movieCollection.model.Dto.MovieDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name="movies")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="movie_id",updatable = false)
	private int movieId;
	
	@Column(name="release_year", nullable = false)
	private int releaseYear;
	
	@Column(name="description",nullable = false)
	private String description;
	
	@Column(name="title",nullable = false)
	private String title;
	
	@Column(name="media_path",nullable = false)
	private String mediaPath;
	
	
	
	
	@ManyToMany()
	@JoinTable(name ="movie_genre", joinColumns =  @JoinColumn(name = "movie_id"),inverseJoinColumns = @JoinColumn(name = "genre_id"),
	uniqueConstraints = @UniqueConstraint(name = "movie_genre_unique",columnNames = {"movie_id","genre_id"}))
	private List<Genre> genres = new ArrayList<>();
	
	
	@ManyToMany()
	@JoinTable(name ="movie_language", joinColumns =  @JoinColumn(name = "movie_id"),inverseJoinColumns = @JoinColumn(name = "language_id"),
	uniqueConstraints = @UniqueConstraint(name = "movie_language_unique",columnNames = {"movie_id","language_id"}))
	private List<Language> languages = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "movie",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MovieActor> movieActors = new ArrayList<>();
	

	public Movie(String title, int releaseYear, String description, String mediaPath) {
	    this.title = title;
	    this.releaseYear = releaseYear;
	    this.description = description;
	    this.mediaPath = mediaPath;
	  
	}
	
	public static Movie from(MovieDto movieDTO) {
	    Movie movie = new Movie();
	    movie.setTitle(movieDTO.getTitle());
	    movie.setDescription(movieDTO.getDescription());
	    movie.setReleaseYear(movieDTO.getReleaseYear());
	    movie.setMediaPath(movieDTO.getMediaPath());
	    return movie;
	  }

	  public static List<Movie> from(List<MovieDto> movieDtos) {
	    return movieDtos.stream()
	            .map(Movie::from)
	            .collect(Collectors.toList());
	  }

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId+ ", title=" + title + '}';
				
	}
	
}















// Ad, Yayın Yılı, Tür, Açıklama, Medya, Dil seçenekleri 
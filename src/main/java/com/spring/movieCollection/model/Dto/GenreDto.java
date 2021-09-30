package com.spring.movieCollection.model.Dto;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.movieCollection.model.entity.Genre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenreDto {
	
	private int genreId;
	private String genreName;
	
	
	public static GenreDto from(Genre genre) {
		GenreDto genreDto = new GenreDto();
		genreDto.setGenreId(genre.getGenreId());
		genreDto.setGenreName(genre.getGenreName());
		return genreDto;
	}
	
	 public static List<GenreDto> from(List<Genre> genres) {
		    return genres.stream().map(GenreDto::from).collect(Collectors.toList());
	 }
}

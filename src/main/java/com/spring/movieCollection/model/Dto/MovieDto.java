package com.spring.movieCollection.model.Dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MovieDto {
	 
	private int movieId;
	private String title;
	private int releaseYear;
	private String description;
	private String mediaPath;
	private MultipartFile multipartFile;
	private List<Integer> selectedGenreIdList = new ArrayList<>();
	private List<Integer> selectedLanguageIdList = new ArrayList<>();
	private List<ActorDto> selectedPerformerDtoList = new ArrayList<>();
	
}

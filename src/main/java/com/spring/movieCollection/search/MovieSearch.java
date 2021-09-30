package com.spring.movieCollection.search;

import org.springframework.data.domain.Sort;

import lombok.Data;

@Data
public class MovieSearch {

	private int pageNumber = 0;
	private int pageSize = 5;
	
	private Sort.Direction direction = Sort.Direction.ASC;
	
	private String sortingBy = "releaseYear";
	
}

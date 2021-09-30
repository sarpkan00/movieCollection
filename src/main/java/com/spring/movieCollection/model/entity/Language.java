package com.spring.movieCollection.model.entity;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.spring.movieCollection.model.Dto.LanguageDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="languages")
@Entity
public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "language_id",updatable = false)
	private int languageId;
	
	@Column(name = "language_name",nullable = false)
	private String languageName;

	@ManyToMany()
	@JoinColumn(name = "languages")
	private List<Movie> movies;
	
	
	 public Language(String languageName) {
		    this.languageName = languageName;
		  }

		 
	 public static Language from(LanguageDto languageDTO) {
		    Language language = new Language();
		    language.setLanguageName(languageDTO.getLanguageName());
		    return language;
		  
	 }

		  
	 public static List<Language> from(List<LanguageDto> languageDtos) {
		 return languageDtos.stream().map(Language::from).collect(Collectors.toList());
		  
	 
	 }
}

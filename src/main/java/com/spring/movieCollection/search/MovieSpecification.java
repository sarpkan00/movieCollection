package com.spring.movieCollection.search;

import java.util.Locale;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.spring.movieCollection.model.entity.Movie;

public class MovieSpecification implements Specification<Movie>{

	 private String key;
	  private String value;

	  public MovieSpecification(String key, String value) {
	    this.key = key;
	    this.value = value;
	  }

	  @Override
	  public Predicate toPredicate(Root<Movie> root, CriteriaQuery<?> criteriaQuery,CriteriaBuilder criteriaBuilder) {

	    if(key.equals("name")) {
	      Join<Object, Object> p = root.join("performersAssoc").join("performer");
	      criteriaQuery.distinct(true);
	      return criteriaBuilder.like(
	          criteriaBuilder.lower(p.get(key)), "%" + value.toLowerCase(Locale.ROOT) + "%");
	    }else if(key.equals("genreName")) {
	      Join<Object, Object> g = root.join("genres");
	      criteriaQuery.distinct(true);
	      return criteriaBuilder.like(
	          criteriaBuilder.lower(g.get(key)), "%" + value.toLowerCase(Locale.ROOT) + "%");
	    }
	    return criteriaBuilder.like(
	        criteriaBuilder.lower(root.get(key)), "%" + value.toLowerCase(Locale.ROOT) + "%");
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
}

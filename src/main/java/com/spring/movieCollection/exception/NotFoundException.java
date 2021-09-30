package com.spring.movieCollection.exception;

public class NotFoundException extends RuntimeException {
	
	public <T> NotFoundException(T t, Class<?> c) {
	    super(String.format("id or username was not found", c.getName(), t) );

	}
}

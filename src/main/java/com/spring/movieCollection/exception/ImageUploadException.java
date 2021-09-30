package com.spring.movieCollection.exception;

public class ImageUploadException extends Exception{
	


	public ImageUploadException(String message) {
		super(String.format("image failed to load", message) );
	}

}

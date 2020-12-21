package br.com.LearningRestAPI.RestApiWithSpring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptionCustomizada extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ExceptionCustomizada(String exception ) {
		super(exception);
	}

}

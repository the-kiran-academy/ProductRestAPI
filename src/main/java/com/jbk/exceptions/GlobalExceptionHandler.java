package com.jbk.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public String resourceAlreadyExistsException( ResourceAlreadyExistsException exception) {
		return exception.getMessage();
	}
	
	@ExceptionHandler(ResourceNotExistsException.class)
	public String resourceNotExistsException( ResourceNotExistsException exception) {
		return exception.getMessage();
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public HashMap<String, Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex)
	{
	HashMap<String, Object> map = new HashMap<>();
	map.put("Time", new Date());
	
	
	BindingResult bindingResult = ex.getBindingResult();
	
	List<FieldError> fieldErrors = bindingResult.getFieldErrors();
	
//	for (FieldError fieldError : fieldErrors) {
//		
//		map.put(fieldError.getField(), fieldError.getDefaultMessage());
//	}
	
	
	ex.getBindingResult().getFieldErrors().forEach(error ->
	{
	map.put(error.getField(), error.getDefaultMessage());
	});
	return map;
	}

}

package com.roles.permission.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobelExceptionHandler{

	@ExceptionHandler(AccessDeniedException.class)
	@ResponseStatus(value = HttpStatus.FORBIDDEN)
	public @ResponseBody ErrorMessage handleAccessDeniedException(final AccessDeniedException exception) {

		ErrorMessage error = new ErrorMessage();
		error.setMessage("Access Denied");
		error.setMessageKey("accessDenied");
		return error;

	}
}

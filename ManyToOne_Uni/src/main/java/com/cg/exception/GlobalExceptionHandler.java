package com.cg.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	@ExceptionHandler(value = { NoStudentException.class, NoCourseException.class })
	public ErrorInformation handleNotFound(Exception ex, HttpServletRequest req) {
		String msg = ex.getMessage();
		String url = req.getRequestURI();
		LocalDateTime ldt = LocalDateTime.now();
		return new ErrorInformation(url, msg, ldt);
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	@ExceptionHandler(value = { Exception.class })
	public ErrorInformation handleInternalServerError(Exception ex, HttpServletRequest req) {
		String msg = ex.getMessage();
		String url = req.getRequestURI();
		LocalDateTime ldt = LocalDateTime.now();
		return new ErrorInformation(url, msg, ldt);
	}
}

package com.example.gateway.controllers;

import com.example.gateway.validators.exceptions.RequestValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandlerController {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity handleBindError(MethodArgumentNotValidException e) {
		List<Map<String, String>> errors = e.getFieldErrors().stream().map(error -> {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put(error.getField(), error.getDefaultMessage());
			return errorMap;
		}).toList();
		return ResponseEntity.badRequest().body(errors);
	}
	
	@ExceptionHandler
	ResponseEntity handleTransactionError(SQLException e) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("InternalError", "An Internal Error has occurred please contact admins!");
		return ResponseEntity.badRequest().body(errorMap);
	}
	
	@ExceptionHandler
	ResponseEntity handleValidationError(RequestValidationException e) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put(e.getField(), e.getMsg());
		return ResponseEntity.badRequest().body(errorMap);
	}
	
	//HttpMessageConversionException
	
}

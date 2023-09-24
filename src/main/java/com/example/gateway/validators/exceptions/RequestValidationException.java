package com.example.gateway.validators.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestValidationException extends RuntimeException {
	private final String field;
	private final String msg;
}

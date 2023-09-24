package com.example.gateway.validators;

import com.example.gateway.entities.Request;
import com.example.gateway.services.RequestService;
import com.example.gateway.validators.exceptions.RequestValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class RequestValidator {
	
	private final RequestService requestService;
	
	public void validate(Request request) {
		if (requestService.isRequestIdDuplicate(request.getRequestId())) {
			throw new RequestValidationException("requestId", "requestId is duplicated");
		}
	}
}
